package login.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.database.Connect;
import login.database.NurseDao;
import login.model.Nurse;
import java.sql.Connection;

/**
 * Servlet implementation class NuresListServlet
 */
@WebServlet("/NuresListServlet" )
public class NuresListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connect dbConnect = new Connect();
		Connection connection = dbConnect.connect();
		
		NurseDao nurseDao = new NurseDao(connection);
		ArrayList<Nurse> Nurses = null;
		try {
			Nurses = nurseDao.findAll();
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		request.setAttribute("Nurses",Nurses);
		request.getRequestDispatcher("listmember.jsp").forward(request, response);
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
