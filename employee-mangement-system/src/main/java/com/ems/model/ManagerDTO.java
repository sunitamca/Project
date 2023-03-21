package com.ems.model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ManagerDTO extends UseeDTO {
	
	private String mName;
	private String mEmail;
	private String mAddress;
	private double mSalary;
	private int mid;
	
	
	private  DepartmentDTO dept;

}
