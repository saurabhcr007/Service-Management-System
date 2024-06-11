package com.ltts.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ltts.jpa.employeeJPARepoImpl;
import com.ltts.model.Employee;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class employeeDAOImpl implements employeeDAO {

	@Autowired
	private employeeJPARepoImpl JPArepo;

	@Override
	public boolean addemployee(Employee employee) {
		return JPArepo.save(employee) != null;
	}

	@Override
	public List<Employee> getemployee() {
		return (List<Employee>) JPArepo.findAll();
	}

	@Override
	public Employee findByemployeedid(int employeeid) {
		return JPArepo.findByemployeeid(employeeid);
	}

	@Override
	public Optional<Employee> findbyid(int employeeid) {
		return JPArepo.findById(employeeid);
	}

	@Override
	public int deleteemployee(int employeeid) {
		return JPArepo.deleteByemployeeid(employeeid);
	}
	
	
	
}
