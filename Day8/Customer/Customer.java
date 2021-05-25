package com.capgemini.customer;

public class Customer {

	private int cid;
	private String custname;
	private int age;
	private String dob;
	private String email;
	private String mobilenumber;
	
	public Customer() {
		super();
	}

	public Customer(int cid, String custname, int age, String dob, String email, String mobilenumber) {
		super();
		this.cid = cid;
		this.custname = custname;
		this.age = age;
		this.dob = dob;
		this.email = email;
		this.mobilenumber = mobilenumber;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	@Override
	public String toString() {
		return "Customer ID : " + cid + "\nCustomer Name : " + custname + "\nAge : " + age + "\nDate of Birth : " + dob + "\nEmail : " + email
				+ "\nMobile Number=" + mobilenumber +"\n";
	}

	
	
}
