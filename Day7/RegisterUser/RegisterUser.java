package com.capgemini.registeruser;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterUser {
	
	private String firstName;
	private String lastName;
	private String mobileNo;
	private String userName; //must contain - or _
	private String password;//> 8 characters and < 16 characters
	
	Scanner sc = new Scanner(System.in);

	public RegisterUser() {
		super();
	}

	public RegisterUser(String firstName, String lastName, String mobileNo, String userName, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.userName = userName;
		this.password = password;
	}
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String validateFirstName(String fName) {
		if(fName == null || fName.equals("")) {
			return "First Name cannot be null";
		}else {
			return "First Name is valid";
		}
	}

		public String validateLastName(String lName) {
			if(lName == null || lName.equals("")) {
				return "Last Name cannot be null";
			}else {
				return "Last Name is valid";
			}
	}
	
	public String validateMobileNo(String mobNo) {
		if(mobNo.length() != 10) {
			return "mobileNo cannot be less than 10 digits" ;
		}
		else if(!mobNo.matches("\\d+")) {
			return "mobileNo can contain only digits" ;
		}
		else if(!mobNo.startsWith("0")) {
			return "mobileNo should start with 0";
		}
		else {
			return "Mobile number is valid";
		}
	}
	
	public String validateUserName(String un) {
		String userpattern = "^[A-Za-z0-9]{1,}[._-]{1}[A-Za-z0-9]{1}(.+){3,}$";
		Pattern pat1=Pattern.compile(userpattern);
		boolean username_result;
		Matcher matcher1;
		matcher1=pat1.matcher(un);
		username_result=matcher1.matches();
		if(!username_result)
			return "Invalid Username";
		else
			return "Valid Username";
	}
	
	public String validatePassword(String psw) {
		if(psw.length()<8 || psw.length()>16)
			return "Invalid password";
		else
			return "Valid password";
	}
	
	public void readDetails() {
		System.out.println("Enter the details of Register User");
		System.out.println("Enter the firstName ");
		System.out.println(validateFirstName(firstName = sc.nextLine()));
		System.out.println("Enter the lastName ");
		System.out.println(validateLastName(lastName = sc.nextLine()));
		System.out.println("Enter the mobileNo ");
		System.out.println(validateMobileNo(mobileNo = sc.nextLine()));
		System.out.println("Enter the userName ");
		System.out.println(validateUserName(userName = sc.nextLine()));
		System.out.println("Enter the password ");
		System.out.println(validatePassword(password = sc.nextLine()));
	}
		
	public String displayDetails() {
		return new String("The details of the user = Rama Krishna 0987654234 username_admin admin-password");
	}
	
	public static void main(String[] args) {
		RegisterUser ru=new RegisterUser("Ram","Kumar","0987654324","user-name","password123");
		System.out.println(ru.validateFirstName(ru.getFirstName()));
		System.out.println(ru.validateLastName(ru.getLastName()));
		System.out.println(ru.validateMobileNo(ru.getMobileNo()));
		System.out.println(ru.validateUserName(ru.getUserName()));
		System.out.println(ru.validatePassword(ru.getPassword()));
	}

}
