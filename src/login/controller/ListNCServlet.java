package login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.database.Connect;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;




@WebServlet("/ListNCServlet")

public class ListNCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connect dbConnect = new Connect();
		Connection connection = dbConnect.connect();
		boolean updateResult = false;
		
		
        String nameid = request.getParameter("nurse");
        String dur = request.getParameter("dur");
        String day = request.getParameter("day");
        
         
        try {
        	String sqlText1 = "UPDATE schedule_nurse SET role = 3 WHERE  name_id = ? AND duration = ? AND day = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlText1);
			preparedStatement.setString(1,nameid);
			preparedStatement.setString(2,dur);
			preparedStatement.setString(3,day);	
			
			updateResult = true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
        
        request.setAttribute("updateResult",updateResult);
		request.getRequestDispatcher("DisplaySelectNC.jsp").forward(request, response);
		
		
		
	}

}
