package com.javawebapp.basicpractice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.databasehelper.Datahelper;

/**
 * Servlet implementation class AdminChangePassword
 */
@WebServlet("/AdminChangePassword")
public class AdminChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminChangePassword() {
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
		int res = Datahelper.changePassword(uname, upass);
		if(res>0)
		{
			out.print("password change successfully");
		}
		else
		{
			out.print("password not changed");
		}
		}
		catch(Exception ex)
		{
			out.print(ex.getMessage().toString());
		}
	}

}
