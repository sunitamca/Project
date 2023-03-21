package com.ems.model;

import java.time.LocalDate;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO extends UseeDTO {
	
	private String empName;
	private String empAddress;
	private double salary;
	private String contact;
	private String email;
	private String designation;
	private LocalDate DOJ;
	private int id;
	
	private DepartmentDTO dept;

}
