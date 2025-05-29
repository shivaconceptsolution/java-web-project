package com.javawebapp.basicpractice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.databasehelper.Datahelper;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class UploadSer
 */
@WebServlet("/UploadSer")
public class UploadSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadSer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		try
		{
			// MultipartRequest m=new MultipartRequest(request,"d://upload");
			 MultipartRequest m = new MultipartRequest(request,getServletContext().getRealPath("/")+"upload");
            // out.print(getServletContext().getRealPath("/")+"upload");
			// out.print(m.getFilesystemName("file")+"<br>");
	    	 //out.print(m.getContentType("file")+"<br>");
			 String ftype=m.getContentType("file");
			 out.print(ftype);
			 if(ftype.equals("image/jpeg") || ftype.equals("image/png"))
			 {
	    	 String fname = m.getFilesystemName("file");
	    	 Datahelper.connect();
	    	 Datahelper.UploadFile(fname);
	    	 Datahelper.closeConn();
			 
	         response.sendRedirect("showfile.jsp");
			 }
			 else
			 {
				 out.print("provide only image file jpg and png");
			 }
		}
		catch(Exception ex)
		{
			 out.print("not successfully uploaded"+ex.getMessage());
		}
	}

}
