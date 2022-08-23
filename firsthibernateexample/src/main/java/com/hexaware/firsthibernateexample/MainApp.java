package com.hexaware.firsthibernateexample;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hexaware.firsthibernateexample.entity.Student;
import com.hexaware.firsthibernateexample.util.HibernateUtil;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student st = new Student("Niraj","Fegade","nf@gmail.com");
		Student st1 = new Student("Shubham","Fegade","sf@gmail.com");

		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			//start transaction
			transaction=session.beginTransaction();
			//save transaction
			session.save(st1);
			session.save(st);
			//Committed transaction	
			transaction.commit();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			if(transaction != null)
			{
				transaction.rollback();
			}
			
			e.printStackTrace();
		}finally {
			//closing the session
			if(session != null)
			{
				session.close();
			}
			
		}
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			List<Student> students =  session.createQuery("from Student",Student.class).list();
			students.forEach(s -> System.out.println(s.getStudentFirstName()));
		} catch (Exception e) {
			if(transaction != null)
			{
				transaction.rollback();
			}
			
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			if(session != null)
			{
				session.close();
			}
		}
	}

}
