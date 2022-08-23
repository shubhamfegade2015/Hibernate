package com.hexaware.hibernateexampleusingjavaconfig;

import java.util.List;

import com.hexaware.hibernateexampleusingjavaconfig.dao.StudentDAO;
import com.hexaware.hibernateexampleusingjavaconfig.entity.Student;

public class MainApp {

	public static void main(String[] args) {
		StudentDAO sdao = new StudentDAO();
		Student st = new Student("Niraj", "Fegade", "nf@gmail.com");
		sdao.saveStudent(st);

		List<Student> students = sdao.getAllStudents();
		students.forEach(s -> System.out.println(s.getStudentEmail()));
		
		Student stById = sdao.getStudentById(st.getStudentId());
		if(stById !=null)
		System.out.println("Student Found" + stById);
		else
			System.out.println("Student Not Found");

	}

}
