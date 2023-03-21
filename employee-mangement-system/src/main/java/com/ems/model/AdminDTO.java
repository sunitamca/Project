package com.ems.model;

import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminDTO extends UseeDTO {
	
	private String adminName;
	private String adminEmail;
	
	private DepartmentDTO dept;
	

}
