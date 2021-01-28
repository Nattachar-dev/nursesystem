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

import login.database.manage_Sch;
import login.model.MySch;




@WebServlet("/AllSchServlet")
public class AllSchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connect dbConnect = new Connect();
		Connection connection = dbConnect.connect();
		
		manage_Sch Dsch = new manage_Sch(connection);
		
		ArrayList<MySch> mySch = null;
		try {
			mySch = Dsch.SchAll();
			
		} catch(SQLException e) {
			e.printStackTrace();	
		}
		
		request.setAttribute("mySch",mySch);
		
		request.getRequestDispatcher("AllSch.jsp").forward(request, response);
		
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
