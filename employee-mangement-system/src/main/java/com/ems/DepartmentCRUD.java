package com.ems;

import java.time.LocalDate;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.ems.entity.Department;
import com.ems.entity.Employee;
import com.ems.exception.GlobalException;
import com.ems.model.DepartmentDTO;
import com.ems.model.EmployeeDTO;
import com.ems.service.DepartmentService;
import com.ems.servicelmpt.DepartmentServiceImpl;



public class DepartmentCRUD {
	
//	static Scanner sc = new Scanner(System.in);
	static DepartmentService departmentService = new DepartmentServiceImpl();
	
	public static void saveDepartment()
	{
	
		Department department = new Department();
	
		String name = JOptionPane.showInputDialog("Enter name:","Type here..");
		int total_no = Integer.parseInt(JOptionPane.showInputDialog("Enter toltal_no", "Type here.."));
		String location= JOptionPane.showInputDialog("Enter location:","Type here..");
		
		department.setDeptName(name);
		department.setTotalEmp(total_no);
		department.setLocation(location);
		
		departmentService.saveDepartment(department);
		System.out.println("Department details save!!");

	}

public static void getdepartment() throws GlobalException
{
	int id = Integer.parseInt(JOptionPane.showInputDialog("Enter id to search:","Type here.."));
	DepartmentDTO department= departmentService.getDepartementUsingId(id);
	
	System.out.println("Department Name: "+department.getDeptName());
	System.out.println("Department Location: "+department.getLocation());
	System.out.println("Department Total_no: "+department.getTotalEmp());
	System.out.println("Department Location: "+department.getLocation());
	
}
public static void updateDepartment() {
	int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID to Update Details: ", "Enter ID Here..."));
	Department dept = new Department();
	
	String name = JOptionPane.showInputDialog("Enter name:","Type here..");
	String add = JOptionPane.showInputDialog("Enter address:","Type here..");
	int total_no = Integer.parseInt(JOptionPane.showInputDialog("Enter toltal_no", "Type here.."));
	String location = JOptionPane.showInputDialog("Enter Location:","Type here..");
	
	dept.setDeptId(id);
	dept.setDeptName(name);
	dept.setTotalEmp(total_no);
	dept.setLocation(location);
	
	departmentService.updateDepartment(id, dept);
	System.out.println("\nDetails Updated Successfully...\n");

	

}

public static void deleteDepartment() {
	int id= Integer.parseInt(JOptionPane.showInputDialog("Enter id to delete:","Type here..."));
	
	departmentService.deleteDepartmentById(id);
	JOptionPane.showMessageDialog(null, "Object is deleted!!");
}

public static void getDepartment() throws GlobalException
{
int id = Integer.parseInt(JOptionPane.showInputDialog("Enter id to search:","Type here.."));
DepartmentDTO dept= departmentService.getDepartementUsingId(id);

System.out.println("Department Name: "+dept.getDeptName());
System.out.println("Department Location: "+dept.getLocation());
System.out.println("Department Total_no: "+dept.getTotalEmp());
System.out.println("Department Location: "+dept.getLocation());

}
public static void assignEmptodept() {
	int deptid = Integer.parseInt(JOptionPane.showInputDialog("Enter id to search:","Type here.."));
	int empid = Integer.parseInt(JOptionPane.showInputDialog("Enter id to search:","Type here.."));
	departmentService.assignEmployeeToDept(empid, deptid);
	JOptionPane.showMessageDialog(null, "Employee has been successfully");
	
}
public static void assigManagertodept()
{
	int deptid = Integer.parseInt(JOptionPane.showInputDialog("Enter id to search:","Type here.."));
	int manid = Integer.parseInt(JOptionPane.showInputDialog("Enter id to search:","Type here.."));
	departmentService.assignEmployeeToDept(manid, deptid);
	JOptionPane.showMessageDialog(null, "Manager has been successfully");
}
}



