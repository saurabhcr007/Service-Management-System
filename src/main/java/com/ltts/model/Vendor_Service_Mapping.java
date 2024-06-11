package com.ltts.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Vendor_Service_Mapping {
	
	@Id
	@Column(name = "vendor_service_mapping_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int vendorservicemappingid;
	@Column(name = "vendor_Id")
	int vendorid;
	@Column(name = "service_Id")
	int serviceid;
	@Column(name = "vendor_service_mapping_status")
	int vendorservicemappingstatus=1;
	@Column(name = "vendor_service_mapping_created_by")
	String vendorservicemappingcreatedby;
	@Column(name = "vendor_service_mapping_created_time",columnDefinition = "DATETIME")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , lenient=OptBoolean.FALSE)
	LocalDateTime vendorservicemappingcreatingtime;
	@Column(name = "vendor_service_mapping_update_by")
	String vendorservicemappingupdateby;
	@Column(name = "vendor_service_mapping_modifying_time",columnDefinition = "DATETIME")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , lenient=OptBoolean.FALSE)
	LocalDateTime vendorservicemappingmodifyingtime;
	@ManyToOne
    @JoinColumn(name = "vendor_Id", insertable = false, updatable = false)
    private Vendors vendor;

    @ManyToOne
    @JoinColumn(name = "service_Id", insertable = false, updatable = false)
    private Services service;

	public int getVendorservicemappingid() {
		return vendorservicemappingid;
	}

	public void setVendorservicemappingid(int vendorservicemappingid) {
		this.vendorservicemappingid = vendorservicemappingid;
	}

	public int getVendorid() {
		return vendorid;
	}

	public void setVendorid(int vendorid) {
		this.vendorid = vendorid;
	}

	public int getServiceid() {
		return serviceid;
	}

	public void setServiceid(int serviceid) {
		this.serviceid = serviceid;
	}

	public int getVendorservicemappingstatus() {
		return vendorservicemappingstatus;
	}

	public void setVendorservicemappingstatus(int vendorservicemappingstatus) {
		this.vendorservicemappingstatus = vendorservicemappingstatus;
	}

	public String getVendorservicemappingcreatedby() {
		return vendorservicemappingcreatedby;
	}

	public void setVendorservicemappingcreatedby(String vendorservicemappingcreatedby) {
		this.vendorservicemappingcreatedby = vendorservicemappingcreatedby;
	}

	public LocalDateTime getVendorservicemappingcreatingtime() {
		return vendorservicemappingcreatingtime;
	}

	public void setVendorservicemappingcreatingtime(LocalDateTime vendorservicemappingcreatingtime) {
		this.vendorservicemappingcreatingtime = vendorservicemappingcreatingtime;
	}

	public String getVendorservicemappingupdateby() {
		return vendorservicemappingupdateby;
	}

	public void setVendorservicemappingupdateby(String vendorservicemappingupdateby) {
		this.vendorservicemappingupdateby = vendorservicemappingupdateby;
	}

	public LocalDateTime getVendorservicemappingmodifyingtime() {
		return vendorservicemappingmodifyingtime;
	}

	public void setVendorservicemappingmodifyingtime(LocalDateTime vendorservicemappingmodifyingtime) {
		this.vendorservicemappingmodifyingtime = vendorservicemappingmodifyingtime;
	}

	public Vendor_Service_Mapping(int vendorid,int serviceid,int vendorservicemappingstatus, String vendorservicemappingcreatedby,
			LocalDateTime vendorservicemappingcreatingtime, String vendorservicemappingupdateby,
			LocalDateTime vendorservicemappingmodifyingtime) {
		super();
//		this.vendorservicemappingid = vendorservicemappingid;
		this.vendorid = vendorid;
		this.serviceid = serviceid;
		this.vendorservicemappingstatus = vendorservicemappingstatus;
		this.vendorservicemappingcreatedby = vendorservicemappingcreatedby;
		this.vendorservicemappingcreatingtime = vendorservicemappingcreatingtime;
		this.vendorservicemappingupdateby = vendorservicemappingupdateby;
		this.vendorservicemappingmodifyingtime = vendorservicemappingmodifyingtime;
	}

	public Vendor_Service_Mapping() {
		super();
	}

	@Override
	public String toString() {
		return "Vendor_Service_Mapping [vendorservicemappingid=" + vendorservicemappingid + ", vendorid=" + vendorid
				+ ", serviceid=" + serviceid + ", vendorservicemappingstatus=" + vendorservicemappingstatus
				+ ", vendorservicemappingcreatedby=" + vendorservicemappingcreatedby
				+ ", vendorservicemappingcreatingtime=" + vendorservicemappingcreatingtime
				+ ", vendorservicemappingupdateby=" + vendorservicemappingupdateby
				+ ", vendorservicemappingmodifyingtime=" + vendorservicemappingmodifyingtime + ", vendor=" + vendor
				+ ", service=" + service + "]";
	}

}