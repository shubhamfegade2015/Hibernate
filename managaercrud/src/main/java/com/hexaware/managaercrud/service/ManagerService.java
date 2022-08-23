package com.hexaware.managaercrud.service;

import java.util.Scanner;

import com.hexaware.managaercrud.dao.ManagerDao;
import com.hexaware.managaercrud.entity.Manager;

public class ManagerService {

	static Scanner sc = new Scanner(System.in);
	ManagerDao mandao=new ManagerDao();
	
	
	public void managerSave() {
		Manager man = new Manager();
		System.out.println("Enter the details of the manager");
		//sc.nextLine()
		System.out.println("Enter the manager name....");
		man.setManagerName(sc.nextLine());
		System.out.println("Enter the manager email....");
		man.setManagerEmail(sc.nextLine());;
		System.out.println("Enter the manager mobile number....");
		man.setManagerMob(sc.nextLine());;
		mandao.managerSave(man);	
	}
	
	
	public void getAllManagers()
	{
		mandao.getAllManagers();
	}
	
	public  void getDetailsToUpdate() {
		System.out.println("Enter the manager id....");
		Long managerid = sc.nextLong();
		System.out.println("Enter the manager mobile no");
		String managermob = sc.next();
		//return mobNo;
		mandao.updateManager(managerid, managermob);
	}
	
	public void deleteManagerById() {
		System.out.println("Enter the manager id....");
		Long managerid = sc.nextLong();
		mandao.deleteManagerById(managerid);
		
	}
	
	
	

}
