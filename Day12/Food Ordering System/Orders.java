package com.capgemini.food_ordering_system.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Orders {
	static Connection con = null;
	static ResultSet rs = null;
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner sc = new Scanner(System.in);
		Customer cs = new Customer();
		Vendor vs = new Vendor();
		Item is = new Item();
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		
		char ch = 'y';
		String Name = null;
		String Email = null;
		String Password = null;
		String PhoneNumber = null;
		double Price = 0;
		do {
			
			System.out.println("1. Customer \n2. Vendor\n3. Item\n\nEnter your choice : ");
			int choice = sc.nextInt();
			switch(choice) {
			//FOR CUSTOMER
			case 1:
				System.out.println("1. Sign Up \n2. Log In\n\nEnter your choice : ");
				int choice_1 = sc.nextInt();
				switch(choice_1) {
				//SIGN UP FOR CUSTOMER
				case 1: 
					Name = cs.takeName();
					Email = cs.takeEmail();
					Password = cs.takePassword();
					PhoneNumber = cs.takePhoneNumber();
					if(cs.tableExists("CUSTOMER", con)){
						cs.registerCustomer(Name,Password, Email, PhoneNumber);
					}
					else {
						cs.createCustomerTable();
						cs.registerCustomer(Name,Password, Email, PhoneNumber);
					}
					break;
				//LOG IN FOR CUSTOMER
				case 2: 
					Email = cs.takeEmail();
					Password = cs.takePassword();
					if(cs.loginCustomer(Email, Password)) {
						System.out.println("Log in Successfull.");
					}else {
						System.out.println("Email or password is wrong.");
					}
					break;
				default:
					System.out.println("Wrong Choice!");
				}
				break;
			//FOR VENDOR
			case 2:
				System.out.println("1. Sign Up \n2. Log In\n\nEnter your choice : ");
				int choice_2 = sc.nextInt();
				switch(choice_2) {
				//FOR VENDOR SIGN UP
				case 1:
					Name = vs.takeName();
					Email = vs.takeEmail();
					Password = vs.takePassword();
					PhoneNumber = vs.takePhoneNumber();
					if(vs.tableExists("VENDOR", con)){
						vs.registerVendor(Name, Email,Password, PhoneNumber);
					}
					else {
						vs.createVendorTable();
						vs.registerVendor(Name, Email, Password, PhoneNumber);
					}
					break;
				//FOR VENDOR LOG IN	
				case 2:
					Email = vs.takeEmail();
					Password = vs.takePassword();
					if(vs.loginVendor(Email, Password)) {
						System.out.println("Log in Successfull.");
					}else {
						System.out.println("Email or password is wrong.");
					}
					break;
				default:
					System.out.println("Wrong Choice!");
				}
				break;
			case 3:
				Name = is.takeName();
				Price = is.takePrice();
				if(is.tableExists("ITEM", con)){
					is.addItem(Name, Price);
				}
				else {
					is.createItemTable();
					is.addItem(Name, Price);
				}
				break;
			default:
				System.out.println("Wrong Choice!");
			}
			
		System.out.println("Enter y to continue");
		ch = sc.next().trim().charAt(0);
		}while(ch == 'y');
		
	}

}
