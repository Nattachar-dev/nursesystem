package login.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.database.Connect;
import login.database.createRandom;
import login.database.manage_Sch;
import login.model.Schedule;



/**
 * Servlet implementation class ManageServlet
 */
@WebServlet("/ManageServlet")
public class ManageServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		boolean addResult = false;	
		Connect dbConnect = new Connect();
        Connection connection = dbConnect.connect();
        manage_Sch manage_sch = new manage_Sch(connection);
        
        String month = request.getParameter("month_id");
        String nurse1 = request.getParameter("nurse1");
        String nurse2 = request.getParameter("nurse2");
        
        
        Statement statement=null;
        ResultSet rs = null;
        try {
            String sqlText = "SELECT * FROM nurse "+"WHERE  username<> '"+nurse1+"' AND username<>'"+nurse2+"'";
            statement = connection.createStatement();
            rs =  statement.executeQuery(sqlText);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    
        String d = null;
        String du = null;
        String date= null;
        String role= null;
        String dept = null;
        String nur_id= null;
        String year = "2020";
        int k = 0;
        int result=0;
        int i = 0;
        int count_fix = 3;
        int count_mor = 0;
        int count_aft = 0;
        int count_nig = 0;
        int count_stop = 0;
        boolean dur_succes = false;
        
        for( i= 1;i<count_fix;i++) {
            if(i==1){
                for(int j=1;j<24;j++) { 
                    nur_id = nurse1 ;
                    int[] result1 = createRandom.UniqueRandom(1,30); 
                    d = String.valueOf(result1[j]);
                    date = year+"-0"+month+"-"+d;
                    du = "1";
                    role = "1";
                    dept= "1";
                    Schedule sch1 = new Schedule(nur_id,dept,year,month,d,date,du,role);
                     try {
                         addResult = manage_sch.add(sch1);
                        } catch (SQLException e) {
                            
                            e.printStackTrace();
                        }
                    
                 }
                

            }
            if(i==2) {
                for(int j=1;j<24;j++) { 
                    nur_id = nurse2 ;
                    int[] result1 = createRandom.UniqueRandom(1,30); 
                    d = String.valueOf(result1[j]);
                    date = year+"-0"+month+"-"+d;
                    du = "1";
                    role = "5";
                    dept= "1";
                    Schedule sch2 = new Schedule(nur_id,dept,year,month,d,date,du,role);
                     try {
                         addResult = manage_sch.add(sch2);
                        } catch (SQLException e) {
                            
                            e.printStackTrace();
                        }
                    
                }

            }       
        }
        
        try {   
            for(k=1;k<31;k++) { 
            for(i=1;i<19;i++) { 
                rs.absolute(i);
                //k=1;
                nur_id = rs.getString("username");
                d = String.valueOf(k);
                date = year+"-"+month+"-"+d; 
                while(dur_succes != true) {
                    result = createRandom.BasicRandom(4, 1);     
                    du = String.valueOf(result);
                           if((result == 1)&&(count_mor < 2)){
                                   du = "1";
                                   count_mor = count_mor+1;
                                   dur_succes = true;
                             }                             
                           else if((result == 2)&&(count_aft < 3)){                     
                                    du = "2";
                                    count_aft = count_aft +1;
                                    dur_succes = true;              
                             }                            
                           else if((result == 3)&&(count_nig < 3)) {                            
                                    du = "3";
                                    count_nig =count_nig +1;
                                    dur_succes = true;                                             
                             }
                           else if((result == 4)&&(count_stop < 10)){
                                   du = "4";
                                   count_stop =count_stop+1;
                                   dur_succes = true;     
                           }                        
                           else {
                               dur_succes = false;
                           }
                       }        
                dur_succes = false;
                role =  rs.getString("position");
                dept= "1";
                Schedule sch3 = new Schedule(nur_id,dept,year,month,d,date,du,role);
                 try {
                     addResult = manage_sch.add(sch3);
                     sch3 = null;  
                     
                    } catch (SQLException e) {  
                        e.printStackTrace();
                    }    
                }             
            i=0;
            count_mor = 0;
            count_aft = 0;
            count_nig = 0;
            count_stop = 0;
            
            }   
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		
		
		addResult = true;

		request.setAttribute("addResult",addResult);
		request.getRequestDispatcher("result-manage.jsp").forward(request,response);
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
