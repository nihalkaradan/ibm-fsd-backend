package com.examples.empapp.model;

public class Employee {
int empId;
String name;
int age;
String dept;
String desgn;
String country;
public Employee(int empId, String name, int age, String dept, String desgn, String country) {
	super();
	this.empId = empId;
	this.name = name;
	this.age = age;
	this.dept = dept;
	this.desgn = desgn;
	this.country = country;
}
public Employee() {
	// TODO Auto-generated constructor stub
}

public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getDept() {
	return dept;
}
public void setDept(String dept) {
	this.dept = dept;
}
public String getDesgn() {
	return desgn;
}
public void setDesgn(String desgn) {
	this.desgn = desgn;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
@Override
public String toString() {
	return "Employee [empId=" + empId + ", name=" + name + ", age=" + age + ", dept=" + dept + ", desgn=" + desgn
			+ ", country=" + country + "]";
}


}
