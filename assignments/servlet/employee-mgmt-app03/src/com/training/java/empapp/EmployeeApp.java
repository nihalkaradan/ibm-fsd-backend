package com.training.java.empapp;



import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import java.sql.Connection;
import com.training.java.empapp.dao.DAO;
import com.training.java.empapp.service.EmployeeService;

public class EmployeeApp  {

	
	public static void main(String[] args) throws IOException, SQLException {
		EmployeeService emps = new EmployeeService();
		
		// TODO Auto-generated method stub
		Callable<String> callable = emps.new MyImport();
		ExecutorService executor = Executors.newFixedThreadPool(1);
		Future<String> f = executor.submit(callable);
		while(!f.isDone()) {
			System.out.println(Thread.currentThread().getName() + " -->Waiting");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		String s = null;
		try {
			s = f.get();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			e1.printStackTrace();
		}
		
		emps.deleteEmployee(1);
		
	}

}
