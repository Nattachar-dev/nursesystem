package login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckListUpdateServlet
 */
@WebServlet("/CheckListUpdateServlet")
public class CheckListUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
		//sql update
		boolean addResult = false;	

		addResult = true;

		request.setAttribute("addResult",addResult);

		request.getRequestDispatcher("Success.jsp").forward(request, response);
		
	}


}
