package com.spring.data.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.data.jpa.entity.Employee;
import com.spring.data.jpa.service.IEmployeeService;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeRestController {
	
	@Autowired
	IEmployeeService service;
	
	
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee emp) {
		
		return service.addEmployee(emp);
	}
	
	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee emp) {
		return service.updateEmployee(emp);
	}
	
	@GetMapping("/getall")
	public List<Employee> getAllEmployee(){
		return service.getallEmployee();
	}
	
	@GetMapping("/getall/sorted")
	public List<Employee> getAllBySorted(){
		return service.getAllSortedBySalary();	}
	
	@GetMapping("/get/{eid}")
	public Employee getById(@PathVariable int eid) {
		return service.getById(eid);
	}
	
	@DeleteMapping("/delete/{eid}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable int eid){
		service.deleteById(eid);
		return new ResponseEntity<String>("Record Deeleted",HttpStatus.OK);
	}
	
	@GetMapping("/get/{ename}")
	public List<Employee> getByEname(@PathVariable String ename){
		return service.getByEname(ename);
	}
	
	@GetMapping("/getby-gt/{salary}")
	public List<Employee> getBySalaryGT(@PathVariable double salary){	
		return service.getBySalaryGreaterThan(salary);
	}
	
	@GetMapping("/getby-lt/{salary}")
	public List<Employee> getBySalaryLT(@PathVariable double salary){	
		return service.getBySalaryLessThan(salary);
	}
	
	@GetMapping("/getall/byrange/{low}/{high}")
	public List<Employee> getBySalaryRange(@PathVariable  double low , @PathVariable double high){
		System.out.println("values" + low+ " "+ high);
		return service.getBySalaryRange(low, high);
	}
	
	@PostMapping("/update/{eid}")
	public int updateSalary(@PathVariable int eid) {
		return service.update(eid);
	}
	
	@DeleteMapping("/delete-query/{eid}")
	public int deleteByQuery(@PathVariable int eid) {
		return service.deleteByQuery(eid);
	}

}
