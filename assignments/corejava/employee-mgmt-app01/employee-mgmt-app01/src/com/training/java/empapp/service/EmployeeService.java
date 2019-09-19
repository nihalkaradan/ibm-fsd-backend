package com.training.java.empapp.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.Callable;

//import com.training.java.empapp.main.Employee;
import com.training.java.empapp.model.Employee;
public class EmployeeService implements IEmployeeService,Callable<String>, Runnable{
	Employee e1 = new Employee("nihal",1,25000);
	Employee e2 = new Employee("adithya",2,3500);
	HashMap <Integer,Employee> employeeList = new  HashMap<Integer,Employee>();
//	Integer x = e1.getEmpId();
//	employeeList.put(x,e1);
//	x=e2.getEmpId();
//	employeeList.put(x,e2);
	
	@Override
	public void addEmployee() {
		// TODO Auto-generated method stub
		Integer _id;
		String _name;
		Integer _salary;
		System.out.println("Enter id");
		Scanner sc = new Scanner(System.in);
		_id = sc.nextInt();
		System.out.println("Enter Name");
		_name = sc.next();
		System.out.println("Enter Salary");
		_salary = sc.nextInt();
		Employee e1 = new Employee(_name,_id,_salary);
		employeeList.put(_id, e1);
		//sc.close();
		
		
	}

	@Override
	public void viewEmployee() {
		// TODO Auto-generated method stub
		Integer _id;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee id");
		_id = sc.nextInt();
		employeeList.forEach((k,v)->{
			if (k==_id) {
				System.out.format("EmployeeId:%s  EmployeeName:%s EmployeeSalary:%s \n",v.getEmpId(),v.getEmpName(),v.getEmpSalary());
			}
		});
		
		
	}

	@Override
	public void updateEmployee() {
		Integer _id;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee id");
		_id = sc.nextInt();
		String _name;
		Integer _salary;
		System.out.println("Enter New Name");
		_name = sc.next();
		System.out.println("Enter New Salary");
		_salary = sc.nextInt();
		Employee e1 = new Employee(_name,_id,_salary);
		employeeList.put(_id, e1);
		
		
	}

	@Override
	public void deleteEmployee() {
		// TODO Auto-generated method stub
		Integer _id;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee id");
		_id = sc.nextInt();
		employeeList.remove(_id);
		
	}

	@Override
	public void viewAllEmployee() {
		// TODO Auto-generated method stub
		employeeList.forEach((k,v)->{
			System.out.format("EmployeeId:%s  EmployeeName:%s EmployeeSalary:%s \n",v.getEmpId(),v.getEmpName(),v.getEmpSalary());
		});
		
	}

	@Override
	public void importEmployee() throws FileNotFoundException{
		// TODO Auto-generated method stub
		File file = new File("C:\\training\\ibm-fsd-backend\\assignments\\corejava\\employee-mgmt-app01\\EMPApp\\src\\import.txt");
		Scanner sc= new Scanner(file);
		String s;
		while(sc.hasNext())
	    {
			s=sc.nextLine();
			System.out.println(s);
			String[] str= s.split(",");
			String _name = str[0];
	    	Integer _id = Integer.parseInt(str[1]);
	    	Integer _salary = Integer.parseInt(str[2]);
	    	Employee n = new Employee(_name,_id,_salary);
	    	employeeList.put(_id, n);
	    	
	    }
		
	}

	@Override
	public void exportEmployee() throws IOException {
		// TODO Auto-generated method stub
		//File file = new File("C:\\training\\ibm-fsd-backend\\assignments\\corejava\\employee-mgmt-app01\\EMPApp\\src\\export.txt");
		PrintWriter out = new PrintWriter(new FileWriter("C:\\\\training\\\\ibm-fsd-backend\\\\assignments\\\\corejava\\\\employee-mgmt-app01\\\\EMPApp\\\\src\\\\export.txt"));
		employeeList.forEach((k,v)->{
			String s1 = v.getEmpName();
			String s2 = Integer.toString(v.getEmpId());
			String s3 = Float.toString(v.getEmpSalary());
			out.write(s1);
			out.write(',');
			out.write(s2);
			out.write(',');	
		    out.write(s3);
		    out.write('\n');
		});
		out.flush();
		
	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MyClass running");
		return Thread.currentThread().getName();
	}

	@Override
	public void run() {
		System.out.println("MyClass running --" + Thread.currentThread().getName());
		// TODO Auto-generated method stub
		
	}
	public class MyImport implements Callable<String>{
		
		@Override
		public String call() throws Exception {
			// TODO Auto-generated method stub
			importEmployee();
			return Thread.currentThread().getName();
		}
		
	}

	
}
