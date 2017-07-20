package com.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentEnrollmentServlet
 */
@WebServlet(name="StudentEnrollmentServlet", urlPatterns={"/StudentEnrollmentServlet"})
public class StudentEnrollmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentEnrollmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   System.out.println("Entered doGet");
    	String handleId = request.getParameter("handleId");
    	if(handleId.equals("ENROLL")) {
    	doGetStudentDetails(request,response);
    	} else if(handleId.equals("INSERT")) {
    		doInsertStudentDetails(request,response);
    	}
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void doGetStudentDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String firstName = request.getParameter("firstName");
    	String lastName = request.getParameter("lastName");
    	request.setAttribute("firstName", firstName);
    	request.setAttribute("lastName", lastName);
    	ServletContext servletContext = this.getServletContext();
    	RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/jsp/StudentEnrollConfirm.jsp");
    	requestDispatcher.forward(request, response);
	}
	
	public void doInsertStudentDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String firstName = request.getParameter("firstName");
    	String lastName = request.getParameter("lastName");
    	request.setAttribute("firstName", firstName);
    	request.setAttribute("lastName", lastName);
    	ServletContext servletContext = this.getServletContext();
    	RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/jsp/StudentEnrollSuccess.jsp");
    	requestDispatcher.forward(request, response);
	}
}
