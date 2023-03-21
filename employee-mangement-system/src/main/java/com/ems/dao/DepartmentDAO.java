package com.ems.dao;

import com.ems.entity.Department;
import com.ems.entity.Employee;

public interface DepartmentDAO {
	
	void saveDepartment(Department department);
	Department getDepartmentUsingId(int id);
	Department updateDepartment(int id, Department department);
	void deleteDepartmentById(int id);
    void assignEmployeeToDept(int employeeId,int deptId);
	void assignMangerToDept(int managerId, int deptId);

}
