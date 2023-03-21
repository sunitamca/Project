package com.ems.daoimpl;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ems.config.HibernateUtil;
import com.ems.dao.ManagerDAO;
import com.ems.entity.Department;
import com.ems.entity.Employee;
import com.ems.entity.Manager;



public class ManagerDAOImpl implements ManagerDAO   {

	//this method get the session to save the new Manger details
	
	@Override
	public void saveManager(Manager manager) {
		try(Session session=HibernateUtil.getSession()){
			
			session.beginTransaction();
			//add all the new Manger details
			session.save(manager);
			
			//java object saved to the database
			session.getTransaction().commit();
			
			//Clear the session
			session.clear();
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public Manager getManagerUsingId(int id) {
		try(Session session=HibernateUtil.getSession())
		{
			Manager manager=session.get(Manager.class, id);
			return manager;
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
	public Manager updateManager(int id, Manager manager) {
		try(Session session=HibernateUtil.getSession())
		{
			Manager manger2=session.get(Manager.class, id);
			
			//updating exiting detail with the session
			manger2.setMName(manager.getMName());
			manger2.setMAddress(manager.getMAddress());
			manger2.setMSalary(manager.getMSalary());
			manger2.setMEmail(manager.getMEmail());
			
			session.beginTransaction();
			session.saveOrUpdate(manger2);
			session.beginTransaction().commit();
			
			return manger2;//returing manger entity
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
	public void deteteManagerById(int id) {
		try(Session session=HibernateUtil.getSession())
		{
			Manager manager2=session.get(Manager.class, id);  
			session.beginTransaction();
			int input=JOptionPane.showConfirmDialog(null, "Do you want to delete?",
					"Are you sure?",JOptionPane.YES_NO_OPTION);
			if(input==0)
			{
				session.delete(manager2);
			}
			else
				JOptionPane.showConfirmDialog(null, "User wants to retain it!");
			session.getTransaction();
			}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	
}
