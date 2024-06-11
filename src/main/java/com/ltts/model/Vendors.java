package com.ltts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;


@Entity
public class Vendors {

	@Id
	@Column(name = "vendor_Id")
	int vendorid;
	@Column(name = "vendor_name")
	String vendorname;
	@Column(name = "vendor_status")
	int vendorstatus=1;
	@Column(name = "vendor_created_by")
	String vendorcreatedby;
	@Column(name = "vendor_creating_time",columnDefinition = "DATETIME")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , lenient=OptBoolean.FALSE)
	LocalDateTime vendorcreatingtime;
	@Column(name = "vendor_updated_by")
	String vendorupdatedby;
	@Column(name = "vendor_modifying_time",columnDefinition = "DATETIME")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , lenient=OptBoolean.FALSE)
	LocalDateTime vendormodifingtime;
	
	public int getVendorid() {
		return vendorid;
	}
	public void setVendorid(int vendorid) {
		this.vendorid = vendorid;
	}
	public String getVendorname() {
		return vendorname;
	}
	public void setVendorname(String vendorname) {
		this.vendorname = vendorname;
	}
	public int getVendorstatus() {
		return vendorstatus;
	}
	public void setVendorstatus(int vendorstatus) {
		this.vendorstatus = vendorstatus;
	}
	public String getVendorcreatedby() {
		return vendorcreatedby;
	}
	public void setVendorcreatedby(String vendorcreatedby) {
		this.vendorcreatedby = vendorcreatedby;
	}
	public LocalDateTime getVendorcreatingtime() {
		return vendorcreatingtime;
	}
	public void setVendorcreatingtime(LocalDateTime vendorcreatingtime) {
		this.vendorcreatingtime = vendorcreatingtime;
	}
	public String getVendorupdatedby() {
		return vendorupdatedby;
	}
	public void setVendorupdatedby(String vendorupdatedby) {
		this.vendorupdatedby = vendorupdatedby;
	}
	public LocalDateTime getVendormodifingtime() {
		return vendormodifingtime;
	}
	public void setVendormodifingtime(LocalDateTime vendormodifingtime) {
		this.vendormodifingtime = vendormodifingtime;
	}
	
	public Vendors(int vendorid, String vendorname, int vendorstatus, String vendorcreatedby,
			LocalDateTime vendorcreatingtime, String vendorupdatedby, LocalDateTime vendormodifingtime) {
		super();
		this.vendorid = vendorid;
		this.vendorname = vendorname;
		this.vendorstatus = vendorstatus;
		this.vendorcreatedby = vendorcreatedby;
		this.vendorcreatingtime = vendorcreatingtime;
		this.vendorupdatedby = vendorupdatedby;
		this.vendormodifingtime = vendormodifingtime;
	}
	
	public Vendors() {
		super();
	}

	@Override
	public String toString() {
		return "Vendors [vendorid=" + vendorid + ", vendorname=" + vendorname + ", vendorstatus=" + vendorstatus
				+ ", vendorcreatedby=" + vendorcreatedby + ", vendorcreatingtime=" + vendorcreatingtime
				+ ", vendorupdatedby=" + vendorupdatedby + ", vendormodifingtime=" + vendormodifingtime + "]";
	}
	
	
}
