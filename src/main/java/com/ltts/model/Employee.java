package com.ltts.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Employee {

	@Id
	@Column(name = "employee_Id")
	int employeeid;
	@Column(name ="employee_name")
	String employeename;
	@Column(name = "employee_Department")
	String employeedepartment;
	@Column(name = "employee_grade")
	String employeegrade;
	@Column(name ="employee_position")
	String employeeposition;
	
	@Lob
	@Column(name ="employee_image",columnDefinition = "LONGBLOB")
	byte[] employeeimage;
	
	
	public byte[] getEmployeeimage() {
		return employeeimage;
	}
	public void setEmployeeimage(byte[] employeeimage) {
		this.employeeimage = employeeimage;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public String getEmployeedepartment() {
		return employeedepartment;
	}
	public void setEmployeedepartment(String employeedepartment) {
		this.employeedepartment = employeedepartment;
	}
	public String getEmployeegrade() {
		return employeegrade;
	}
	public void setEmployeegrade(String employeegrade) {
		this.employeegrade = employeegrade;
	}
	public String getEmployeeposition() {
		return employeeposition;
	}
	public void setEmployeeposition(String employeeposition) {
		this.employeeposition = employeeposition;
	}
	public Employee(int employeeid, String employeename, String employeedepartment, String employeegrade,
			String employeeposition, byte[] employeeimage) {
		super();
		this.employeeid = employeeid;
		this.employeename = employeename;
		this.employeedepartment = employeedepartment;
		this.employeegrade = employeegrade;
		this.employeeposition = employeeposition;
		this.employeeimage = employeeimage;
	}
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "Employee [employeeid=" + employeeid + ", employeename=" + employeename + ", employeedepartment="
				+ employeedepartment + ", employeegrade=" + employeegrade + ", employeeposition=" + employeeposition
				+ ", employeeimage=" + employeeimage + "]";
	}

	
}
