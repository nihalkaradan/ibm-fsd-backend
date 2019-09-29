package com.training.java.empapp.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IEmployeeService {
	void addEmployee(Integer _id,String _name,Integer _salary) throws SQLException;
	void viewEmployee() throws SQLException;
	void updateEmployee();
	//void deleteEmployee();
	ArrayList viewAllEmployee();
	void importEmployee() throws FileNotFoundException;
	void exportEmployee() throws IOException;
	void deleteEmployee(Integer _id);
	
	
	
}
