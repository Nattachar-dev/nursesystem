package login.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.database.Connect;
import login.model.Nurse;

/**
 * Servlet implementation class CheckListServlet
 */
@WebServlet("/CheckListServlet")
public class CheckListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connect dbConnect = new Connect();
		Connection connection = dbConnect.connect();
		boolean check = false;
		ArrayList<Nurse>  SetN = new ArrayList<>();	
		
		Statement statement1=null;
        ResultSet rs1 = null;

		
	       
        //∑”„π Ë«π¢ÈÕº‘¥æ≈“¥¥È«¬ ∂È“∑”∑—ππ–®È–
        
        
        
        try {
        	String sqlText1 = "SELECT n.name FROM schedule_nurse s ,nurse n WHERE s.name_id<>'6005105476' AND s.day=4 AND s.duration = 2 AND s.name_id=n.username";
        	statement1 = connection.createStatement();
            rs1= statement1.executeQuery(sqlText1);
			
			while(rs1.next()) {
				Nurse setN = new Nurse();
				setN.setname(rs1.getString("n.name"));						
				SetN.add(setN);
			}
			
			check = true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
        
        
        if(check == true) {
        
        request.setAttribute("SetN",SetN);
		request.getRequestDispatcher("CheckByNC2.jsp").forward(request, response);
        }
        else {
        	request.setAttribute("SetN",SetN);
    		request.getRequestDispatcher("NoCheck.jsp").forward(request, response);
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
