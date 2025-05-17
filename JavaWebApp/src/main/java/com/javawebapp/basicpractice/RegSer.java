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
 * Servlet implementation class RegSer
 */
@WebServlet("/RegSer")
public class RegSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegSer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		PrintWriter out = response.getWriter();
		try
		{
		Datahelper.connect();
		int res = Datahelper.UserReg(uname, upass,email,mobile);
		if(res>0)
		{
			out.print("user added successfully");
		}
		else
		{
			out.print("user not added successfully");
		}
		}
		catch(Exception ex)
		{
			out.print(ex.getMessage().toString());
		}
	}

}
