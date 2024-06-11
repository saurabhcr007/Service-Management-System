package com.ltts.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltts.dao.VendorDAOImpl;
import com.ltts.exception.DataPresentException;
import com.ltts.exception.FieldMissingException;
import com.ltts.exception.NoDataFoundException;
import com.ltts.exception.OperationFailedException;
import com.ltts.model.Vendors;

@Service
public class VendorServiceImpl implements VendorService {
	
	private static final Logger logger=LoggerFactory.getLogger(VendorServiceImpl.class);

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	@Autowired
	private VendorDAOImpl VendorDAO;
	
	@Override
	public String addvendor(Vendors vendor) {
		LocalDateTime time = LocalDateTime.now().withNano(0);
		vendor.setVendorcreatingtime(time);
		if(vendor.getVendorid()==0) {
			logger.error("Missing fields found");
			throw new FieldMissingException("Missing fields found");
			
		}
		if(vendor.getVendorname().isEmpty()) {
			logger.error("Missing fields found");
			throw new FieldMissingException("Missing fields found");
		}
		if(vendor.getVendorcreatedby().isEmpty()) {
			logger.error("Missing fields found");
			throw new FieldMissingException("Missing fields found");
		}
		
		Optional<Vendors> ispresent=VendorDAO.findbyid(vendor.getVendorid());
		if(ispresent.isPresent()) {
			logger.warn("Data Present already");
			throw new DataPresentException("Data Present already");}
		
		boolean temp=VendorDAO.addvendor(vendor);
		if(temp) {
			logger.info("Operation succesfully");
			return "vendor added successfully";
			}
		logger.error("Operation failed");
		throw new OperationFailedException("Operation failed");
	}
	
	@Override
	public List<Vendors> getvendor() {
		logger.info("Operation succesfully");
		return VendorDAO.getvendor();
	}
	
	@Override
	public String updatevendor(Vendors vendor) {
		if(vendor.getVendorupdatedby().isEmpty()) {
			logger.error("Missing fields found");
			throw new FieldMissingException("Missing fields found");
		}
		Optional<Vendors> ispresent=VendorDAO.findbyid(vendor.getVendorid());
		if(ispresent.isPresent()) {
			Vendors temp=VendorDAO.findByvendorid(vendor.getVendorid());
			
			temp.setVendorstatus(vendor.getVendorstatus());
			temp.setVendorupdatedby(vendor.getVendorupdatedby());
			LocalDateTime time = LocalDateTime.now().withNano(0);
			temp.setVendormodifingtime(time);
			boolean updated= VendorDAO.addvendor(temp);
			if(updated) {
				logger.info("Operation succesfully");
				return "Update succesfully";}
			logger.error("Operation failed");
			throw new OperationFailedException("Operation failed");
		}
		logger.warn("No data Found");
		throw new NoDataFoundException("NO data found");
	}
	
	@Override
	public String deletevendor(int vendorid) {
		Optional<Vendors> ispresent=VendorDAO.findbyid(vendorid);
		if(ispresent.isPresent()) {
			int temp=VendorDAO.deletevendor(vendorid);
			if(temp>0) {
				logger.info("Operation succesfully");
				return "delete successfully";}
			logger.error("Operation failed");
			throw new OperationFailedException("Operation failed");
		}
		logger.warn("No data Found");
		throw new NoDataFoundException("NO data found");
	}
}
