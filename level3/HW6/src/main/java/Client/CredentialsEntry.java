package Client;

import GUI.ChatFrame;
import server.Chat;


import java.util.function.Consumer;

public class CredentialsEntry {
    private String login;
    private String password;
    private String nickname;

    public CredentialsEntry(String login, String password, String nickname) {
        this.login = login;
        this.password = password;
        this.nickname = nickname;
    }


    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    @Override
    public String toString() {
        return "Client.Client.CredentialsEntry{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

    public static class ClientChatAdapter {
        private ChatFrame chatFrame;
        private Client client;

        public ClientChatAdapter(String host, int port) {
            client = new Client(host, port);
            chatFrame = new ChatFrame(new Consumer<String>() {
                @Override
                public void accept(String messageFromFormSubmitListener) {
                    client.sendMessage(messageFromFormSubmitListener);
                }
            });
            read();
        }

        private void read() {
            new Thread(() -> {
                try {
                    while (true) {
                        chatFrame.append(
                                client.receiveMessage()
                        );
                    }
                } catch (ClientConnectionException e) {
                    throw e;
                } finally {
                    if (client != null) {
                        client.close();
                    }
                }
            }).start();
        }
    }
}

