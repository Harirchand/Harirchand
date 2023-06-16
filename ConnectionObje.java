package metro;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionObje {
	public static Connection getTheConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		return DriverManager.getConnection("jdbc:mysql://localhost:3306/metro_db","root","root");
	}
}
