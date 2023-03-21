package com.ems.daoimpl;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ems.config.HibernateUtil;
import com.ems.dao.DepartmentDAO;
import com.ems.entity.Department;
import com.ems.entity.Employee;
import com.ems.entity.Manager;

public class DepartmentDAOImpl implements DepartmentDAO {

	@Override
	public void saveDepartment(Department department) {
		try(Session session=HibernateUtil.getSession())
		{
			session.beginTransaction();
			session.save(department);
			session.getTransaction().commit();
			session.clear();
			
		}
		catch (HibernateException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public Department getDepartmentUsingId(int id) {
		try(Session session=HibernateUtil.getSession())
		{
			Department department=session.get(Department.class, id);
			return department;
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public Department updateDepartment(int id, Department department) {
		try(Session session=HibernateUtil.getSession())
		{
			Department department1=session.get(Department.class, id);
			//updating exiting details with the new one
			department1.setDeptName(department.getDeptName());
			department1.setLocation(department.getLocation());
			department1.setTotalEmp(department.getTotalEmp());
			
			session.saveOrUpdate(department1);
			session.getTransaction().commit();
			return department1;
		
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return null;
	}

	@Override
	public void deleteDepartmentById(int id) {
		
		try(Session session = HibernateUtil.getSession())
		{
			Department department=session.load(Department.class, id);
			session.beginTransaction();
			int input=JOptionPane.showConfirmDialog(null, "Do you want to delete?",
					"Are you sure?",JOptionPane.YES_NO_OPTION);
			if(input==0)
			{
				session.delete(department);
				
			}
			else
				JOptionPane.showMessageDialog(null, "User wants to retain it!");
			
			session.getTransaction().commit();
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	
	
	
	@Override
	public void assignEmployeeToDept(int employeeId, int deptId) {
		try(Session session = HibernateUtil.getSession()) 
		{
			Employee emp=session.get(Employee.class, employeeId);
			Department dept = session.get(Department.class, deptId);
			
			dept.setManager(null);
			
			session.beginTransaction();
			session.saveOrUpdate(dept);
			
			session.getTransaction().commit();
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

		
	}

	@Override
	public void assignMangerToDept(int managerId, int deptId) {
       try(Session session = HibernateUtil.getSession()) 
         {
    	   Manager man=session.get(Manager.class, managerId);
			Department dept = session.get(Department.class, deptId);
			
			dept.setManager(man);
			
			session.beginTransaction();
			session.saveOrUpdate(dept);
			
			session.getTransaction().commit();
			
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}


}
