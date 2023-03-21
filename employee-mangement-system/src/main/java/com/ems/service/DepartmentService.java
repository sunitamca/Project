package com.ems.service;

import com.ems.entity.Department;
import com.ems.model.DepartmentDTO;

public interface DepartmentService {
	
	void saveDepartment(Department departement);
	 DepartmentDTO getDepartementUsingId(int id);
	 DepartmentDTO updateDepartment(int id, Department department);
	 void deleteDepartmentById(int id);
	 void assignEmployeeToDept(int employeeId,int deptId);
	 void assignMangerToDept(int managerId, int deptId);

}
