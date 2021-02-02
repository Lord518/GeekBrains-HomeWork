package server;


import Client.CredentialsEntry;
import DataBase.ClientRepository;

import java.util.HashSet;
import java.util.Set;

public class AuthenticationService {
    ClientRepository clientRepository;


    public AuthenticationService() {

        clientRepository = new ClientRepository();
    }

    public String findNicknameByLoginAndPassword(String login, String password) {

        CredentialsEntry entry = clientRepository.authenticationDB(login,password);

        if (!entry.equals(null)) {
            return entry.getNickname();
        }

        return null;
    }


}
