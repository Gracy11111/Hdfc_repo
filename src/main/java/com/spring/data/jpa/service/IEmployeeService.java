package com.spring.data.jpa.service;

import java.util.List;
import org.springframework.data.repository.query.Param;

import com.spring.data.jpa.entity.Employee;

public interface IEmployeeService {
	
	public Employee addEmployee(Employee employee);
	public Employee getById(int eid);
	public Employee updateEmployee(Employee employee);
	public List<Employee> getallEmployee();
	public List<Employee> getAllSortedBySalary();
	public void deleteById(int eid);
	public List<Employee> getByEname(String ename);
	public List<Employee> getBySalaryGreaterThan(double salary);
	public List<Employee> getBySalaryLessThan(double salary);
	public List<Employee> getBySalaryRange(double low , double high);
	public int update(int empid);
	public int deleteByQuery(int eid);

}
