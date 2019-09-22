package com.training.java.empapp.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public interface IEmployeeService {
	void addEmployee() throws SQLException;
	void viewEmployee() throws SQLException;
	void updateEmployee();
	void deleteEmployee();
	void viewAllEmployee();
	void importEmployee() throws FileNotFoundException;
	void exportEmployee() throws IOException;
	
}
