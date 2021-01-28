package login.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import login.model.MySch;
import login.model.Schedule;

public class manage_Sch{
	private Connection connection;
	
	public manage_Sch(Connection connection) {
		this.connection = connection;	
	}
	
	public  boolean add(Schedule sch)throws SQLException{
		boolean addResult = false;
		Schedule newSch = sch;
		
		String sqlText = "INSERT INTO schedule_nurse(name_id,dept_id,year,month,day,date,duration,role) VALUES(?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = this.connection.prepareStatement(sqlText);
		preparedStatement.setString(1,newSch.getName_id());
		preparedStatement.setString(2,newSch.getdep_id());
		preparedStatement.setString(3,newSch.getYear());
		preparedStatement.setString(4,newSch.getMonth());
		preparedStatement.setString(5,newSch.getDay());
		preparedStatement.setString(6,newSch.getDate());
		preparedStatement.setString(7,newSch.getDur());
		preparedStatement.setString(8,newSch.getRole());
		

		if (preparedStatement.executeUpdate() == 1) {
			addResult = true;
		}
		preparedStatement.close();
		return addResult;
			
		
	}
	

	public ArrayList<MySch> SchAll() throws SQLException{
		ArrayList<MySch>  mySch = new ArrayList<>();
		ArrayList<String> arrlist1 = new ArrayList<>();
		ArrayList<String> arrlist2 = new ArrayList<>();
		ArrayList<String> arrlist3 = new ArrayList<>();
		ArrayList<String> arrlist4 = new ArrayList<>();
		ArrayList<String> arrlist5 = new ArrayList<>();
		ArrayList<String> arrlist6 = new ArrayList<>();
		ArrayList<String> arrlist7 = new ArrayList<>();
		ArrayList<String> arrlist8= new ArrayList<>();
		ArrayList<String> arrlist9 = new ArrayList<>();
		ArrayList<String> arrlist10 = new ArrayList<>();
		ArrayList<String> arrlist11= new ArrayList<>();
		ArrayList<String> arrlist12= new ArrayList<>();
		ArrayList<String> arrlist13= new ArrayList<>();
		ArrayList<String> arrlist14= new ArrayList<>();
		ArrayList<String> arrlist15= new ArrayList<>();
		ArrayList<String> arrlist16= new ArrayList<>();
		ArrayList<String> arrlist17= new ArrayList<>();
		ArrayList<String> arrlist18= new ArrayList<>();
		ArrayList<String> arrlist19= new ArrayList<>();
		
		
		MySch schall1 = null;
		boolean status =false;
		
		int count = 0;
		int p =0;
		
		Statement statement1=null;
        ResultSet rs1 = null;
		Statement statement2=null;
        ResultSet rs2 = null;
        
        try {
        	String sqlText1="SELECT name FROM nurse WHERE number BETWEEN 1 AND 7";
        	String sqlText2= "SELECT d.dur_name FROM schedule_nurse s,duration d WHERE s.duration=d.dur_id ORDER BY name_id ASC,day ASC";
        	
        	statement1 = this.connection.createStatement();
            rs1= statement1.executeQuery(sqlText1);   
        	statement2 = this.connection.createStatement();
            rs2= statement2.executeQuery(sqlText2);
           
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
 
        if(status == false) {
        	while(rs2.next()) {
        		if(count < 30) {
        			arrlist1.add(rs2.getString("d.dur_name"));      			
        		}
        		else if(count>29 & count<60) {
        			arrlist2.add(rs2.getString("d.dur_name"));
        			
        		}
        		else if(count>59 & count<90) {
        			arrlist3.add(rs2.getString("d.dur_name"));
        		}
        		else if(count>89 & count<120) {
        			arrlist4.add(rs2.getString("d.dur_name"));
        		}
        		else if(count>119 & count<150) {
        			arrlist5.add(rs2.getString("d.dur_name"));
        		}
        		else if(count>149 & count<180) {
        			arrlist6.add(rs2.getString("d.dur_name"));
        		}
        		else if(count>179 & count<210) {
        			arrlist7.add(rs2.getString("d.dur_name"));
        		}
        		else if(count>209 & count<240) {
        			arrlist8.add(rs2.getString("d.dur_name"));
        		}
        		else if(count>89 & count<270) {
        			arrlist9.add(rs2.getString("d.dur_name"));
        		}
        		else if(count>89 & count<300) {
        			arrlist10.add(rs2.getString("d.dur_name"));
        		}
        		else if(count>89 & count<330) {
        			arrlist11.add(rs2.getString("d.dur_name"));
        		}
        		else if(count>89 & count<360) {
        			arrlist12.add(rs2.getString("d.dur_name"));
        		}
        		else if(count>89 & count<390) {
        			arrlist13.add(rs2.getString("d.dur_name"));
        		}
        		else if(count>89 & count<420) {
        			arrlist14.add(rs2.getString("d.dur_name"));
        		}
        		else if(count>89 & count<450) {
        			arrlist15.add(rs2.getString("d.dur_name"));
        		}
        		else if(count>89 & count<480) {
        			arrlist16.add(rs2.getString("d.dur_name"));
        		}
        		else if(count>89 & count<510) {
        			arrlist17.add(rs2.getString("d.dur_name"));
        		}
        		else if(count>89 & count<540) {
        			arrlist18.add(rs2.getString("d.dur_name"));
        		}
        		else if(count>89 & count<570) {
        			arrlist19.add(rs2.getString("d.dur_name"));
        		}
		
        		count =count+1;
 	
        	}
        	status = true;
        	
        }
        if(status == true) {
        	while(rs1.next()) {
        		schall1 = new MySch();
        		schall1.setName_id(rs1.getString("name"));
        		if(p==0) {
        			schall1.setD1(arrlist1.get(0));
                    schall1.setD2(arrlist1.get(1));
                    schall1.setD3(arrlist1.get(2));
                    schall1.setD4(arrlist1.get(3));
                    schall1.setD5(arrlist1.get(4));
                    schall1.setD6(arrlist1.get(5));
                    schall1.setD7(arrlist1.get(6));
                    schall1.setD8(arrlist1.get(7));
                    schall1.setD9(arrlist1.get(8));
                    schall1.setD10(arrlist1.get(9));
                    schall1.setD11(arrlist1.get(10));
                    schall1.setD12(arrlist1.get(11));
                    schall1.setD13(arrlist1.get(12));
                    schall1.setD14(arrlist1.get(13));
                    schall1.setD15(arrlist1.get(14));
                    schall1.setD16(arrlist1.get(15));
                    schall1.setD17(arrlist1.get(16));
                    schall1.setD18(arrlist1.get(17));
                    schall1.setD19(arrlist1.get(18));
                    schall1.setD20(arrlist1.get(19));
                    schall1.setD21(arrlist1.get(20));
                    schall1.setD22(arrlist1.get(21));
                    schall1.setD23(arrlist1.get(22));
                    schall1.setD24(arrlist1.get(23));
                    schall1.setD25(arrlist1.get(24));
                    schall1.setD26(arrlist1.get(25));
                    schall1.setD27(arrlist1.get(26));
                    schall1.setD28(arrlist1.get(27));
                    schall1.setD29(arrlist1.get(28));
                    schall1.setD30(arrlist1.get(29));
                    
                    mySch.add(schall1);
        		}
        		if(p==1) {
        			schall1.setD1(arrlist2.get(0));
                    schall1.setD2(arrlist2.get(1));
                    schall1.setD3(arrlist2.get(2));
                    schall1.setD4(arrlist2.get(3));
                    schall1.setD5(arrlist2.get(4));
                    schall1.setD6(arrlist2.get(5));
                    schall1.setD7(arrlist2.get(6));
                    schall1.setD8(arrlist2.get(7));
                    schall1.setD9(arrlist2.get(8));
                    schall1.setD10(arrlist2.get(9));
                    schall1.setD11(arrlist2.get(10));
                    schall1.setD12(arrlist2.get(11));
                    schall1.setD13(arrlist2.get(12));
                    schall1.setD14(arrlist2.get(13));
                    schall1.setD15(arrlist2.get(14));
                    schall1.setD16(arrlist2.get(15));
                    schall1.setD17(arrlist2.get(16));
                    schall1.setD18(arrlist2.get(17));
                    schall1.setD19(arrlist2.get(18));
                    schall1.setD20(arrlist2.get(19));
                    schall1.setD21(arrlist2.get(20));
                    schall1.setD22(arrlist2.get(21));
                    schall1.setD23(arrlist2.get(22));
                    schall1.setD24(arrlist2.get(23));
                    schall1.setD25(arrlist2.get(24));
                    schall1.setD26(arrlist2.get(25));
                    schall1.setD27(arrlist2.get(26));
                    schall1.setD28(arrlist2.get(27));
                    schall1.setD29(arrlist2.get(28));
                    schall1.setD30(arrlist2.get(29));
                    mySch.add(schall1);
	
        		}
        		if(p==2) {
        			schall1.setD1(arrlist3.get(0));
                    schall1.setD2(arrlist3.get(1));
                    schall1.setD3(arrlist3.get(2));
                    schall1.setD4(arrlist3.get(3));
                    schall1.setD5(arrlist3.get(4));
                    schall1.setD6(arrlist3.get(5));
                    schall1.setD7(arrlist3.get(6));
                    schall1.setD8(arrlist3.get(7));
                    schall1.setD9(arrlist3.get(8));
                    schall1.setD10(arrlist3.get(9));
                    schall1.setD11(arrlist3.get(10));
                    schall1.setD12(arrlist3.get(11));
                    schall1.setD13(arrlist3.get(12));
                    schall1.setD14(arrlist3.get(13));
                    schall1.setD15(arrlist3.get(14));
                    schall1.setD16(arrlist3.get(15));
                    schall1.setD17(arrlist3.get(16));
                    schall1.setD18(arrlist3.get(17));
                    schall1.setD19(arrlist3.get(18));
                    schall1.setD20(arrlist3.get(19));
                    schall1.setD21(arrlist3.get(20));
                    schall1.setD22(arrlist3.get(21));
                    schall1.setD23(arrlist3.get(22));
                    schall1.setD24(arrlist3.get(23));
                    schall1.setD25(arrlist3.get(24));
                    schall1.setD26(arrlist3.get(25));
                    schall1.setD27(arrlist3.get(26));
                    schall1.setD28(arrlist3.get(27));
                    schall1.setD29(arrlist3.get(28));
                    schall1.setD30(arrlist3.get(29));
                    mySch.add(schall1);

        		}
        		if(p==3) {
        			schall1.setD1(arrlist4.get(0));
                    schall1.setD2(arrlist4.get(1));
                    schall1.setD3(arrlist4.get(2));
                    schall1.setD4(arrlist4.get(3));
                    schall1.setD5(arrlist4.get(4));
                    schall1.setD6(arrlist4.get(5));
                    schall1.setD7(arrlist4.get(6));
                    schall1.setD8(arrlist4.get(7));
                    schall1.setD9(arrlist4.get(8));
                    schall1.setD10(arrlist4.get(9));
                    schall1.setD11(arrlist4.get(10));
                    schall1.setD12(arrlist4.get(11));
                    schall1.setD13(arrlist4.get(12));
                    schall1.setD14(arrlist4.get(13));
                    schall1.setD15(arrlist4.get(14));
                    schall1.setD16(arrlist4.get(15));
                    schall1.setD17(arrlist4.get(16));
                    schall1.setD18(arrlist4.get(17));
                    schall1.setD19(arrlist4.get(18));
                    schall1.setD20(arrlist4.get(19));
                    schall1.setD21(arrlist4.get(20));
                    schall1.setD22(arrlist4.get(21));
                    schall1.setD23(arrlist4.get(22));
                    schall1.setD24(arrlist4.get(23));
                    schall1.setD25(arrlist4.get(24));
                    schall1.setD26(arrlist4.get(25));
                    schall1.setD27(arrlist4.get(26));
                    schall1.setD28(arrlist4.get(27));
                    schall1.setD29(arrlist4.get(28));
                    schall1.setD30(arrlist4.get(29));
                    mySch.add(schall1);
        		}
        		if(p==4) {
        			schall1.setD1(arrlist5.get(0));
                    schall1.setD2(arrlist5.get(1));
                    schall1.setD3(arrlist5.get(2));
                    schall1.setD4(arrlist5.get(3));
                    schall1.setD5(arrlist5.get(4));
                    schall1.setD6(arrlist5.get(5));
                    schall1.setD7(arrlist5.get(6));
                    schall1.setD8(arrlist5.get(7));
                    schall1.setD9(arrlist5.get(8));
                    schall1.setD10(arrlist5.get(9));
                    schall1.setD11(arrlist5.get(10));
                    schall1.setD12(arrlist5.get(11));
                    schall1.setD13(arrlist5.get(12));
                    schall1.setD14(arrlist5.get(13));
                    schall1.setD15(arrlist5.get(14));
                    schall1.setD16(arrlist5.get(15));
                    schall1.setD17(arrlist5.get(16));
                    schall1.setD18(arrlist5.get(17));
                    schall1.setD19(arrlist5.get(18));
                    schall1.setD20(arrlist5.get(19));
                    schall1.setD21(arrlist5.get(20));
                    schall1.setD22(arrlist5.get(21));
                    schall1.setD23(arrlist5.get(22));
                    schall1.setD24(arrlist5.get(23));
                    schall1.setD25(arrlist5.get(24));
                    schall1.setD26(arrlist5.get(25));
                    schall1.setD27(arrlist5.get(26));
                    schall1.setD28(arrlist5.get(27));
                    schall1.setD29(arrlist5.get(28));
                    schall1.setD30(arrlist5.get(29));
                    mySch.add(schall1);
        			
        		}
        		if(p==5) {
        			schall1.setD1(arrlist6.get(0));
                    schall1.setD2(arrlist6.get(1));
                    schall1.setD3(arrlist6.get(2));
                    schall1.setD4(arrlist6.get(3));
                    schall1.setD5(arrlist6.get(4));
                    schall1.setD6(arrlist6.get(5));
                    schall1.setD7(arrlist6.get(6));
                    schall1.setD8(arrlist6.get(7));
                    schall1.setD9(arrlist6.get(8));
                    schall1.setD10(arrlist6.get(9));
                    schall1.setD11(arrlist6.get(10));
                    schall1.setD12(arrlist6.get(11));
                    schall1.setD13(arrlist6.get(12));
                    schall1.setD14(arrlist6.get(13));
                    schall1.setD15(arrlist6.get(14));
                    schall1.setD16(arrlist6.get(15));
                    schall1.setD17(arrlist6.get(16));
                    schall1.setD18(arrlist6.get(17));
                    schall1.setD19(arrlist6.get(18));
                    schall1.setD20(arrlist6.get(19));
                    schall1.setD21(arrlist6.get(20));
                    schall1.setD22(arrlist6.get(21));
                    schall1.setD23(arrlist6.get(22));
                    schall1.setD24(arrlist6.get(23));
                    schall1.setD25(arrlist6.get(24));
                    schall1.setD26(arrlist6.get(25));
                    schall1.setD27(arrlist6.get(26));
                    schall1.setD28(arrlist6.get(27));
                    schall1.setD29(arrlist6.get(28));
                    schall1.setD30(arrlist6.get(29));
                    mySch.add(schall1);
        			
        		}
        		if(p==6) {
        			schall1.setD1(arrlist7.get(0));
                    schall1.setD2(arrlist7.get(1));
                    schall1.setD3(arrlist7.get(2));
                    schall1.setD4(arrlist7.get(3));
                    schall1.setD5(arrlist7.get(4));
                    schall1.setD6(arrlist7.get(5));
                    schall1.setD7(arrlist7.get(6));
                    schall1.setD8(arrlist7.get(7));
                    schall1.setD9(arrlist7.get(8));
                    schall1.setD10(arrlist7.get(9));
                    schall1.setD11(arrlist7.get(10));
                    schall1.setD12(arrlist7.get(11));
                    schall1.setD13(arrlist7.get(12));
                    schall1.setD14(arrlist7.get(13));
                    schall1.setD15(arrlist7.get(14));
                    schall1.setD16(arrlist7.get(15));
                    schall1.setD17(arrlist7.get(16));
                    schall1.setD18(arrlist7.get(17));
                    schall1.setD19(arrlist7.get(18));
                    schall1.setD20(arrlist7.get(19));
                    schall1.setD21(arrlist7.get(20));
                    schall1.setD22(arrlist7.get(21));
                    schall1.setD23(arrlist7.get(22));
                    schall1.setD24(arrlist7.get(23));
                    schall1.setD25(arrlist7.get(24));
                    schall1.setD26(arrlist7.get(25));
                    schall1.setD27(arrlist7.get(26));
                    schall1.setD28(arrlist7.get(27));
                    schall1.setD29(arrlist7.get(28));
                    schall1.setD30(arrlist7.get(29));
                    mySch.add(schall1);
        			
        		}
        		p=p+1;
 	
        	}
        	
        }  
        
       

       rs1.close();
       statement1.close();	
       return mySch; 

	}
	
	
	
	public  boolean update(Schedule sch)throws SQLException{
		boolean updateResult = false;
		Schedule upSch = sch;
		Statement statement1=null;
        ResultSet rs = null;
		
		String sqlText1 = "UPDATE schedule_nurse SET display = 1 WHERE  username = ? AND month = ? AND year = ?";
		String sqlText2 = "SELECT name_id FROM schedule_nurse";
		statement1 = this.connection.createStatement();
        rs= statement1.executeQuery(sqlText2);  
        
		PreparedStatement preparedStatement = this.connection.prepareStatement(sqlText1);
		while(rs.next()) {
			preparedStatement.setString(1,rs.getString("name_id"));
			preparedStatement.setString(2,upSch.getMonth());
			preparedStatement.setString(3,upSch.getYear());		
		}
		
	
		if (preparedStatement.executeUpdate() == 1) {
			updateResult = true;
		}
		preparedStatement.close();
		return updateResult;
					
		
	}
	
	
}
