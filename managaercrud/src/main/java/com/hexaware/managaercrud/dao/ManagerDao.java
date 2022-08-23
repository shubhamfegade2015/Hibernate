package com.hexaware.managaercrud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hexaware.managaercrud.entity.Manager;
import com.hexaware.managaercrud.util.HibernateUtil;

public class ManagerDao {
	
	public void managerSave(Manager man) {
			Transaction transaction = null;
			Session session = null;
			
			try {
				session =  HibernateUtil.getSessionFactory().openSession();
				// start the transaction
				transaction = session.beginTransaction();
				// save the employee object in to database
				session.save(man);
				// commit transaction
				transaction.commit();
				
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}

				e.printStackTrace();
			}finally {
				if (session!=null) {
					session.close();
				}
			}
		
	}
	
	
	
	public void getAllManagers()
	{
		
		Session session = null;
		try {
			session =  HibernateUtil.getSessionFactory().openSession();
			List<Manager> mList=session.createQuery("from Manager",Manager.class).list();
			mList.forEach(m -> System.out.println(m));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void deleteManagerById(Long managerid) {
		Transaction transaction = null;
		Session session = null;
		try {
			
			
			session =  HibernateUtil.getSessionFactory().openSession();
			transaction=session.beginTransaction();
			Manager deleteMan=session.get(Manager.class,managerid);
			System.out.println(deleteMan);
			if (deleteMan!=null) {
				session.delete(deleteMan);
				System.out.println("Manager deleted successfully");
			}
			transaction.commit();
			
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		
		
	}
	
	
	public void updateManager(Long managerid,String managermob)
	{
		Transaction transaction = null;
		Session session = null;
		try {
			
			 session = HibernateUtil.getSessionFactory().openSession();
			 transaction = session.beginTransaction();
			 
			 Manager updatingMan = session.get(Manager.class, managerid);
				System.out.println(updatingMan);
				updatingMan.setManagerMob(managermob);
				
				session.saveOrUpdate(updatingMan);
				
				transaction.commit();
			
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}finally {
			if (session!=null) {
				session.close();
			}
		}
		
		
	}

}
