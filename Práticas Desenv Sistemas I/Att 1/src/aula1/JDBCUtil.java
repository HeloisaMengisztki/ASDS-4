package aula1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	private String url = "jdbc:mysql://localhost/exemplo";
	private String user = "newuser";
	private String password = "password";
	Connection connection = null;

	public Connection getConnection() {

		try {
			if (connection == null) {
				connection = DriverManager.getConnection(url, user, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
