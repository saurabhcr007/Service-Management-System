package com.ltts.dao;

import java.util.List;
import java.util.Optional;

import com.ltts.model.Services;

public interface ServiceDAO {

	public boolean addservice(Services service);
	public List<Services> getservice();
	public Services findByserviceid(int serviceid);
	public Optional<Services> findbyid(int serviceid);
	public int deleteservice(int serviceid);

}
