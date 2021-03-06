package server;

import GUI.ChatFrame;
import RecordingMessage.InOutMessage;
import server.Chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Arrays;

public class ClientHandler {
    private String name;
    private DataInputStream in;
    private DataOutputStream out;
    private Socket socket;
    private Chat chat;

    public ClientHandler(Socket socket, Chat chat) {
        this.socket = socket;
        this.chat = chat;
        name = String.valueOf(socket.getPort());
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (Exception e) {
            throw new RuntimeException("SWW", e);
        }

        listen();
    }

    public String getName() {
        return name;
    }
    int timer = 10;
    private void listen() {
        new Thread(() -> {


            doAuth();

            receiveMessage();
        }).start();
    }

    private void doAuth() {
        sendMessage("Please enter credentials. Sample [-auth login password]");
        try {
            socket.setSoTimeout(120000);
            /**
             * -auth login password
             * sample: -auth l1 p1
             */
            while (true) {
                String mayBeCredentials = in.readUTF();

                if (mayBeCredentials.startsWith("-auth")) {
                    String[] credentials = mayBeCredentials.split("\\s");
                    String mayBeNickname = chat.getAuthenticationService()
                            .findNicknameByLoginAndPassword(credentials[1], credentials[2]);
                    if (mayBeNickname != null) {
                        if (!chat.isNicknameOccupied(mayBeNickname)) {
                            sendMessage("[INFO] Auth OK");
                            socket.setSoTimeout(0);
                            name = mayBeNickname;

                            chat.broadcastMessage(String.format("[%s] logged in", name));
                            chat.subscribe(this);
                            sendMessage(InOutMessage.doReaderMessages());
                            return;
                        } else {
                            sendMessage("[INFO] Current user is already logged in.");
                        }
                    } else {
                        sendMessage("[INFO] Wrong login or password.");
                    }
                }
            }
        }catch (SocketTimeoutException e){
            sendMessage("Auth time is over. Socket is close!");
            chat.unsubscribe(this);
            try {
                socket.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        catch (Exception e) {
            throw new RuntimeException("SWW", e);
        }
    }

    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            throw new RuntimeException("SWW", e);
        }
    }


    public void receiveMessage() {
        while (true) {
            try {
                String message = in.readUTF();
                if (message.startsWith("-exit")) {
                    chat.unsubscribe(this);
                    chat.broadcastMessage(String.format("[%s] logged out", name));
                    in.close();
                    break;
                }
                if (message.startsWith("-pm")) {
                    String[] credentials = message.split("\\s");
                    String Nickname =  credentials[1];
                    String pm = Arrays.toString(credentials);
                    //"pm from: "+getName()+" "+ credentials[2];
                    chat.privateMessage(Nickname,pm);
                    sendMessage(pm);
                }else {
                    chat.broadcastMessage(String.format("[%s]: %s", name, message));}
            } catch (IOException e) {
                throw new RuntimeException("SWW", e);
            }
        }
    }



}
