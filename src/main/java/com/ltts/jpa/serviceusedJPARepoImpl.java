package com.ltts.jpa;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ltts.model.Service_Used;

import jakarta.transaction.Transactional;

@Repository
public interface serviceusedJPARepoImpl extends CrudRepository<Service_Used, Integer> {

	int deleteByserviceusedid(int serviceusedid);

	Service_Used findByserviceusedid(int serviceusedid);
	
	@Transactional
	@Modifying
	@Query("UPDATE Service_Used su SET su.serviceusedtimming=CAST(TIMEDIFF(su.serviceendingtime,su.servicestratingtime) AS TIME) WHERE su.serviceusedid=?1")
	void updateServiceUsedTimming(int serviceusedid);
	
	
	
	@Transactional
	@Modifying
	@Query("UPDATE Service_Used su SET su.serviceusedcost = CONCAT( CAST(ROUND(TIMESTAMPDIFF(HOUR, su.servicestratingtime, su.serviceendingtime) + \n" +
	       "IFNULL(TIMESTAMPDIFF(MINUTE, su.servicestratingtime, su.serviceendingtime) / 60.0, 0) + \n" +
	       "IFNULL(TIMESTAMPDIFF(SECOND, su.servicestratingtime, su.serviceendingtime) / 3600.0, 0), 1) * ?1 AS String),' INR') \n" +
	       "WHERE su.serviceusedid = ?2")
	void totalcostforServiceUsed(int cost, int serviceusedid);
	
//	@Transactional
//	@Modifying
//	@Query("UPDATE Service_Used su SET su.serviceusedcost = CONCAT(su.serviceusedcost,' INR') WHERE su.serviceusedid = ?1")
//	void  currencysetting(int serviceusedid);
	
}
