package com.ems.dao;

import com.ems.entity.Admin;
import com.ems.entity.Employee;

public interface AdminDAO {
	
	void saveAdmin(Admin admin);
	boolean login(String userName, String password);
    Admin getAdminUsingId(int id);
	Admin updateAdmin(int id, Admin admin);
    void deleteAdminById(int id);

}
