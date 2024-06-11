package com.ltts.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ltts.model.Employee;

@Repository
public interface employeeJPARepoImpl extends CrudRepository<Employee, Integer> {

	Employee findByemployeeid(int employeeid);

	int deleteByemployeeid(int employeeid);

}
