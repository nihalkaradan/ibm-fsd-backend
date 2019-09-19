package com.training.java.empapp.main;



import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.training.java.empapp.service.EmployeeService;

public class EmployeeApp  {

	
	public static void main(String[] args) throws IOException {
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
		
		emps.addEmployee();
		emps.addEmployee();
		//emps.viewAllEmployee();
		//emps.deleteEmployee();
		//emps.viewAllEmployee();
		
		emps.importEmployee();
		emps.exportEmployee();
		emps.viewAllEmployee();
		
	}

}
