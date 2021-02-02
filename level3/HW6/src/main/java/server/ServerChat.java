package server;



import Client.Client;
import org.apache.log4j.Logger;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.LogManager;

public class ServerChat implements Chat {
    private static final Logger logger = Logger.getLogger(ServerChat.class);
    private ServerSocket serverSocket;
    private Set<ClientHandler> clients;
    private AuthenticationService authenticationService;

    public ServerChat() {
        start();
    }


    @Override
    public AuthenticationService getAuthenticationService() {
        return authenticationService;
    }
    private void start() {

        try {
            serverSocket = new ServerSocket( 4444);
            clients = new HashSet<>();
            authenticationService = new AuthenticationService();

            while (true) {
                logger.info("Server is waiting for a connection ...");
                //System.out.println("Server is waiting for a connection ...");
                Socket socket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(socket, this);
                logger.info(String.format("[%s] Chat.server.Chat.Client.Client[%s] is successfully logged in", new Date(), clientHandler.getName()));
               // System.out.println(String.format("[%s] Chat.server.Chat.Client.Client[%s] is successfully logged in", new Date(), clientHandler.getName()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void broadcastMessage(String message) {
        for (ClientHandler client : clients) {
            client.sendMessage(message);
        }
    }

    @Override
    public boolean isNicknameOccupied(String nickname) {
        for (ClientHandler client : clients) {
            if (client.getName().equals(nickname)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public synchronized void subscribe(ClientHandler client) {
        clients.add(client);
    }

    @Override
    public void unsubscribe(ClientHandler client) {
        clients.remove(client);
    }
    @Override
    public boolean privateMessage(String name, String message){
        for (ClientHandler client : clients) {
            if (client.getName().equals(name)) {
                client.sendMessage(message);
                return true;
            }
        }

        return false;
    }

    public static class ServerApp {
        public static void main(String[] args) {
            new ServerChat();
        }
    }
}