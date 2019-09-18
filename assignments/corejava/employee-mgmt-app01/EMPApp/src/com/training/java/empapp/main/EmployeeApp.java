package com.training.java.empapp.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.training.java.empapp.service.EmployeeService;

public class EmployeeApp  {
	
	
	public static void main(String[] args) throws IOException {
		
		// TODO Auto-generated method stub
		EmployeeService emps = new EmployeeService();
		emps.addEmployee();
		emps.addEmployee();
		emps.viewAllEmployee();
		//emps.deleteEmployee();
		//emps.viewAllEmployee();
		emps.importEmployee();
		emps.exportEmployee();
		emps.viewAllEmployee();
		
	}

}
