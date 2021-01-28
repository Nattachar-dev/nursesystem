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
import login.database.ExchangeDuty;
import login.model.Exchange;


/**
 * Servlet implementation class ListExchageServlet
 */
@WebServlet("/ListExchageServlet")
public class ListExchageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connect dbConnect = new Connect();
		Connection connection = dbConnect.connect();
		
		ExchangeDuty lex = new ExchangeDuty(connection);
		ArrayList<Exchange> Lex = null;
		try {
			Lex = lex.listAll();
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		request.setAttribute("Lex",Lex);
		request.getRequestDispatcher("ListDisplayEx.jsp").forward(request, response);
	
		
	}
		

}
