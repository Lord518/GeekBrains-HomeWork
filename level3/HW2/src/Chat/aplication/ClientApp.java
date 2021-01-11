package Chat.aplication;


import Chat.CredentialsEntry;
import Chat.RecordingMessage.InOutMessage;

public class ClientApp {
    public static void main(String[] args) {
       new CredentialsEntry.ClientChatAdapter("localhost", 8888);
       // InOutMessage.doBufferedWriterDemo("Hi");
       // InOutMessage.doBufferedWriterDemo("Hi");


    }
}
