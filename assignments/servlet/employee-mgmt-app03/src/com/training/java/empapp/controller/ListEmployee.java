package com.training.java.empapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.java.empapp.model.Employee;
import com.training.java.empapp.service.EmployeeService;
/**
 * Servlet implementation class ListEmployee
 */
@WebServlet(name = "ListEmployeeControl", urlPatterns = { "/listemployees.do" })
public class ListEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//response.getWriter.append("working fine").append(request.getContextPath());
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		EmployeeService eService = new EmployeeService();
		List<Employee> eList = eService.viewAllEmployee();
		request.setAttribute("empList", eList);
		RequestDispatcher rd = request.getRequestDispatcher("employeeList.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
