package com.spring.data.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.data.jpa.entity.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

	public List<Employee> findByEname(String ename);
	public List<Employee> findBySalaryGreaterThan(double salary);
	public List<Employee> findBySalaryLessThan(double salary);
	
	@Query("from  Employee e1  where e1.salary between ?1 and ?2 order by e1.ename")
	public List<Employee>  getBySalaryRange(double low,double high);
	
	@Modifying
	@Query("update Employee e set e.salary = 90000 where e.eid = :empid")
	public int update(@Param("empid")int empid);
	
	@Modifying
	@Query("delete from Employee e where e.eid = :eid")
	public int deleteByQuery(@Param("eid") int eid);
	
	
}
