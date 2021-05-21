package com.capgemini.registeruser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RegisterUserTest {

public static RegisterUser ct;
	
	@BeforeAll
	public static void setUp() {
		System.out.println("this method is annoted with @BeforeAll to execute as first method in the test class RegisterUserTest");
		ct=new RegisterUser("Rama","Krishna","0987654234","username_admin","admin-password");
	}
	
	@BeforeEach
	public void setUpForTest() {
		System.out.println("this method is annoted with @BeforeEach to execute as first method in the test class RegisterUserTest");
		//ct.readDetails();
	}
	
	@Test
	public void testContact() {
		RegisterUser ct=new RegisterUser("Rama","Krishna","0987654234","username_admin","admin-password");
		assertNotNull(ct);
		RegisterUser ctOne = new RegisterUser();
		assertNull(ctOne);
	}
	
	@Test
	public void testGetters() {
		assertEquals("Rama",ct.getFirstName());
		assertEquals("Krishna",ct.getLastName());
		assertEquals("0987654234",ct.getMobileNo());
		assertNotEquals("9876423460",ct.getMobileNo());
		assertEquals("username_admin",ct.getUserName());
		assertEquals("admin-password",ct.getPassword());
	}
	
	@Test
	public void testValidateFirstName() {
		assertSame("First Name is valid", ct.validateFirstName(ct.getFirstName()));
		assertNotSame(null,ct.validateFirstName(ct.getFirstName()));
	}
	
	@Test
	public void testValidateLastName() {
		assertSame("Last Name is valid", ct.validateLastName(ct.getLastName()));
		assertNotSame(null,ct.validateLastName(ct.getLastName()));
	}
	
	@Test
	public void testValidateMobileNo() {
		assertNotSame("mobileNo cannot be less than 10 digits", ct.validateMobileNo(ct.getMobileNo()));
		assertNotSame(null, ct.validateMobileNo(ct.getMobileNo()));
		assertNotSame("mobileNo can contain only digits", ct.validateMobileNo(ct.getMobileNo()));
		assertNotSame("mobileNo should start with 0", ct.validateMobileNo(ct.getMobileNo()));
		assertSame("Mobile number is valid",  ct.validateMobileNo(ct.getMobileNo()));
		assertSame("mobileNo can contain only digits",  ct.validateMobileNo("s123456780"));
		assertSame("mobileNo should start with 0",  ct.validateMobileNo("9075468967"));
	}
	
	@Test
	public void testValidateUserName() {
		assertNotSame("username is valid", ct.validateUserName(ct.getUserName()));
		assertNotSame("username must contain - or _", ct.validateUserName(ct.getUserName()));
		assertSame("username must contain - or _",  ct.validateUserName("username"));
	}
	
	@Test
	public void testValidatePassword() {
		assertNotSame("password is valid", ct.validatePassword(ct.getPassword()));
		assertNotSame("password must be contain more than 8 characters and less than 16 characters", ct.validatePassword(ct.getPassword()));
		assertSame("password is valid",  ct.validatePassword("password1234"));
	}
	
	@Test
	public void testDisplayDetails() {
		assertEquals(new String("The details of the user = Rama Krishna 0987654234 username_admin admin-password"),ct.displayDetails());
		assertNotEquals(new String("The details of the user = Rama Krishna 0987654234 username_admin admin-password"),ct.displayDetails());
	}
	
	@AfterEach
	public void stopThis() {
		System.out.println("this method is annoted with @AfterEach to execute as first method in the test class RegisterUserTest");
	}
	
	@AfterAll
	public static void stopAll() {
		System.out.println("this method is annoted with @AfterAll to execute as first method in the test class RegisterUserTest");
		ct=null;
	}


}
