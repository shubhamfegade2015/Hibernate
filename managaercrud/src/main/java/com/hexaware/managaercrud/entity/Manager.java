package com.hexaware.managaercrud.entity;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="manager")
public class Manager {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="managerid")
	private Long managerId;
	@Column(name="managername")
	private String managerName;
	@Column(name="manageremail")
	private String managerEmail;
	@Column(name = "managermob")
	private String managerMob;
	
	public Manager() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Manager(Long managerId, String managerName, String managerEmail) {
		super();
		this.managerId = managerId;
		this.managerName = managerName;
		this.managerEmail = managerEmail;
	}


	public Long getManagerId() {
		return managerId;
	}
	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerEmail() {
		return managerEmail;
	}
	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}


	

	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", managerName=" + managerName + ", managerEmail=" + managerEmail
				+ ", managerMob=" + managerMob + "]";
	}


	public String getManagerMob() {
		return managerMob;
	}


	public void setManagerMob(String managerMob) {
		this.managerMob = managerMob;
	}
	
	
	
	
	
}
