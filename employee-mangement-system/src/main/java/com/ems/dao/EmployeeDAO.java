package com.ems.dao;

import com.ems.entity.Employee;

public interface EmployeeDAO {
	
	void saveEmployee(Employee employee);
	Employee getEmployeeUsingId(int id);
	Employee updateEmployee(int id, Employee employee);
    void deleteEmployeeById(int id);
    Employee getEmployeeUsingEmail(String Email);
    void assignDeptToEmployee(int depId,int empId);
   	void assignMangerToEmployee(int managerId, int empId);
   	
   
}
