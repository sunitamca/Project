package com.ems.servicelmpt;

import java.util.Date;

import org.apache.log4j.spi.LoggerFactory;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;

import com.ems.dao.EmployeeDAO;
import com.ems.daoimpl.EmployeeDAOImpl;
import com.ems.entity.Employee;
import com.ems.exception.GlobalException;
import com.ems.model.EmployeeDTO;
import com.ems.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	//accession the data Aceess Layer(DAQ) to call the methods
	EmployeeDAO employeeDAO = new EmployeeDAOImpl();

	@Override
	public void saveEmployee(Employee employee) {
		logger.info("New employee details added!!");
		employeeDAO.saveEmployee(employee);
		
	}

	@Override
	public EmployeeDTO getEmployeeUsingId(int id) {
		Employee employee=employeeDAO.getEmployeeUsingId(id);
		if(employee!=null)
		{
			logger.info("Employee with id "+id+" was retrieved at "+new Date());
			return new ModelMapper().map(employee, EmployeeDTO.class);
			
		}
		else
			throw new GlobalException("Employee details not found!!");
		
	}

	@Override
	public EmployeeDTO updateEmployee(int id, Employee employee) {
		Employee emp =employeeDAO.updateEmployee(id, employee);
		if(emp!=null)
		{
			return new ModelMapper().map(employee, EmployeeDTO.class);
		}
		else
			throw new GlobalException("Employee with "+id+" not found!!");
		
	}

	@Override
	public void deleteEmployeeById(int id) {
		employeeDAO.deleteEmployeeById(id);
		
	}

	@Override
	public EmployeeDTO getEmployeeUsingEmail(String Email) {
		Employee employee=employeeDAO.getEmployeeUsingEmail(Email);
		if(employee!=null)
		{
			logger.info("Employee with id "+Email+" was retrieved at "+new Date());
			return new ModelMapper().map(employee, EmployeeDTO.class);
			
		}
		else
			throw new GlobalException("Employee details not found!!");
	
	}

	@Override
	public void assignEmployeeToDept(int employeeId, int deptId) {
		employeeDAO.assignDeptToEmployee(deptId, employeeId);
		
	}

	@Override
	public void assignMangerToDept(int managerId, int deptId) {
		employeeDAO.assignMangerToEmployee(managerId, deptId);
		
	}

	

		
	}

