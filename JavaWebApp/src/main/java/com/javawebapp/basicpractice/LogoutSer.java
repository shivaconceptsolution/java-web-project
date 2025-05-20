package com.javawebapp.basicpractice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutSer
 */
@WebServlet("/LogoutSer")
public class LogoutSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutSer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ref = request.getSession();
		ref.removeAttribute("isloggedin");
		ref.invalidate();
		Cookie ref1 = new Cookie("ukey","");
		ref1.setMaxAge(-1);
		response.addCookie(ref1);
		Cookie ref2 = new Cookie("upass","");
		response.addCookie(ref2);
		response.sendRedirect("LoginForm.jsp");
	}

}
