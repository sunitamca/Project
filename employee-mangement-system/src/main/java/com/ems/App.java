package com.ems;

import java.time.LocalDate;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.ems.entity.Department;
import com.ems.entity.Employee;
import com.ems.entity.Manager;
import com.ems.service.AdminService;
import com.ems.service.EmployeeService;
import com.ems.servicelmpt.AdminServiceImpl;
import com.ems.servicelmpt.EmployeeServiceImpl;

public class App 
{
	static Scanner sc = new Scanner(System.in);
    public static void main( String[] args )
    {
    	mainMenu();   	
    }
    
    public static void mainMenu()
    {
    	int ch;
    	do {
    	
        System.out.println("Welcome to Employee Management System!");
        System.out.println("1) Admin\n2) Employee\n3) Exit");
        
//        int ch = sc.nextInt();
        ch = Integer.parseInt(JOptionPane.showInputDialog("Enter choice: ","Type here"));
        switch(ch)
        {
        case 1:
        	mainAdmin();
          break;
        case 2:
        	mainUser();
        	break;
        case 3:
        	System.exit(0);
        	break;
        	default:
        		System.out.println("Wrong Input!!");
        	
        }
    	}while(ch!=3);
    }
    
    public static void mainUser()
    {
    	System.out.println();
    	do {
    	//EmployeeService empService = new EmployeeServiceImpl();
    	System.out.println("A) save new employee\nB) To check Employee details using Id\n"
    			+ "c)To update Employee details using Id\nD) To delete an employee\nF) Assign DeptToEmployee"
    			+ "G)Assign MangerToEmployee");
//    	char choice = sc.next().charAt(0);
    	String choice = JOptionPane.showInputDialog("Enter Choice","Type here..");
    	switch(choice)
    	{
    	case "A":
    		EmployeeCRUD.saveEmployee();
    		break;
    	case "B":
    		EmployeeCRUD.getEmployee();
    		break;
    	case "C":
    		EmployeeCRUD.updateEmployee();
    		break;
    	case "D":
    		EmployeeCRUD.deleteEmployee();
    		break;
    	case "F":
    		EmployeeCRUD.assigndeptoemp();
    	case "G":
    		EmployeeCRUD.assigManagertodept();
    		
    		
    	}
    	}while(true);
    }
    
    public static void mainAdmin()
    
    {
    	AdminService adminService = new AdminServiceImpl();
    	System.out.println();
    	do {
    	System.out.println("A) Save new admin\nB) LogIn\nC) Exit");
    	String choice = JOptionPane.showInputDialog("Enter choice: ","Type here...");
    	switch(choice)
    	{
    		case "A":
    			AdminCRUD.saveAdmin();
    			break;
    		case "B":
    			String user= JOptionPane.showInputDialog("Enter user name","Type here..");
    			String pass= JOptionPane.showInputDialog("Enter user password","Type here..");
    			boolean status=adminService.login(user, pass);
    			if(status==true)
    			{
    				AdminCRUD.afterLoginAdmin();
    			}
    			else
    			{
    				JOptionPane.showConfirmDialog(null, "Wrong credentials");
    			}
    			//AdminCRUD.login();
    			break;
    		case "C":
    			mainMenu();
    			break;
    	}
    	}while(true);
    }
    
    //mane for Manage
  public static void manager()
  {
	  Manager manager= new Manager();
	  System.out.println();
	  do {
		  System.out.println("A) Save new manager\nB) Delete managerC) Update new manager\n\nD) show manager id\n"
		  		+ "E)Exit");
		  String choice = JOptionPane.showInputDialog("Enter choice: ","Type here..");
		  switch(choice)
		  {
		  case "A":
			  ManagerCRUD.saveManager();
			  break;
		  case "B":
			  ManagerCRUD.updateManager();
			  break;
		  case "C":
			  ManagerCRUD.getManager();
			  break;
		  case "D":
			  ManagerCRUD.deleteManager();
			  break;
		  case "E":
			  System.exit(0);
			  break;
		  default:
      		System.out.println("Wrong Input!!");
			  
		  }
	  }while(true);
  }
  //Main manu for Department
  public static void department()
  {
	  Department dep= new Department();
	  System.out.println();
	  do {
		  System.out.println("A) Save new Department\nB) Delete DepartmentC) Update new Department\n\nD) show Department id\n"
		  		+ "E) Assign EmployeeToDept\nF) Assign MangerToDept\nG) Exit");
		  String choice = JOptionPane.showInputDialog("Enter choice: ","Type here..");
		  switch(choice)
		  {
		  case "A":
			  DepartmentCRUD.saveDepartment();
			  break;
		  case "B":
			  DepartmentCRUD.deleteDepartment();
			  break;
		  case "C":
			  DepartmentCRUD.updateDepartment();
			  break;
		  case "D":
			  DepartmentCRUD.getDepartment();
			  break;
		  case "E":
			  DepartmentCRUD.assignEmptodept();
			  break;
		  case "F":
			  DepartmentCRUD.assigManagertodept();
			  break;
		  case "G":
			  System.exit(0);
			  break;
		  default:
      		System.out.println("Wrong Input!!");
			  
		  }
	  }while(true);
	  
  }
}
