package com.ems;

import java.time.LocalDate;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.ems.entity.Employee;
import com.ems.exception.GlobalException;
import com.ems.model.EmployeeDTO;
import com.ems.service.EmployeeService;
import com.ems.servicelmpt.EmployeeServiceImpl;

public class EmployeeCRUD {
	
//	static Scanner sc = new Scanner(System.in);
	static EmployeeService empService = new EmployeeServiceImpl();
	
	public static void saveEmployee()
	{
	
		Employee emp = new Employee();
//		sc.nextLine();
//		System.out.println("Enter name:");
//		String name = sc.nextLine();
//		System.out.println("Enter address:");
//		String add = sc.nextLine();
//		System.out.println("Enter salary:");
//		double sal = sc.nextDouble();
//		System.out.println("Enter contact number:");
//		String cont = sc.next();
//		sc.nextLine();
//		System.out.println("Enter email:");
//		String email =sc.nextLine();
//		System.out.println("Enter designation:");
//		String des = sc.next();
//		System.out.println("Enter DOJ:");
//		LocalDate date = LocalDate.parse(sc.next());//yyyy-mm-dd
//		System.out.println("Enter username:");
//		String user = sc.next();
//		System.out.println("Enter password:");
//		String pass = sc.next();
	
		String name = JOptionPane.showInputDialog("Enter name:","Type here..");
		String add = JOptionPane.showInputDialog("Enter address:","Type here..");
		double sal = Double.parseDouble(JOptionPane.showInputDialog("Enter Salary:","Type here.."));
		String cont = JOptionPane.showInputDialog("Enter phone no.:","Type here..");
		String email = JOptionPane.showInputDialog("Enter email:","Type here..");
		String des = JOptionPane.showInputDialog("Enter designation:","Type here..");
		LocalDate date = LocalDate.parse(JOptionPane.showInputDialog("Enter DOJ:","Type here.."));
		String user = JOptionPane.showInputDialog("Enter user-name:","Type here..");
		String pass = JOptionPane.showInputDialog("Enter password:","Typer here..");
		
		emp.setEmpName(name);
		emp.setEmpAddress(add);
		emp.setSalary(sal);
		emp.setContact(cont);
		emp.setEmail(email);
		emp.setDesignation(des);
		emp.setDOJ(date);
		emp.setUserName(user);
		emp.setPassword(pass);
		emp.setRole("employee");
		
	
		empService.saveEmployee(emp);
		System.out.println("Employee details save!!");

	}
	
	public static void updateEmployee() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID to Update Details: ", "Enter ID Here..."));
		Employee emp1 = new Employee();
		
		String name = JOptionPane.showInputDialog("Enter name:","Type here..");
		String add = JOptionPane.showInputDialog("Enter address:","Type here..");
		Double sal = Double.parseDouble(JOptionPane.showInputDialog("Enter Salary:","Type here.."));
		String cont = JOptionPane.showInputDialog("Enter phone no.:","Type here..");
		String email = JOptionPane.showInputDialog("Enter email:","Type here..");
//		String des = JOptionPane.showInputDialog("Enter designation:","Type here..");
		LocalDate date = LocalDate.parse(JOptionPane.showInputDialog("Enter DOJ:","Type here.."));
		String user = JOptionPane.showInputDialog("Enter user-name:","Type here..");
		String pass = JOptionPane.showInputDialog("Enter password:","Typer here..");
		
		emp1.setEmpName(name);
		emp1.setEmpAddress(add);
		emp1.setSalary(sal);
		emp1.setContact(cont);
		emp1.setEmail(email);
//		emp1.setDesignation(des);
		emp1.setDOJ(date);
		emp1.setUserName(user);
		emp1.setPassword(pass);
	//	emp.setRole("employee");
		
		empService.updateEmployee(id, emp1);
		System.out.println("\nDetails Updated Successfully...\n");

		

	}
	
	public static void deleteEmployee() {
		int id= Integer.parseInt(JOptionPane.showInputDialog("Enter id to delete:","Type here..."));
		
		empService.deleteEmployeeById(id);
		JOptionPane.showMessageDialog(null, "Object is deleted!!");
	}

public static void getEmployee() throws GlobalException
{
	int id = Integer.parseInt(JOptionPane.showInputDialog("Enter id to search:","Type here.."));
	EmployeeDTO empl= empService.getEmployeeUsingId(id);
	
	System.out.println("Employee Name: "+empl.getEmpName());
	System.out.println("Employee Address: "+empl.getEmpAddress());
	System.out.println("Employee Salary: "+empl.getSalary());
	System.out.println("Employee Contact: "+empl.getContact());
	System.out.println("Employee Email: "+empl.getEmail());
	System.out.println("Employee Designation: "+empl.getDesignation());
	System.out.println("Employee D.O.J: "+empl.getDOJ());
}

public static void getEmployeebyusingEmail() throws GlobalException {
	String Email =JOptionPane.showInputDialog("Enter Email to search:","Type here..");
	
	empService.getEmployeeUsingEmail(Email);
	JOptionPane.showMessageDialog(null, Email);

	
}
public static void assigndeptoemp() {
	int deptid = Integer.parseInt(JOptionPane.showInputDialog("Enter id to search:","Type here.."));
	int empid = Integer.parseInt(JOptionPane.showInputDialog("Enter id to search:","Type here.."));
	empService.assignEmployeeToDept(empid, deptid);
	JOptionPane.showMessageDialog(null, "Employee has been successfully");
	
}
public static void assigManagertodept()
{
	int deptid = Integer.parseInt(JOptionPane.showInputDialog("Enter id to search:","Type here.."));
	int manid = Integer.parseInt(JOptionPane.showInputDialog("Enter id to search:","Type here.."));
	empService.assignMangerToDept(manid, deptid);
	JOptionPane.showMessageDialog(null, "Manager has been successfully");
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
