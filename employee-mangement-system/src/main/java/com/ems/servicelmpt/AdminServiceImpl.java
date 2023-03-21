package com.ems.servicelmpt;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;

import com.ems.dao.AdminDAO;
import com.ems.daoimpl.AdminDAOImpl;
import com.ems.entity.Admin;
import com.ems.entity.Employee;
import com.ems.exception.GlobalException;
import com.ems.model.AdminDTO;
import com.ems.model.EmployeeDTO;
import com.ems.service.AdminService;

public class AdminServiceImpl implements AdminService{
	
	AdminDAO adminDao = new AdminDAOImpl();

	@Override
	public void saveAdmin(Admin admin) {
		adminDao.saveAdmin(admin); 
		
	}

	@Override
	public boolean login(String userName, String password) {
		return adminDao.login(userName, password);
		
	}

	@Override
	public AdminDTO getAdminUsingId(int id) {
		Admin admin=adminDao.getAdminUsingId(id);
		if(admin!=null)
		{
	//		Logger.info("Admin with id "+id+" was retrieved at "+new Date());
			return new ModelMapper().map(admin, AdminDTO.class);
			
		}
		else
			throw new GlobalException("Employee details not found!!");
		
	}

	

	@Override
	public AdminDTO updateAdmin(int id, Admin admin) {
		Admin admin2=adminDao.getAdminUsingId(id);
		if(admin!=null)
		{
			return new ModelMapper().map(admin2, AdminDTO.class);
		}
		else
			throw new GlobalException("Admin with "+id+" not found!!");
		
	
	}

	@Override
	public void deleteAdminById(int id) {
		adminDao.deleteAdminById(id);
		
	}
	

}
