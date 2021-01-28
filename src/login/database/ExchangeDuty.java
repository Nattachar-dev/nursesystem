package login.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import login.model.Exchange;



public class ExchangeDuty {
	private Connection connection;
	
	public ExchangeDuty(Connection connection) {
		this.connection = connection;	
	}
	
	
	public boolean add(Exchange Ex) throws SQLException{
		boolean addResult = false;
		Exchange newEx = Ex;
		
		String sqlText = "INSERT INTO exchage_duty(name1,date1,dur_id1,name2,date2,dur_id2,status) VALUES(?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = this.connection.prepareStatement(sqlText);
		preparedStatement.setString(1,newEx.getName1());
		preparedStatement.setString(2,newEx.getDate1());
		preparedStatement.setString(3,newEx.getDur_id1());
		preparedStatement.setString(4,newEx.getName2());
		preparedStatement.setString(5,newEx.getDate2());
		preparedStatement.setString(6,newEx.getDur_id2());
		preparedStatement.setString(7,newEx.getstatus());

		
		if (preparedStatement.executeUpdate() == 1) {
			addResult = true;
		}
		preparedStatement.close();
		return addResult;
		

	}
	
	
	public  ArrayList <Exchange> listAll() throws SQLException{
		ArrayList<Exchange> LEx = new ArrayList<>();
		Exchange lex = null;
		
		Statement statement = this.connection.createStatement();
		String sqlText = "SELECT e.name1,e.date1,d.dur_name,e.name2,e.date2,du.dur_name FROM exchage_duty e, duration d,duration du WHERE d.dur_id= e.dur_id1 AND du.dur_id=e.dur_id2";
		ResultSet rs= statement.executeQuery(sqlText);
		
		while(rs.next()) {
			
			lex = new Exchange();
			lex.setName1(rs.getString("e.name1"));
			lex.setDate1(rs.getString("e.date1"));
			lex.setDur_id1(rs.getString("d.dur_name"));
			lex.setName2(rs.getString("e.name2"));
			lex.setDate2(rs.getString("e.date2"));
			lex.setDur_id2(rs.getString("du.dur_name"));
	
			LEx.add(lex);
			
			
		}
		rs.close();
		statement.close();
		return LEx;
	}
	
}
