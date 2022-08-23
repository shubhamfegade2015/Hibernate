package com.hexaware.managaercrud;

import java.util.Scanner;

import com.hexaware.managaercrud.service.ManagerService;

public class ManagerCRUDExample {

	public static void main(String[] args) {
		char ch = 'y';
		String transaction = null;
		Scanner sc = new Scanner(System.in);
		ManagerService manService = new ManagerService();
		
		while(ch == 'y') {
			System.out.println("Enter the transaction type");
			System.out.println("save : to insert a new managaer");
			System.out.println("update : to update an managaer");
			System.out.println("delete : to delete an managaer");
			System.out.println("getall : to get all managaer details");
			transaction = sc.next();
			switch (transaction) {
			case "save":
				manService.managerSave();
				break;
			case "getall":
				manService.getAllManagers();
				break;
			case "delete":
				manService.deleteManagerById();
				break;
			case "update":
				manService.getDetailsToUpdate();
				break;
			default:
				System.out.println("Not a valid transaction");
				break;
				

			}
			System.out.println("Do you want to continue (y-yes/n-no)");
			ch = sc.next().charAt(0);
			
		}
		sc.close();

	}

}
