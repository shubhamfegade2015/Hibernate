package com.hexaware.hibernateexampleusingjavaconfig.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hexaware.hibernateexampleusingjavaconfig.entity.Student;
import com.hexaware.hibernateexampleusingjavaconfig.util.HibernateUtil;
public class StudentDAO {

	
	Session session = null;
	Transaction transaction = null;
	public void saveStudent(Student student) {
		
		try {
			session= HibernateUtil.getSessionFactory().openSession();
			//start transaction
			transaction = session.beginTransaction();
			//save thes student object
			session.save(student);
			//commit transaction
			transaction.commit();
			
		}catch (Exception e) {
			if(transaction!= null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
	}
	
	public List<Student> getAllStudents(){
		List<Student> stList = null;
		try {
			session= HibernateUtil.getSessionFactory().openSession();
			stList = session.createQuery("from Student",Student.class).list();
		}catch (Exception e) {
			if(transaction!= null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return stList;
	}
	
	public Student getStudentById(Long studentId) {
		Student st = new Student();
		try {
			session= HibernateUtil.getSessionFactory().openSession();
			st = session.get(Student.class, studentId);
			
		}catch (Exception e) {
			if(transaction!= null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return st;
	}
}
