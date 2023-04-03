package com.spring.data.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

@Entity
@Table(name="Employee_Info")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eid;
	@Column(name="empname")
	private String ename;
	private double salary;

}
