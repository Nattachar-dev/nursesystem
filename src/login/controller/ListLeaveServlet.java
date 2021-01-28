package login.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.database.Connect;
import login.database.leaveDuty;
import login.model.Leave;

/**
 * Servlet implementation class ListLeaveServlet
 */
@WebServlet("/ListLeaveServlet")
public class ListLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connect dbConnect = new Connect();
		Connection connection = dbConnect.connect();
		
		leaveDuty ln = new leaveDuty(connection);
		ArrayList<Leave> Ln = null;
		try {
			Ln = ln.listAll();
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		request.setAttribute("Ln",Ln);
		request.getRequestDispatcher("ListDisplayLeave.jsp").forward(request, response);
	
		
	}
		

}
