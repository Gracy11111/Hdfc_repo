package com.spring.data.jpa.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spring.data.jpa.entity.Employee;
import com.spring.data.jpa.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements IEmployeeService {

	@Autowired
	EmployeeRepository repo;

	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return repo.save(employee);
	}

	@Override
	public Employee getById(int eid) {
		// TODO Auto-generated method stub
		return repo.findById(eid).orElse(null);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return repo.save(employee);
	}

	@Override
	public List<Employee> getallEmployee() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void deleteById(int eid) {
		repo.deleteById(eid);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employee> getByEname(String ename) {
		// TODO Auto-generated method stub
		return repo.findByEname(ename);
	}

	@Override
	public List<Employee> getAllSortedBySalary() {
		// TODO Auto-generated method stub
		return repo.findAll(Sort.by("salary"));
	}

	@Override
	public List<Employee> getBySalaryGreaterThan(double salary) {
		// TODO Auto-generated method stub
		return repo.findBySalaryGreaterThan(salary);
	}

	@Override
	public List<Employee> getBySalaryLessThan(double salary) {
		// TODO Auto-generated method stub
		return repo.findBySalaryLessThan(salary);
	}

	@Override
	public List<Employee> getBySalaryRange(double low, double high) {
		// TODO Auto-generated method stub
		return repo.getBySalaryRange(low, high);
	}

	@Override
	@Transactional
	public int update(int empid) {
		// TODO Auto-generated method stub
		return repo.update(empid);
	}

	@Override
	@Transactional
	public int deleteByQuery(int eid) {
		// TODO Auto-generated method stub
		return repo.deleteByQuery(eid);
	}
	

}
