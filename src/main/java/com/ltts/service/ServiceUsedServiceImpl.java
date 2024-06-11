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
import com.ltts.dao.serviceusedDAO;
import com.ltts.exception.DataPresentException;
import com.ltts.exception.NoDataFoundException;
import com.ltts.exception.OperationFailedException;
import com.ltts.model.Service_Used;
import com.ltts.model.Services;

@Service
public class ServiceUsedServiceImpl implements ServiceUsedService {
	
	@Autowired
	private serviceusedDAO serviceusedDAO;
	
	@Autowired
	private ServiceDAOImpl serviceDAO;
	
	private static final Logger logger=LoggerFactory.getLogger(ServiceUsedServiceImpl.class);
	 
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	@Override
	public String addserviceused(Service_Used serviceused) {
		Optional<Service_Used>ispresent=serviceusedDAO.findbyid(serviceused.getServiceusedid());
		if(ispresent.isPresent()) {
			logger.warn("Data Present already");
			throw new DataPresentException("Data Present already");
		}
		LocalDateTime time = LocalDateTime.now().withNano(0);
		serviceused.setServicestratingtime(time);
		boolean added=serviceusedDAO.addserviceused(serviceused);
		if(added) {
			logger.info("Operation succesfully");
			return "service added successfully";}
		logger.error("Operation failed");
		throw new OperationFailedException("Operation failed");
	}
	
	@Override
	public List<Service_Used> getserviceused(){
		return serviceusedDAO.getserviceused();
	}
	
	@Override
	public String updateserviceused(int serviceusedid) {
		Optional<Service_Used>ispresent=serviceusedDAO.findbyid(serviceusedid);
		if(ispresent.isPresent()) {
			Service_Used temp=serviceusedDAO.findByserviceusedid(serviceusedid);
			LocalDateTime time = LocalDateTime.now().withNano(0);
			temp.setServiceendingtime(time);
			Services service=serviceDAO.findByserviceid(ispresent.get().getServiceid());
			boolean update=serviceusedDAO.addserviceused(temp);
			int cost=service.getServicecost();
			serviceusedDAO.updateServiceUsedTimming(temp.getServiceusedid());
			serviceusedDAO.totalcostforServiceUsed(cost, serviceusedid);
			if(update) {
				logger.info("Operation succesfully");
				return "Update successful";}
			logger.error("Operation failed");
			throw new OperationFailedException("Operation failed");
		}
		logger.warn("No data found");
		throw new NoDataFoundException("NO data found");
	}
	
	@Override
	public String deleteserviceused(int serviceusedid) {
		Optional<Service_Used>ispresent=serviceusedDAO.findbyid(serviceusedid);
		if(ispresent.isPresent()) {
			int temp=serviceusedDAO.deleteserviceused(serviceusedid);
			if(temp>0) {
				logger.info("Operation succesfully");
				return "delete successfully";
			}
			logger.error("Operation failed");
			throw new OperationFailedException("Operation failed");
		}
		logger.warn("No data found");
		throw new NoDataFoundException("NO data found");
	}
}
