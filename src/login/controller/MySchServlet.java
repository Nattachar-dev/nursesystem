package login.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import login.database.Connect;
import login.model.Schedule;

/**
 * Servlet implementation class MySchServlet
 */
@WebServlet("/MySchServlet" )
public class MySchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 @Override  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 try {
			 	Connect dbConnect = new Connect();
		        Connection con = dbConnect.connect();
	            
	            List<Schedule> progs = new ArrayList<Schedule>();
	            int i = 0;
	            
	            ResultSet rs = con.createStatement().executeQuery("SELECT  d.dur_name ,s.date FROM schedule_nurse s, duration d WHERE name_id='6005105470'AND d.dur_id=s.duration");
	            
	            while (rs.next()) {
	                Schedule sc = new Schedule();
	                sc.setId(i);
	                sc.setDur(rs.getString("d.dur_name"));
	                sc.setDate(rs.getString("s.date"));
	                progs.add(sc);
	                i++;
	                
	            }
	            response.setContentType("application/json");
	            response.setCharacterEncoding("UTF-8");
	            PrintWriter out = response.getWriter();
	            out.write(new Gson().toJson(progs));
	            
	           
	            
	        } catch (SQLException ex) {
	            Logger.getLogger(MySchServlet.class.getName()).log(Level.SEVERE, null, ex);
	        }
	}

	


}
