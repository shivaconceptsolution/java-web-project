package com.javawebapp.basicpractice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.time.Duration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.databasehelper.Datahelper;

/**
 * Servlet implementation class LoginUserSer
 */
@WebServlet("/LoginUserSer")
public class LoginUserSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUserSer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		PrintWriter out = response.getWriter();
		try
		{
		Datahelper.connect();
		ResultSet res = Datahelper.verifyUser(uname, upass);
		if(res.next())
		{
			HttpSession session = request.getSession();
			session.setAttribute("isloggedin1",true);
			session.setAttribute("ukey1",uname);
			if(request.getParameter("remember")!=null)
			{
			Cookie ref1 = new Cookie("ukey",uname);
			ref1.setMaxAge(1200000);
			response.addCookie(ref1);
			Cookie ref2 = new Cookie("upass",upass);
			ref2.setMaxAge(1200000);
			response.addCookie(ref2);
			}
            response.sendRedirect("usermodule/userdashboard.jsp");
		}
		else
		{
			response.sendRedirect("UserLogin.jsp?error=invalid userid and password");
		}
		
		}
		catch(Exception ex)
		{
			out.print(ex.getMessage().toString());
		}
	}

}
