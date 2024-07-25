import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/gestion de parc de vehicules";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection Connection;

    public static void main (String[] args){
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            if (Connection != null) {
                System.out.println("Connected to the database!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
            }
        }
        return Connection;
    }

    public static void closeConnection() {
        boolean Connection;
        if (Connection != null) {
            try {
                Connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
