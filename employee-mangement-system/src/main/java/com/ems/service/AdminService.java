package com.ems.service;

import com.ems.entity.Admin;
import com.ems.model.AdminDTO;

public interface AdminService {
	
	void saveAdmin(Admin admin);
	boolean login(String userName, String password);
	AdminDTO getAdminUsingId(int id);
	AdminDTO updateAdmin(int id, Admin admin);
    void deleteAdminById(int id);

}
