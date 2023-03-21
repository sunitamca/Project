package com.ems.dao;

import com.ems.entity.Manager;

public interface ManagerDAO {
	
	void saveManager(Manager manager);
	Manager getManagerUsingId(int id);
	Manager updateManager(int id, Manager manager);
	void deteteManagerById(int id);
	

}
