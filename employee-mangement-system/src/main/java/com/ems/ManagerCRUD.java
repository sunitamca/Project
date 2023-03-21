package com.ems;

import java.util.Scanner;

import javax.swing.JOptionPane;

import com.ems.entity.Manager;
import com.ems.exception.GlobalException;
import com.ems.model.ManagerDTO;
import com.ems.service.ManagerService;
import com.ems.servicelmpt.ManagerServiceImpt;



public class ManagerCRUD  {
	
	static Scanner sc= new Scanner(System.in);
	static ManagerService managerService = new ManagerServiceImpt();
	
	public static void saveManager()
	{
		Manager manager = new Manager();
		String name = JOptionPane.showInputDialog("Enter name:","Type here..");
		String Email = JOptionPane.showInputDialog("Enter email:","Type here..");
		String Address = JOptionPane.showInputDialog("Enter address:","Type here..");
		double Salary = Double.parseDouble( JOptionPane.showInputDialog("Enter salary:","Type here.."));
		
		
		manager.setMName(name);
		manager.setMAddress(Address);
		manager.setMSalary(Salary);
		manager.setMEmail(Email);
		
		managerService.saveManager(manager);
		System.out.println("Manager details save!!");
		
	}
	
	public static void updateManager() {
		int id= Integer.parseInt(JOptionPane.showInputDialog("Enter Id to Update Details:","Enter Id Here..."));
		Manager Manager2 = new Manager();
		
		String name = JOptionPane.showInputDialog("Enter name:","Type here..");
		String Email = JOptionPane.showInputDialog("Enter email:","Type here..");
		String Address = JOptionPane.showInputDialog("Enter address:","Type here..");
		double Salary = Double.parseDouble (JOptionPane.showInputDialog("Enter salary:","Type here.."));
		
		Manager2.setMName(name);
		Manager2.setMEmail(Email);
		Manager2.setMAddress(Address);
		Manager2.setMSalary(Salary);
		
		managerService.updateManager(id, Manager2);
		System.out.println("\nDetails Update Successfully...\n");
		
	}
	public static void getManager() throws GlobalException
	{
		int id= Integer.parseInt(JOptionPane.showInputDialog("Enter Id to search:","Enter Id Here..."));
		ManagerDTO Manager2 = managerService.getManagerUsingId(id);
		
		System.out.println("Manager Name: "+Manager2.getMName());
		System.out.println("Manager Email: "+Manager2.getMEmail());
		System.out.println("Manager Address: "+Manager2.getMAddress());
		System.out.println("Manager Salary: "+Manager2.getMSalary());
	}
	public static void deleteManager() {
		int id= Integer.parseInt(JOptionPane.showInputDialog("Enter id to delete:","Type here..."));
		
		managerService.deteteManagerById(id);
		JOptionPane.showMessageDialog(null, "Object is deleted!!");
	}
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
	
}
