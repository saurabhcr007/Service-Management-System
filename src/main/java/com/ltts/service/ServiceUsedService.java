package com.ltts.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ltts.model.Service_Used;

@Service
public interface ServiceUsedService {

	public String addserviceused(Service_Used serviceused);
	public List<Service_Used> getserviceused();
	public String updateserviceused(int serviceusedid);
	public String deleteserviceused(int serviceusedid);
}
