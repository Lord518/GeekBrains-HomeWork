import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Server {
    private ServerSocket serverSocket;
    private DataInputStream in;
    private DataOutputStream out;

    public Server() {
        start();
    }

    private void start() {
        try {
            serverSocket = new ServerSocket(8443);
           // System.out.println("Server is up and run...");
            /// System.out.println("Server info: " + serverSocket);

            //System.out.println("Server is waiting for a connection...");
            Socket client = serverSocket.accept();
            System.out.println("Client accepted: " + client);

            in = new DataInputStream(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());

            new Thread(() -> {
                try {
                    while (true) {
                        //вывод входящего сообщения
                        String message = in.readUTF();
                        System.out.println(new Date()+"Client : "+ message);
                        if (message.startsWith("-exit")) {
                            out.writeUTF("cmd EXIT: System shutdown");
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    close();
                }
            }).start();

            Scanner scanner = new Scanner(System.in);
            while (true) {
                String message = scanner.nextLine();
                if (client.isClosed()) {
                    System.out.println("Exit! Thanks! Bey!");
                    System.out.println("=======================");
                    break;
                }
                out.writeUTF(message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
        }



    }

    private void close() {
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//pull-request