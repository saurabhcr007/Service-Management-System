package com.ltts.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltts.dao.ServiceDAOImpl;
import com.ltts.exception.DataPresentException;
import com.ltts.exception.FieldMissingException;
import com.ltts.exception.NoDataFoundException;
import com.ltts.exception.OperationFailedException;
import com.ltts.model.Services;

@Service
public class ServiceServiceImpl implements ServiceService{
	
	private static final Logger logger=LoggerFactory.getLogger(ServiceServiceImpl.class);
	 
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	@Autowired
	private ServiceDAOImpl serviceDAO;

	@Override
	public String addservice(Services service) {
		LocalDateTime time = LocalDateTime.now().withNano(0);
		service.setServicecreatingtime(time);
		if(service.getServiceid()==0) {
			logger.error("Missing fields found");
			throw new FieldMissingException("Missing fields found");
		}
		if(service.getServicecost()<=0) {
			logger.error("Cost can't be in negative");
			throw new FieldMissingException("Cost can't be in negative");
		}
		if(service.getServicename().isEmpty()) {
			logger.error("Missing fields found");
			throw new FieldMissingException("Missing fields found");
		}
		if(service.getServicecreatedby().isEmpty()) {
			logger.error("Missing fields found");
			throw new FieldMissingException("Missing fields found");
		}
		Optional<Services> temp=serviceDAO.findbyid(service.getServiceid());
		if(temp.isPresent()) {
			logger.warn("Data Present already");
			throw new DataPresentException("Data Present already");}
		boolean added= serviceDAO.addservice(service);
		if(added) {
			logger.info("Operation succesfully");
			return "service added successfully";}
		logger.error("Operation failed");
		throw new OperationFailedException("Operation failed");
	}

	@Override
	public List<Services> getservice() {
		logger.info("Operation succesfully");
		return serviceDAO.getservice();
	}

	@Override
	public String updateservice(Services service) {
		if(service.getServiceupdatedby().isEmpty()) {
			logger.error("Missing fields found");
			throw new FieldMissingException("Missing fields found");
		}
		Optional<Services> ispresent=serviceDAO.findbyid(service.getServiceid());
		if(ispresent.isPresent()) {
			Services temp=serviceDAO.findByserviceid(service.getServiceid());
			temp.setServicestatus(service.getServicestatus());
			LocalDateTime time = LocalDateTime.now().withNano(0);
			temp.setServicemodifingtime(time);
			temp.setServiceupdatedby(service.getServiceupdatedby());
			boolean updated = serviceDAO.addservice(temp);
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
	public String deleteservice(int serviceid) {
		Optional<Services> ispresent=serviceDAO.findbyid(serviceid);
		if(ispresent.isPresent()) {
		int temp=serviceDAO.deleteservice(serviceid);
		if(temp>0) {
			logger.info("Operation succesfully");
			return "delete successfully";}
		logger.error("Operation failed");
		throw new OperationFailedException("Operation failed");}
		logger.warn("No data found");
		throw new NoDataFoundException("NO data found");
	}
	
}
