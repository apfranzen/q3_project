package Main;

/**
 * Created by adamfranzen on 11/8/16.
 */
        import java.sql.DriverManager;
        import java.sql.Connection;
        import java.sql.SQLException;

public class Db {

    public static Connection Db() {

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(
                    "jdbc:postgresql:pomodoro");

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }

        return connection;
    }
}
