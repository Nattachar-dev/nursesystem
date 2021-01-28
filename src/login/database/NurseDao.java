package login.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import login.model.*;

public class NurseDao {
	private Connection connection;
	
	public NurseDao(Connection connection) {
		this.connection = connection;	
	}
	public ArrayList <Nurse> findAll() throws SQLException{
		ArrayList<Nurse> Nurses = new ArrayList<>();
		Nurse nurse = null;
		
		Statement statement = this.connection.createStatement();
		String sqlText = "SELECT n.username, n.name, n.sex, n.Tel,n.Email,d.Dep_name FROM nurse n ,department d WHERE n.Dept = d.Dep_id  ";
		ResultSet resultSet= statement.executeQuery(sqlText);
		
		while(resultSet.next()) {
			nurse = new Nurse();
			nurse.setusername(resultSet.getString("username"));
			nurse.setname(resultSet.getString("name"));
			nurse.setSex(resultSet.getString("sex"));
			nurse.setDept(resultSet.getString("Dep_name"));
			nurse.setEmail(resultSet.getString("Email"));
			nurse.setTel(resultSet.getString("Tel"));
			
			Nurses.add(nurse);
		}
		resultSet.close();
		statement.close();
		return Nurses;
				
	}
}
