package com.ems.servicelmpt;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;

import com.ems.dao.ManagerDAO;
import com.ems.daoimpl.ManagerDAOImpl;
import com.ems.entity.Manager;
import com.ems.exception.GlobalException;
import com.ems.model.EmployeeDTO;
import com.ems.model.ManagerDTO;
import com.ems.service.ManagerService;

public class ManagerServiceImpt implements ManagerService{
	
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	//accession the data Aceess Layer(DAQ) to call the methods
	ManagerDAO managerDAO = new ManagerDAOImpl();

	@Override
	public void saveManager(Manager manager) {
		logger.info("New manger datails added!!");
		managerDAO.saveManager(manager);
		
	}

	@Override
	public ManagerDTO getManagerUsingId(int id) {
		Manager manager=managerDAO.getManagerUsingId(id);
		if(manager!=null)
		{
			logger.info("Manager with id "+id+" was retrieved at "+new Date());
			return new ModelMapper().map(manager, ManagerDTO.class);
		}
		else
			throw new GlobalException("Manager details not found!!");
		
	}

	@Override
	public ManagerDTO updateManager(int id, Manager manager) {
		Manager manager2 =managerDAO.updateManager(id, manager);
		if(manager2!=null)
		{
			return new ModelMapper().map(manager2, ManagerDTO.class);
		}
		else
			throw new GlobalException("Manger with "+id+" not found!!");
		
	}

	@Override
	public void deteteManagerById(int id) {
		managerDAO.deteteManagerById(id);
		
	}

	

}
