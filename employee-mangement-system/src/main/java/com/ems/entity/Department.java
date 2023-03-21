package com.ems.entity;

import java.util.List;

import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deptId;
	@Column(name="deparyement_name", length=20, nullable = false)
	private String deptName;
	@Column(name="total_employees" , length=10)
	private int totalEmp;
	@Column(length = 20)
	private String location;
	
	@OneToMany
	private List<Employee> employee;
	
	@OneToOne
	private Manager manager;
	

}
