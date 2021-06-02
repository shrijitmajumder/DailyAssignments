package com.capgemini.author.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Shrijit
 *
 */
class AuthorTest {

	/**
	 * @throws java.lang.Exception
	 */
	static Author au;
	Author au1;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	au=new Author("Rama","abcd@xyz.com",'m');
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		au=null;  //eligible for garbage collector
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		au1=new Author();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		au1=null;
	}

	
	@Test
	void testAuthor() {
		assertEquals(new Author(),au1);
	}

	
	/**
	 *  Test method for {@link com.capgemini.author.model.Author#getName()}.
	 */
	@Test
	void testGetName() {
		assertEquals("Rama",au.getName());
	}


	/**
	 *  Test method for {@link com.capgemini.author.model.Author#getEmail()}.
	 */
	@Test
	void testGetEmail() {
		assertEquals("abcd@xyz.com",au.getEmail());
	}

	

	/**
	 * Test method for {@link com.capgemini.author.model.Author#getGender()}.
	 */
	@Test
	void testGetGender() {
		assertEquals('m',au.getGender());
	}

	
}
