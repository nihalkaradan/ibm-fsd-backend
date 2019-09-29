package com.training.java.empapp.service;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IEmployeeService {
	void addEmployee();
	void viewEmployee();
	void updateEmployee();
	void deleteEmployee();
	void viewAllEmployee();
	void importEmployee() throws FileNotFoundException;
	void exportEmployee() throws IOException;
	
}
