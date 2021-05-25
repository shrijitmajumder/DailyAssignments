/* Create a class called Customer (cid,custname,age,dob,email,mobilenumber)
using arraylist create list of customers
and while reading the data for the customer validate age(!=0,<0,>100,only digits)
                                                                      validatemobilenumber
                                                                       validateemail
                                                                   cid cannot be zero or null or negativevalue and only digits
                                                                   custname should contain only character */


package com.capgemini.customer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CustomerMain {
	
	final static int MAX=100;
	static Customer cust[]=new Customer[MAX];
	static int num;
	static ArrayList<Customer> custList=new ArrayList<Customer>();
	static Iterator<Customer> custItr=custList.iterator();
	
	public static void addList() throws IOException{
		BufferedReader sm=new BufferedReader(new InputStreamReader(System.in)); // creating Shrijit Majumder's BufferedReader object
		int cid=0;
		String custname="";
		int age=0;
		String dob="";
		String email="";
		String mobilenumber="";
		System.out.print("Enter the number of customers you want to add : ");
		num=Integer.parseInt(sm.readLine());
		if(num<=0) {
			System.out.println("You should add minimum 1 customer...");
		}
		else if(custList.size()+num>MAX && custList.size()>0) {
			System.out.println("Already "+custList.size()+" customers present, more "+num+" customers may exceed the maximum limit which is "+MAX+".");
		}else if(custList.size()==0 && num>MAX) {
			System.out.println("Maximum limit of "+MAX+" exceeded.");
		}else {
			for(int i=0;i<num;i++) {
				System.out.println("Enter details of Customer "+(i+1)+" : ");
				boolean cidresult=false;
				while(cidresult==false) {
					System.out.print("Enter Customer ID : ");
					cid=Integer.parseInt(sm.readLine());
					if(cid<=0) {
						System.out.println("Customer ID cannot be zero or null or negative value.");
						cidresult=false;
					}
					else {
						cidresult=true;
					}
				}
				boolean cnameresult=false;
				while(cnameresult==false) {
					System.out.print("Enter Customer Name : ");
					custname=sm.readLine();
					cnameresult=Pattern.matches("^[a-zA-Z]{1,}",custname);
					if(cnameresult==false) {
						System.out.println("Customer name should contain only alphabets.");
					}else {
						cnameresult=true;
					}
				}
				boolean age_result=false;
				while(age_result==false) {
					System.out.print("Enter Customer Age : ");
					age=Integer.parseInt(sm.readLine());
					if(age<=0 || age>100) {
						System.out.println("Customer Age cannot be <=0 or >100.");
					}
					else {
						age_result=true;
					}
				}
				boolean dob_result=false;
				while(dob_result==false) {
					System.out.print("Enter Customer Date of Birth in dd-MM-yyyy format : ");
					dob=sm.readLine();
					SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
					sdf.setLenient(false);
					try {
						Date date_inp= sdf.parse(dob);
						Date date=new Date();
						ZoneId zid=ZoneId.systemDefault();
						Instant ins1=date.toInstant();
						Instant ins2=date_inp.toInstant();
						LocalDate ldt1=ins1.atZone(zid).toLocalDate();
						LocalDate ldt2=ins2.atZone(zid).toLocalDate();
						Period p=Period.between(ldt2, ldt1);
						if(p.getYears()==age) {
							dob_result=true;
						}
						else {
							System.out.println("Date of birth is wrong as per the age given.");
						}
						
					} catch (ParseException e) {
						System.out.println("Either date format is wrong or date does not exist.");
					}
				}
				boolean cemailresult=false;
				while(cemailresult==false) {
					System.out.print("Enter Customer Email : ");
					email=sm.readLine();
					cemailresult=Pattern.matches("^[a-z]{1,}[a-z0-9._]{1,}[a-z0-9]@[a-z]{1,}[.]{1}[a-z]{1,}$", email);
					if(cemailresult==false) {
						System.out.println("Email should contain only @ followed by domain name and should be minimum of length 7 and should not contain any space or special characters (except . or _ ) in between and should not contain upper case characters.");
					}else {
						cemailresult=true;
					}
				}
				boolean mobnoresult=false;
				while(mobnoresult==false) {
					System.out.print("Enter Customer Mobile Number : ");
					mobilenumber=sm.readLine();
					mobnoresult=Pattern.matches("^[789]{1}[0-9]{9}$", mobilenumber);
					if(mobnoresult==false) {
						System.out.println("Mobile Number should start with 7, 8 or 9 and should be of 10 digits only.");
					}else {
						mobnoresult=true;
					}
				}
				cust[i]=new Customer(cid,custname,age,dob,email,mobilenumber);
				custList.add(cust[i]);
			}
		}
		
	}
	
	public static void displayDetails() {
		if(custList.size()<=0) {
			System.out.println("\nDisplay not possible because list is blank.");
		}else {
		System.out.println("\nThe details are given below : \n");
		for(int i=0;i<custList.size();i++) {
			System.out.println("Customer "+(i+1)+"\n----------------");
			System.out.println(custList.get(i));
			//System.out.println(cust[i]);
		}
		}
	}
	
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner sm=new Scanner(System.in); // creating Shrijit Majumder's Scanner Object
		int choice;
		char choice1='y';
		while(choice1!='n' && choice1!='N') {
			System.out.print("\n1. Add Customers\n2. Display Customer\n\nEnter your choice : ");
			choice=sm.nextInt();
			switch(choice) {
			case 1 : addList();
			break;
			case 2 : displayDetails();
			break;
			default : System.out.print("Enter correct choice (1-4)...");
			}
			System.out.print("\nDo you want to continue?(y/n) ");
			choice1=sm.next().trim().charAt(0);
			
		}
		sm.close();
	}

}
