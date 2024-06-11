package com.ltts.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Services {
	@Id
	@Column(name = "service_Id")
	int serviceid;
	@Column(name = "service_name")
	String servicename;
	@Column(name = "service_status")
	int servicestatus=1;
	@Column(name = "service_created_by")
	String servicecreatedby;
	@Column(name = "service_creating_time",columnDefinition = "DATETIME")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , lenient=OptBoolean.FALSE)
	LocalDateTime servicecreatingtime;
	@Column(name = "service_updated_by")
	String serviceupdatedby;
	@Column(name = "service_modifying_time",columnDefinition = "DATETIME")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , lenient=OptBoolean.FALSE)
	LocalDateTime servicemodifingtime;
	@Column(name = "service_cost")
	int servicecost;
	
	public int getServiceid() {
		return serviceid;
	}
	public void setServiceid(int serviceid) {
		this.serviceid = serviceid;
	}
	public String getServicename() {
		return servicename;
	}
	public void setServicename(String servicename) {
		this.servicename = servicename;
	}
	public int getServicestatus() {
		return servicestatus;
	}
	public void setServicestatus(int servicestatus) {
		this.servicestatus = servicestatus;
	}
	public String getServicecreatedby() {
		return servicecreatedby;
	}
	public void setServicecreatedby(String servicecreatedby) {
		this.servicecreatedby = servicecreatedby;
	}
	public LocalDateTime getServicecreatingtime() {
		return servicecreatingtime;
	}
	public void setServicecreatingtime(LocalDateTime servicecreatingtime) {
		this.servicecreatingtime = servicecreatingtime;
	}
	public String getServiceupdatedby() {
		return serviceupdatedby;
	}
	public void setServiceupdatedby(String serviceupdatedby) {
		this.serviceupdatedby = serviceupdatedby;
	}
	public LocalDateTime getServicemodifingtime() {
		return servicemodifingtime;
	}
	public void setServicemodifingtime(LocalDateTime servicemodifingtime) {
		this.servicemodifingtime = servicemodifingtime;
	}
	public int getServicecost() {
		return servicecost;
	}
	public void setServicecost(int servicecost) {
		this.servicecost = servicecost;
	}
	public Services(int serviceid, String servicename, int servicestatus, String servicecreatedby,
			LocalDateTime servicecreatingtime, String serviceupdatedby, LocalDateTime servicemodifingtime,
			int servicecost) {
		super();
		this.serviceid = serviceid;
		this.servicename = servicename;
		this.servicestatus = servicestatus;
		this.servicecreatedby = servicecreatedby;
		this.servicecreatingtime = servicecreatingtime;
		this.serviceupdatedby = serviceupdatedby;
		this.servicemodifingtime = servicemodifingtime;
		this.servicecost = servicecost;
	}
	public Services() {
		super();
	}
	@Override
	public String toString() {
		return "Services [serviceid=" + serviceid + ", servicename=" + servicename + ", servicestatus=" + servicestatus
				+ ", servicecreatedby=" + servicecreatedby + ", servicecreatingtime=" + servicecreatingtime
				+ ", serviceupdatedby=" + serviceupdatedby + ", servicemodifingtime=" + servicemodifingtime
				+ ", servicecost=" + servicecost + "]";
	}
	
}
