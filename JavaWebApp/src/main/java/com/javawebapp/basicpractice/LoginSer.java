package com.javawebapp.basicpractice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginSer
 */
@WebServlet("/LoginSer")
public class LoginSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		if(uname.equals("admin") && upass.equals("admin")) {
			HttpSession session = request.getSession();
			session.setAttribute("isloggedin",true);
			//RequestDispatcher req = request.getRequestDispatcher("adminmodule/admindashboard.jsp");
			//req.forward(request, response);
			response.sendRedirect("adminmodule/admindashboard.jsp");
		}
		else
		{
			response.sendRedirect("LoginForm.jsp?error=invalid userid and password");
		}
	}

}
