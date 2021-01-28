package login.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.database.Connect;
import login.database.ExchangeDuty;
import login.model.Exchange;


@WebServlet("/ExchangeDutyServlet")
public class ExchangeDutyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connect dbConnect = new Connect();
        Connection connection = dbConnect.connect();
        ExchangeDuty exc = new ExchangeDuty(connection);
        
        boolean addResult = false;  
        
        String name1 = request.getParameter("nurse");
        String date1 = "2020-01-03";
        String dur1 = request.getParameter("dur1");
        String name2 = request.getParameter("name2");
        String date2 = "2020-01-15";
        String dur2 = request.getParameter("dur2");
        
        Exchange ex1 = new Exchange(name1,name2,date1,date2,dur1,dur2,"0");
        
      
        try {
        	addResult = exc.add(ex1);
			
		} catch(SQLException e) {
			e.printStackTrace();	
		
		}
        addResult = true;
        request.setAttribute("addResult",addResult);
		request.getRequestDispatcher("SentExchange.jsp").forward(request, response);
        
        

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
