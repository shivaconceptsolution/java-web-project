package com.scs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scs.model.SIModel;

/**
 * Servlet implementation class FrontController
 */
@WebServlet(name="FrontController",urlPatterns={"/FrontController"})
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("views/siview.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SIModel obj = new SIModel();
		obj.setP(Float.parseFloat(request.getParameter("txtp")));
		obj.setR(Float.parseFloat(request.getParameter("txtr")));
		obj.setT(Float.parseFloat(request.getParameter("txtt")));
		double si = obj.getP()*obj.getR()*obj.getT()/100;
		response.sendRedirect("views/siview.jsp?result="+si);
		
	}

}
