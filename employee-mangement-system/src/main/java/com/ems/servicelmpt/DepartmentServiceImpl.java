package com.ems.servicelmpt;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ems.dao.DepartmentDAO;
import com.ems.dao.ManagerDAO;
import com.ems.daoimpl.DepartmentDAOImpl;
import com.ems.entity.Department;
import com.ems.entity.Employee;
import com.ems.exception.GlobalException;
import com.ems.model.DepartmentDTO;

import com.ems.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {
	
	private static final Logger log= LoggerFactory.getLogger(DepartmentServiceImpl.class);

	DepartmentDAO deptDAO = new DepartmentDAOImpl();
	
	@Override
	public void saveDepartment(Department departement) {
		deptDAO.saveDepartment(departement);
		
	}

	@Override
	public DepartmentDTO getDepartementUsingId(int id) {
		Department dept =deptDAO.getDepartmentUsingId(id);
		if(dept!=null)
		{
			return new ModelMapper().map(dept, DepartmentDTO.class);
		}
		else
			throw new GlobalException("Department details not found!!");
	}

	@Override
	public DepartmentDTO updateDepartment(int id, Department department) {
		Department department1 = deptDAO.updateDepartment(id, department);
		if(department1!=null)
		{
			return new ModelMapper().map(department1 ,DepartmentDTO.class);
		}
		else
			throw new GlobalException("Department with "+id+" not found!!");
		
	}

	@Override
	public void deleteDepartmentById(int id) {
		deptDAO.deleteDepartmentById(id);
		
	}

	
	@Override
	public void assignEmployeeToDept(int employeeId, int deptId) {
		deptDAO.assignEmployeeToDept(employeeId, deptId);
		
	}

	@Override
	public void assignMangerToDept(int managerId, int deptId) {
		deptDAO.assignMangerToDept(managerId, deptId);
	   
	}

	


}
