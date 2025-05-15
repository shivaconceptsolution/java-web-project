package com.javawebapp.basicpractice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.databasehelper.Datahelper;

/**
 * Servlet implementation class AddSubAdminSer
 */
@WebServlet("/AddSubAdminSer")
public class AddSubAdminSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSubAdminSer() {
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
		int res = Datahelper.addProfile(uname, upass);
		if(res>0)
		{
			out.print("subadmin added successfully");
		}
		else
		{
			out.print("subadmin not added successfully");
		}
		}
		catch(Exception ex)
		{
			out.print(ex.getMessage().toString());
		}
	}

}
