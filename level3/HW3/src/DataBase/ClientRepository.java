package DataBase;
//pull
import Client.CredentialsEntry;
import Client.CredentialsEntry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientRepository {
    public CredentialsEntry authenticationDB(String login, String password) {
        Connection connection = ConnectionService.connect();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM DBClient WHERE login = ? AND password = ?");
            statement.setString(1,login);
            statement.setString(2,password);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return new CredentialsEntry(
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getString("nickName")
                );
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("SWW", e);
        } finally {
            ConnectionService.close(connection);
        }
    }

}

