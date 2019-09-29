package com.training.java.empapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.java.empapp.service.EmployeeService;

/**
 * Servlet implementation class DeleteEmployee
 */
@WebServlet(name = "deleteemployee.do", urlPatterns = { "/deleteemployee.do" })
public class DeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String _id = request.getParameter("id");
		System.out.println("id received is "+_id);
		EmployeeService eService =  new EmployeeService();
		eService.deleteEmployee(Integer.getInteger(_id));
		RequestDispatcher rd =  request.getRequestDispatcher("/listemployees.do");
		rd.forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
//	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		Integer _id = Integer.getInteger(request.getParameter("id"));
//		EmployeeService eService =  new EmployeeService();
//		eService.deleteEmployee(_id);
//		RequestDispatcher rd =  request.getRequestDispatcher("/listemployees.do");
//		rd.forward(request, response);
//	}

}
