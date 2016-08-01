package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	Connection connection;

	public Connection getConnection() throws Exception {
		try {
			String URLConnection = "jdbc:mysql://localhost:3306/cinema";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(URLConnection, "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public void closeResource () throws SQLException {
		if (connection != null) {
			if (!connection.isClosed()) {
				connection.close();
			}
		}
	}

}
