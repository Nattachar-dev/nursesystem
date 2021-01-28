package login.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import login.model.Leave;

public class leaveDuty {
	
	private Connection connection;
	
	public leaveDuty(Connection connection) {
		this.connection = connection;	
	}
	
	public  ArrayList <Leave> listAll() throws SQLException{
		ArrayList<Leave> L1 = new ArrayList<>();
		Leave l1 = null;
		
		Statement statement = this.connection.createStatement();
		String sqlText = "SELECT l.name,p.pos_name,l.date,d.dur_name,l.Description FROM leave_duty l, duration d, position p WHERE d.dur_id = l.Dur_id AND l.Pos_id = p.pos_id ";
		ResultSet rs= statement.executeQuery(sqlText);
		
		while(rs.next()) {
			
			l1 = new Leave();
			l1.setName(rs.getString("l.name"));
			l1.setPos(rs.getString("p.pos_name"));
			l1.setDate(rs.getString("l.date"));
			l1.setDur(rs.getString("d.dur_name"));
			l1.setDes(rs.getString("l.Description"));
			
			L1.add(l1);
			
			
		}
		rs.close();
		statement.close();
		return L1;
	}
	
	
	

}
