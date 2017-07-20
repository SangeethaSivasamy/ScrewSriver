package com.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentDetailsServlet
 */
@WebServlet(name="StudentDetailsServlet", urlPatterns= {"/StudentDetailsServlet","/MyServlet"})
public class StudentDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String firstName = "";

    /**
     * Default constructor. 
     */
    public StudentDetailsServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		firstName="Sangeetha";
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lastName = request.getParameter("lastName");
		response.setContentType("text/html");
		
		
		/*PrintWriter out = response.getWriter();
		out.println(firstName);*/
		request.setAttribute("firstName", firstName);
		request.setAttribute("lastName", lastName);
		System.out.println(lastName);
		ServletContext servletContext = this.getServletContext();
		RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/jsp/StudentsSummary.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}