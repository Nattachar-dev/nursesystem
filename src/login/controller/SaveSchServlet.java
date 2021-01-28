package login.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import login.database.Connect;
import login.database.manage_Sch;
import login.model.Schedule;

/**
 * Servlet implementation class SaveSchServlet
 */
@WebServlet("/SaveSchServlet")
public class SaveSchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connect dbConnect = new Connect();
        Connection connection = (Connection) dbConnect.connect();
        manage_Sch manage_sch = new manage_Sch(connection);
        boolean updateResult = false;
        
        String month = "1";
        String year = "2020";
        
        
        Schedule sch = new Schedule(year,month);
        
        try {
        	
        	updateResult = manage_sch.update(sch);
			
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		}
        
        request.setAttribute("updateResult",updateResult);
		request.getRequestDispatcher("ManageSch.jsp").forward(request, response);
		

       
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
