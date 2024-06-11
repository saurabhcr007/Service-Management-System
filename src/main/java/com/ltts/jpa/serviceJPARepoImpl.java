package com.ltts.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ltts.model.Services;

@Repository
public interface serviceJPARepoImpl extends CrudRepository<Services, Integer>  {
	
	public Services findByserviceid(int serviceid);
	public int deleteByserviceid(int serviceid);

}
