package com.ems;

import java.time.LocalDate;

import javax.swing.JOptionPane;

import com.ems.entity.Admin;
import com.ems.entity.Employee;
import com.ems.exception.GlobalException;
import com.ems.model.AdminDTO;
import com.ems.model.EmployeeDTO;
import com.ems.service.AdminService;
import com.ems.servicelmpt.AdminServiceImpl;

public class AdminCRUD {
	
	static AdminService adminService = new AdminServiceImpl();
	
	public static void saveAdmin()
	{
		Admin admin = new Admin();
		String name = JOptionPane.showInputDialog("Enter admin name:","Type here..");
		String email = JOptionPane.showInputDialog("Enter admin email:","Type here..");
		String user = JOptionPane.showInputDialog("Enter  user_name:","Type here..");
		String pass = JOptionPane.showInputDialog("Enter password:","Type here..");
		
		admin.setAdminName(name);
		admin.setAdminEmail(email);
		admin.setUserName(user);
		admin.setPassword(pass);
		admin.setRole("admin");
		
		adminService.saveAdmin(admin);
		System.out.println("New admin details has been added!");
	}
	
//	public static void login()
//	{
//		String user = JOptionPane.showInputDialog("Enter user_name:","Type here..");
//		String pass = JOptionPane.showInputDialog("Enter password:","Type here..");
//		
//		adminService.login(user, pass);
//		boolean status=adminService.login(user, pass);
//		if(status==false)
//		{
//			JOptionPane.showInternalMessageDialog(null, "Loging success full");
//		}
//		else
//		{
//			JOptionPane.showConfirmDialog(null, "Wrong credentials");
//		}
//	}

	public static void afterLoginAdmin()
    {
		do {
    	System.out.println();
      	System.out.println("A) Save new department\nB) To check department details using ID\n"
      			+ "C) Assign employee to department\nD) To update employee details\n"
      			+ "E) To delete an employee\nF) Save new manager\n"
      			+ "G) Exit");
      	String choice = JOptionPane.showInputDialog("Enter choice: ","Type here...");
    	switch(choice)
    	{
    	case "A":
    		DepartmentCRUD.saveDepartment();
    		break;
    		
    	case "B":
    		DepartmentCRUD.getDepartment();
    		break;
    	
    	case "C":
    		//DepartmentCRUD.assign();
    		break;
    		
    	case "D":
    		EmployeeCRUD.updateEmployee();
    		break;
    		
    	case "E":
    		EmployeeCRUD.deleteEmployee();
    		break;
    	case "F":
    		ManagerCRUD.saveManager();
    		break;
    		
    	case "G":
    		App.mainAdmin();
    		break;
    	}
		}while(true);
    }
	public static void updateAdmin() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID to Update Details: ", "Enter ID Here..."));
		Admin admin=new Admin();
		
		String name = JOptionPane.showInputDialog("Enter name:","Type here..");
		String email = JOptionPane.showInputDialog("Enter email:","Type here..");
		String user = JOptionPane.showInputDialog("Enter user-name:","Type here..");
		String pass = JOptionPane.showInputDialog("Enter password:","Typer here..");
		
		admin.setAdminName(name);
		admin.setAdminEmail(email);
		admin.setUserName(user);
		admin.setPassword(pass);
	
		
		adminService.updateAdmin(id, admin);
		System.out.println("\nDetails Updated Successfully...\n");
		
	}
	public static void deleteAdmin() {
		int id= Integer.parseInt(JOptionPane.showInputDialog("Enter id to delete:","Type here..."));
		
		adminService.deleteAdminById(id);
		JOptionPane.showMessageDialog(null, "Object is deleted!!");
	}

     public static void getAdmin() throws GlobalException
    {
	int id = Integer.parseInt(JOptionPane.showInputDialog("Enter id to search:","Type here.."));
	AdminDTO admin= adminService.getAdminUsingId(id);
	
	System.out.println("Admin Name: "+admin.getAdminName());
	System.out.println("Admin Email: "+admin.getAdminEmail());
	System.out.println("Admin UserNname: "+admin.getUserName());
	System.err.println("Admin Password: "+admin.getPassword());
	
}
}
