package login.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import login.model.*;
import login.database.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private loginDao loginDao;

    public void init() {
        loginDao = new loginDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Loginbean loginBean = new Loginbean();
        loginBean.setusername(username);
        loginBean.setpassword(password);

        try {
            if (loginDao.validate(loginBean)) {
                
                response.sendRedirect("home2.jsp");
            } else {
              
                response.sendRedirect("login.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
