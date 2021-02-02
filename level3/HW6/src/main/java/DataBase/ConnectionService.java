package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionService {
    private ConnectionService() {}

    public static Connection connect() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/chat?useUnicode=true&serverTimezone=UTC", "root", "root");
        } catch (SQLException t) {
            throw new RuntimeException("SWW", t);
        }
    }

    public static void rollback(Connection connection) {
        try {
            connection.rollback();
        } catch (SQLException t) {
            t.printStackTrace();
        }
    }

    public static void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException t) {
            t.printStackTrace();
        }
    }
}
