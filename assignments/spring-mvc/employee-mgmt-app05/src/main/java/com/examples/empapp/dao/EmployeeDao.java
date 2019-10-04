package com.examples.empapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.examples.empapp.model.Employee;
import com.examples.empapp.service.EmployeeService;

public class EmployeeDao {

	public  ArrayList<Employee> emplist = new ArrayList<Employee>();
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	 final static String DB_URL = "jdbc:mysql://localhost:3306/jdbctraining";


	// Database credentials
	 final static String USER = "training";
	 final static String PASS = "training";

static Connection conn = null;
static Statement stmt = null;
static PreparedStatement pstmt = null;
static ResultSet rs = null;


	public EmployeeDao(){
		
			try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	// STEP 3: Open a connection
	System.out.println("Connecting to database...");
	try {
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		conn.setAutoCommit(true);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} // enable transaction

	System.out.println("Connection estabilished: " + conn);
	try {
		stmt = conn.createStatement();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
	public  int add(Employee e2) throws SQLException {
		
		
	String insertQueryForPrepareStmt = "INSERT INTO employee (name, age, designation, department, country) VALUES (?, ?, ?, ?, ?)";
	
	String name = e2.getName();
	
	int age = e2.getAge();
	
	String desgn = e2.getDesgn();
	
	String dept = e2.getDept();
	
	String country = e2.getCountry();
	 int insertCount = 0;	
	
	try {
		pstmt = conn.prepareStatement(insertQueryForPrepareStmt);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		
		pstmt.setString(1, name);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		pstmt.setInt(2, age);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		pstmt.setString(3, desgn);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try {
		pstmt.setString(4, dept);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		pstmt.setString(5, country);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
		insertCount = pstmt.executeUpdate();
		System.out.println(insertCount + " Employee(s) inserted");
		pstmt.close();
		

	
	
	return insertCount;
}
	
	
	public  void viewAll() {
		
		
		String selectQuery = "SELECT * FROM employee";
		try {
			rs = stmt.executeQuery(selectQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// STEP 5: Extract data from result set
		// Header
		System.out.format("\t%s \t%s \t%s \t%s \t%s \t%s\n", "Id", "Age", "Name", "Designation", "Department",
				"Country");
		try {
			if(rs.next()==false) {
				System.out.println("No details exist");
			}
			
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");
				int age = rs.getInt("age");
				String name = rs.getString("name");
				String designation = rs.getString("designation");
				String department = rs.getString("department");
				String country = rs.getString("country");

				// Display values
				System.out.format("\t%d \t%d \t%s \t%s \t%s \t%s\n", id, age, name, designation, department, country);
			}
			
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
}
	
	public  Employee view(int id) {
		
		
	Employee emp = null;
		
		String selectQuery = "SELECT * from employee WHERE id = ?";
		try {
			pstmt = conn.prepareStatement(selectQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pstmt.setInt(1,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println(id);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error executeQuery");
			e.printStackTrace();
		}
		System.out.format("\t%s \t%s \t%s \t%s \t%s \t%s\n", "Id", "Age", "Name", "Designation", "Department",
				"Country");
		
//			try {if (rs.next()==false){
//				System.out.println("Employee of that ID does not exist");
				try {
					while (rs.next()) {
						// Retrieve by column name
						int id1 = rs.getInt("id");
						int age = rs.getInt("age");
						String name = rs.getString("name");
						String designation = rs.getString("designation");
						String department = rs.getString("department");
						String country = rs.getString("country");
						
					 emp = new Employee(id,name,age,designation,department,country);
						// Display values
						System.out.format("\t%d \t%d \t%s \t%s \t%s \t%s\n", id1, age, name, designation, department, country);
						System.out.println(rs.next());
					
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
//			} catch (SQLException e) {
//				
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		
		try {
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
		
		
		
}
	
	public  int delete(int id) {
		
		
	String deleteQuery = "DELETE FROM employee WHERE id = ?";
	try {
		pstmt = conn.prepareStatement(deleteQuery);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		pstmt.setInt(1, id);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	int deleteCount = 0;
	try {
		deleteCount = pstmt.executeUpdate();
		if(deleteCount!=0)
		System.out.println(deleteCount + " Employee(s) deleted");
		else
			System.out.println("The required employee details does not exist");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		pstmt.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return deleteCount;
	

}
	public  boolean update(int id,Employee employee) {
		
		String updateQuery = "UPDATE employee SET name = \"" + employee.getName() + "\", age = " + employee.getAge()
		+ ",department = \"" + employee.getDept() + "\",designation = \"" + employee.getDesgn()
		+ "\", country = \"" + employee.getCountry() + "\" WHERE id = " + id;
		boolean updateCount = false;
		try {
			updateCount = stmt.execute(updateQuery);
			System.out.println(updateCount);
			if(updateCount != true)
			System.out.println(updateCount + " Employee(s) updated");
			else
				System.out.println("The required employee does not exist");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
	

			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updateCount;
		
}


	public  ArrayList retrieve() {
		ArrayList emplist = new ArrayList();
		
		String selectQuery = "SELECT * FROM employee";
		try {
			rs = stmt.executeQuery(selectQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// STEP 5: Extract data from result set
		
		System.out.format("\t%s \t%s \t%s \t%s \t%s \t%s\n", "Id", "Age", "Name", "Designation", "Department",
				"Country");
		try {
			if(rs.next()==false) {
				System.out.println("No details exist");
			}
			
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");
				int age = rs.getInt("age");
				String name = rs.getString("name");
				String designation = rs.getString("designation");
				String department = rs.getString("department");
				String country = rs.getString("country");

				// Display values
				Employee e2 = new Employee(id,name, age, department,designation, country);
				emplist.add(e2);
				
			}
			
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emplist;

		
	}
	
}