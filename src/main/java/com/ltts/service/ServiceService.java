package com.ltts.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ltts.model.Services;

@Service
public interface ServiceService {

	public String addservice(Services service);
	public List<Services> getservice();
	public String updateservice(Services service);
	public String deleteservice(int serviceid);
	
}
