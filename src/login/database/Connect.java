package login.database;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connect {
	private static final String URL = "jdbc:mysql://localhost/sd_nurse";
	private static final String USER = "root";
	private static final String PASSWORD ="NTCT36442";
	private Connection connection;
	
	
	public Connection connect() {
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			 this.connection = DriverManager.getConnection(URL,USER,PASSWORD);
			 
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return this.connection;
	
	}
	public void close() throws SQLException {
		this.connection.close();
	}

}
