package com.capgemini.author.model;

/**
 * Program to instantiate Author class data members
 * @author Shrijit
 *
 */
public class Author {
	
	/**
	 * name for storing name of author
	 */
	private String name;
	
	/**
	 * email for storing email of author
	 */
	private String email;
	
	/**
	 * gender for storing gender of author
	 */
	private char gender;
	
	/**
	 * default constructor
	 */
	public Author() {
		super();
	}

	/**
	 * @param name
	 * @param email
	 * @param gender
	 */
	public Author(String name, String email, char gender) {
		//super();
		this.name = name;
		this.email = email;
		this.gender = gender;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the gender
	 */
	public char getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(char gender) {
		this.gender = gender;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + gender;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (gender != other.gender)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Author [name=" + name + ", email=" + email + ", gender=" + gender + "]";
	}
	
	/**
	 * print method to print the author details
	 */
	public void print() {
		System.out.printf("%s(%c) at %s\n",name,gender,email);
	}
	
	/**
	 * method to validate name
	 */
	public void validateName() {
		if(this.name.isBlank())
			throw new RuntimeException("Name cannot be null");
		if(!this.name.matches("^[A-Za-z]+$"))
			throw new RuntimeException("Name cannot contain any character other than alphabets");
	}
	
	/**
	 * method to validate email
	 */
	public void validateEmail() {
		if(this.email.isBlank())
			throw new RuntimeException("Email cannot be null");
		if(!this.email.contains("@"))
			throw new RuntimeException("Email must contain @ symbol");
	}
	
	/**
	 * method to validate gender
	 */
	public void validateGender() {
		if(this.gender!='m' && this.gender!='f' && this.gender!='u')
			throw new RuntimeException("Gender can be only 'm', 'f' or 'u'.");
	}
}
