import java.sql.*;

public class JDBC {
    private static String url = "jdbc:mysql://localhost/ifsc_prova?useSSL=false";
    private static String user = "root";
    private static String pwd = "";

    public static Statement getStatement(String sqlCommand) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, pwd);
            return connection.createStatement();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static PreparedStatement prepareStatement(String sqlCommand) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, pwd);
            return connection.prepareStatement(sqlCommand);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
