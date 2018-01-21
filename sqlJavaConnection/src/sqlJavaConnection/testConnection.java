package sqlJavaConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readData();
	}

	public static void readData() {
		String url = "jdbc:mysql://localhost/javaConnection";
		String login = "root";
		String password = "";

		Connection cnx = null;
		Statement stmt = null;
		ResultSet rslt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnx = DriverManager.getConnection(url, login, password);
			stmt = cnx.createStatement();
			String sql = "Select * from persons";
			rslt = stmt.executeQuery(sql);
			// return only the type
			System.out.println(rslt);

			while (rslt.next()) {
				System.out.println(rslt.getString("FirstName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				cnx.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
