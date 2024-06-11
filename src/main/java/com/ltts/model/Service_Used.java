package com.ltts.model;

import java.sql.Time;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Service_Used {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "service_used_Id")
	int serviceusedid;
	@Column(name = "employee_Id")
	int employeeid;
	@Column(name = "service_Id")
	int serviceid;
	@Column(name = "service_starting_time",columnDefinition = "DATETIME")
	LocalDateTime servicestratingtime;
	@Column(name = "service_ending_time",columnDefinition = "DATETIME")
	LocalDateTime serviceendingtime;
	@Column(name = "service_used_timming",columnDefinition = "TIME")
	Time serviceusedtimming;
	@Column(name = "total_cost")
	String serviceusedcost;
	
	@ManyToOne
    @JoinColumn(name = "employee_Id", insertable = false, updatable = false)
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "service_Id", insertable = false, updatable = false)
    private Services service;
    
    
	public int getServiceusedid() {
		return serviceusedid;
	}
	public void setServiceusedid(int serviceusedid) {
		this.serviceusedid = serviceusedid;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public int getServiceid() {
		return serviceid;
	}
	public void setServiceid(int serviceid) {
		this.serviceid = serviceid;
	}
	public LocalDateTime getServicestratingtime() {
		return servicestratingtime;
	}
	public void setServicestratingtime(LocalDateTime servicestratingtime) {
		this.servicestratingtime = servicestratingtime;
	}
	public LocalDateTime getServiceendingtime() {
		return serviceendingtime;
	}
	public void setServiceendingtime(LocalDateTime serviceendingtime) {
		this.serviceendingtime = serviceendingtime;
	}
	public Time getServiceusedtimming() {
		return serviceusedtimming;
	}
	public void setServiceusedtimming(Time serviceusedtimming) {
		this.serviceusedtimming = serviceusedtimming;
	}
	
	public String getServiceusedcost() {
		return serviceusedcost;
	}
	public void setServiceusedcost(String serviceusedcost) {
		this.serviceusedcost = serviceusedcost;
	}
	
	public Service_Used(int serviceusedid, int employeeid, int serviceid, LocalDateTime servicestratingtime,
			LocalDateTime serviceendingtime, Time serviceusedtimming,String serviceusedcost) {
		super();
		this.serviceusedid = serviceusedid;
		this.employeeid = employeeid;
		this.serviceid = serviceid;
		this.servicestratingtime = servicestratingtime;
		this.serviceendingtime = serviceendingtime;
		this.serviceusedtimming = serviceusedtimming;
		this.serviceusedcost = serviceusedcost;
	}
	
	public Service_Used() {
		super();
	}
	
	@Override
	public String toString() {
		return "Service_Used [serviceusedid=" + serviceusedid + ", employeeid=" + employeeid + ", serviceid="
				+ serviceid + ", servicestratingtime=" + servicestratingtime + ", serviceendingtime="
				+ serviceendingtime + ", serviceusedtimming=" + serviceusedtimming +"serviceusedcost="
				+ serviceusedcost+ "]";
	}
	
	
}
