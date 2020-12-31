package Chat.aplication;


import Chat.CredentialsEntry;

public class ClientApp {
    public static void main(String[] args) {
        new CredentialsEntry.ClientChatAdapter("localhost", 8888);
    }
}
