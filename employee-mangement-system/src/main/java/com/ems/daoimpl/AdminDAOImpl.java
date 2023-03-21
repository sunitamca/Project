package com.ems.daoimpl;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ems.config.HibernateUtil;
import com.ems.dao.AdminDAO;
import com.ems.entity.Admin;
import com.ems.entity.Employee;

public class AdminDAOImpl implements AdminDAO{

	@Override
	public void saveAdmin(Admin admin) {
		try(Session session= HibernateUtil.getSession())
		{
			session.beginTransaction();
			session.save(admin);
			session.getTransaction().commit();
			session.clear();
			
		}
		catch (HibernateException e) {
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public boolean login(String userName, String password) {
		try(Session session= HibernateUtil.getSession())
		{
			int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Id: ","Type here.."));
			Admin admin=session.get(Admin.class, id);
			if(admin.getUserName().equals(userName) && admin.getPassword().equals(password)
					&& admin.getRole().equalsIgnoreCase("admin"))
			{
				JOptionPane.showMessageDialog(null, "Log In successfull!!");
				return true;
			}
			else {
				JOptionPane.showMessageDialog(null, "Wrong Credentials!!");
				return false;
			}
		}
		
		
	}

	@Override
	public Admin getAdminUsingId(int id) {
		try(Session session= HibernateUtil.getSession())
		{
			Admin admin=session.get(Admin.class, id);
			return admin;
			
		}
		catch (HibernateException e) {
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}

	@Override
	public Admin updateAdmin(int id, Admin admin) {
		try(Session session=HibernateUtil.getSession())
		{
			Admin admin1=session.get(Admin.class, id);
			
			//updating existing details with the new one
			admin1.setAdminName(admin1.getAdminName());
			admin1.setAdminEmail(admin.getAdminEmail());
			admin1.setUserName(admin1.getUserName());
			admin1.setPassword(admin.getPassword());
			
			session.beginTransaction();
			session.saveOrUpdate(admin);
			session.beginTransaction().commit();
			
			return admin;//returning admin entity
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
	public void deleteAdminById(int id) {
		try(Session session = HibernateUtil.getSession())
		{
			Admin admin1=session.get(Admin.class, id);
			session.beginTransaction();
			int input=JOptionPane.showConfirmDialog(null, "Do you want to delete?",
					"Are you sure?",JOptionPane.YES_NO_OPTION);
			if(input==0)
			{
				session.delete(admin1);
				
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
		
	}


