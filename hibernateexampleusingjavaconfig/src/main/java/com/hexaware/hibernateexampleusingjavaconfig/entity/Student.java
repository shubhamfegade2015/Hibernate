package com.hexaware.hibernateexampleusingjavaconfig.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_data")
public class Student {
	
	public Student() {
		// default constructor
	}
	
	/*
	 * Specifies the primary key of an entity.
	 * The field or property to which the Id annotation is applied
	 * should be one of the following types: any Java primitive type;
	 * any primitive wrapper type; 
	 * String; 
	 * java.util.Date; 
	 * java.sql.Date; 
	 * java.math.BigDecimal; 
	 * java.math.BigInteger. 
	   The mapped column for the primary key of the entity is assumed
	   to be the primary key of the primary table. 
	   If no Column annotationis specified, 
	   the primary key column name is assumed to be the name
	   of the primary key property or field. 
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentid")
	private Long studentId;
	
	@Column(name = "studentfirstname")
    private String studentFirstName;

    @Column(name = "studentlastname")
    private String studentLastName;

    @Column(name = "studentemail")
    private String studentEmail;

	public Student(String studentFirstName, String studentLastName, String studentEmail) {
		super();
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
		this.studentEmail = studentEmail;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentFirstName() {
		return studentFirstName;
	}

	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}

	public String getStudentLastName() {
		return studentLastName;
	}

	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentFirstName=" + studentFirstName + ", studentLastName="
				+ studentLastName + ", studentEmail=" + studentEmail + "]";
	}
	
	
    
    

}
