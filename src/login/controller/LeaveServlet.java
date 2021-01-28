package login.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.database.Connect;

/**
 * Servlet implementation class LeaveServlet
 */
@WebServlet("/LeaveServlet")
public class LeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connect dbConnect = new Connect();
		Connection connection = dbConnect.connect();
		boolean intsert = false;
		String name =  request.getParameter("name");
		String pos_id =  request.getParameter("pos");
		String date =  request.getParameter("date");
		String dur =  request.getParameter("dur1");
		String des =  request.getParameter("description");
		
		
		String sqlText = "INSERT INTO leave(name,pos_id,date,dur_time,Description,status) VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sqlText);
			preparedStatement.setString(1,name);
			preparedStatement.setString(2,pos_id);
			preparedStatement.setString(3,date);
			preparedStatement.setString(4,dur);
			preparedStatement.setString(5,des);
			preparedStatement.setString(6,"0");
			intsert = true;

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			
		 	request.setAttribute("intsert",intsert);
			request.getRequestDispatcher("SentLeave.jsp").forward(request, response);
		
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
