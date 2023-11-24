package PROGRAM;

import java.sql.*;

public class Connect {
	static Connection conn = null;

	public static Connection getConnect(String x) {
		Connection conn = null;

		// ket noi
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://127.0.0.1:3306/" + "novabank";
			String user = "root";
			String pass = "050602";

			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("Thành công");
		}

		catch (Exception ex) {
			System.out.println("Không thành công: " + " " + ex.getMessage());
			ex.printStackTrace();
		}
		return conn;
		////////////////
	}

	public static void closeConnection() throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}

}
