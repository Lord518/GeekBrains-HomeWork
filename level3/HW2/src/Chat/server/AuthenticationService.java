package Chat.server;
import Chat.CredentialsEntry;
import Chat.DataBase.ClientRepository;
//pull-request
import java.util.HashSet;
import java.util.Set;

public class AuthenticationService {
    private Set<CredentialsEntry> entries;
    ClientRepository clientRepository;


    public AuthenticationService() {
        entries = new HashSet<CredentialsEntry>();
        clientRepository = new ClientRepository();
    }

    public String findNicknameByLoginAndPassword(String login, String password) {
        CredentialsEntry cr = clientRepository.authenticationDB(login, password);
        if (!cr.equals(null)) {
            entries.add(cr);
            for (CredentialsEntry entry : entries) {
                if (entry.getLogin().equals(login) && entry.getPassword().equals(password)) {
                    return entry.getNickname();
                }
            }
        }
        return null;
    }


}
