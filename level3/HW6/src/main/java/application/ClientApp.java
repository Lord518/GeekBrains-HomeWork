package application;


import Client.CredentialsEntry;
import RecordingMessage.InOutMessage;

public class ClientApp {
    public static void main(String[] args) {
       new CredentialsEntry.ClientChatAdapter("localhost", 4444);
    }
}