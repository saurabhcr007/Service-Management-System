package com.ltts.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltts.dao.VendorServiceMappingDAOImpl;
import com.ltts.exception.DataPresentException;
import com.ltts.exception.FieldMissingException;
import com.ltts.exception.NoDataFoundException;
import com.ltts.exception.OperationFailedException;
import com.ltts.model.Vendor_Service_Mapping;

@Service
public class VendorServiceMappingServiceImpl implements VendorServiceMappingService {
	
	private static final Logger logger=LoggerFactory.getLogger(VendorServiceMappingServiceImpl.class);

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	@Autowired
	private VendorServiceMappingDAOImpl VSMDAO;

	@Override
	public String addvendorservicemapping(Vendor_Service_Mapping vendorservicemapping) {
		LocalDateTime time = LocalDateTime.now().withNano(0);
		vendorservicemapping.setVendorservicemappingcreatingtime(time);
		if(vendorservicemapping.getVendorservicemappingcreatedby().isEmpty()) {
			logger.error("Missing fields found");
			throw new FieldMissingException("Missing fields found");
		}
		if(vendorservicemapping.getServiceid()==0 && vendorservicemapping.getVendorid()==0) {
			logger.error("Missing fields found");
			throw new FieldMissingException("Missing fields found");
		}
		Optional<Vendor_Service_Mapping> temp=VSMDAO.findbyid(vendorservicemapping.getVendorservicemappingid());
		if(temp.isPresent()) {
			logger.warn("Data Present already");
			throw new DataPresentException("Data Present already");}
		boolean added= VSMDAO.addvendorservicemapping(vendorservicemapping);
		if(added) {
			logger.info("Operation succesfully");
			return "vendor service mapping added successfully";}
		logger.error("Operation failed");
		throw new OperationFailedException("Operation failed");
	}

	@Override
	public List<Vendor_Service_Mapping> getvendorservicemapping() {
		logger.info("Operation succesfully");
		return VSMDAO.getvendorservicemapping();
	}

	@Override
	public String updatevendorservicemapping(Vendor_Service_Mapping vendorservicemapping) {
		if(vendorservicemapping.getVendorservicemappingupdateby().isEmpty()) {
			logger.error("Missing fields found");
			throw new FieldMissingException("Missing fields found");
		}
		Optional<Vendor_Service_Mapping> ispresent=VSMDAO.findbyid(vendorservicemapping.getVendorservicemappingid());
		if(ispresent.isPresent()) {
			Vendor_Service_Mapping temp=VSMDAO.findByvendorservicemappingid(vendorservicemapping.getVendorservicemappingid());
			temp.setVendorservicemappingstatus(vendorservicemapping.getVendorservicemappingstatus());
			temp.setVendorservicemappingupdateby(vendorservicemapping.getVendorservicemappingupdateby());
			LocalDateTime time = LocalDateTime.now().withNano(0);
			temp.setVendorservicemappingmodifyingtime(time);
			boolean updated= VSMDAO.addvendorservicemapping(temp);
			if(updated) {
				logger.info("Operation succesfully");
				return "Update succesfully";}
			logger.error("Operation failed");
			throw new OperationFailedException("Operation failed");
		}
		logger.warn("No data found");
		throw new NoDataFoundException("NO data found");
	}

	@Override
	public String deletevendorservicemapping(int vendorservicemappingid) {
		Optional<Vendor_Service_Mapping> ispresent=VSMDAO.findbyid(vendorservicemappingid);
		if(ispresent.isPresent()) {
			int temp=VSMDAO.deletevendorservicemapping(vendorservicemappingid);
			if(temp>0) {
				logger.info("Operation succesfully");
				return "delete successfully";}
			logger.error("Operation failed");
			throw new OperationFailedException("Operation failed");
		}
		logger.warn("No data found");
		throw new NoDataFoundException("NO data found");
	}

}
