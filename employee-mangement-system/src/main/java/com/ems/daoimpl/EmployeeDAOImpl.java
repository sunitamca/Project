package com.ems.daoimpl;

import java.io.Serializable;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.ems.config.HibernateUtil;
import com.ems.dao.EmployeeDAO;
import com.ems.entity.Admin;
import com.ems.entity.Department;
import com.ems.entity.Employee;
import com.ems.entity.Manager;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	//this method gets the session to save the new employee details

	@Override
	public void saveEmployee(Employee employee) {
		try(Session session=HibernateUtil.getSession())
		{
			session.beginTransaction();
			//add all the new employee details
			session.save(employee);
			
			//java object saved to the database
			session.getTransaction().commit();
			  
			//clear the session
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
	public Employee getEmployeeUsingId(int id) {
		try(Session session=HibernateUtil.getSession())
		{
			Employee employee=session.get(Employee.class, id);
			return employee;
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
	public Employee updateEmployee(int id, Employee employee) {
		try(Session session=HibernateUtil.getSession())
		{
			Employee emp=session.get(Employee.class, id);
			
			//updating existing details with the new one
			emp.setEmpName(emp.getEmpName());
			emp.setEmpAddress(emp.getEmpAddress());
			emp.setSalary(emp.getSalary());
			emp.setContact(emp.getContact());
			emp.setEmail(emp.getEmail());
			emp.setDesignation(emp.getDesignation());
			emp.setDOJ(emp.getDOJ());
			emp.setUserName(emp.getUserName());
			emp.setPassword(emp.getPassword());
			emp.setManager(emp.getDept().getManager());
			session.beginTransaction();
			session.saveOrUpdate(emp);
			session.beginTransaction().commit();
			
			return emp;//returning employee entity
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public void deleteEmployeeById(int id) {
		try(Session session = HibernateUtil.getSession())
		{
			Employee employee=session.load(Employee.class, id);
			session.beginTransaction();
			int input=JOptionPane.showConfirmDialog(null, "Do you want to delete?",
					"Are you sure?",JOptionPane.YES_NO_OPTION);
			if(input==0)
			{
				session.delete(employee);
				
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
	public Employee getEmployeeUsingEmail(String Email) {
		try(Session session = HibernateUtil.getSession()) {
			//Employee employee = session.get(Employee.class, mail);	//this is only work for id
			String query = "from Employee e where e.email =: m";
			Query q = session.createQuery(query);
			q.setParameter("m", Email);
			
			Employee emp = (Employee) q.uniqueResult();
			
			return emp;
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}

	@Override
	public void assignDeptToEmployee(int depId, int empId) {
		try(Session session = HibernateUtil.getSession()) 
		{
			Employee emp=session.get(Employee.class, empId);
			Department dept = session.get(Department.class, depId);
			
			emp.setManager(null);
		
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
	public void assignMangerToEmployee(int managerId, int empId) {
		try(Session session = HibernateUtil.getSession()) 
        {
   	   Manager man=session.get(Manager.class, managerId);
   	   Employee emp=session.get(Employee.class, empId);
			
			
			emp.setManager(man);
			
			session.beginTransaction();
			session.saveOrUpdate(emp);
			
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

	


