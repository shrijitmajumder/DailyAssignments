package com.capgemini.author.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class AuthorServiceTest {
	
	/**
	 * Object of AuthorService Class
	 */

	private AuthorService as;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Should print before all tests");
	}

	@BeforeEach
	public void setUp() {
		System.out.println("Should print before every case");
		System.out.println("Instantiating the author service");
		as= new AuthorService();
	}
	/**
	 * @throws java.lang.Exception
	 */

	@Test
	@DisplayName("Should not create author")
	public void shouldCreateContact() {
		as.addAuthor("Rama", "abcd@xyz.com", 'm');
		assertFalse(as.getAllAuthors().isEmpty());
		assertEquals(1,as.getAllAuthors().size());
	}
	
	@Test
	@DisplayName("Should not create author when name is null")
	public void shouldThrowRuntimeExceptionWhenNameIsNull() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			as.addAuthor(null, "abcd@xyz.com", 'm');
		});
	}
	
	@Test
	@DisplayName("Should not create author when email is null")
	public void shouldThrowRuntimeExceptionWhenEmailIsNull() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			as.addAuthor("Rama", null,'m');
		});
	}
	
	@Test
	@DisplayName("Should not create author when gender is null")
	public void shouldThrowRuntimeExceptionWhenGenderIsNull() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			as.addAuthor("Rama", "abcd@xyz.com", ' ');
		});
	}
	
	@Test
	@DisplayName("Should test email must contain @")
	public void shouldTestEmailFormat() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			as.addAuthor("Rama", "abcd", 'm');
		});
	}
	
	@Nested
	class RepeatedTests{
		@DisplayName("should create author")
		@RepeatedTest(value = 5,name ="Repeating author creation test {concurrentRepetition} of {totalRepeatition}")
		public void shouldCreateAuthorRepeatedly() {
			as.addAuthor("Rama", "abcd@xyz.com", 'm');
			assertFalse(as.getAllAuthors().isEmpty());
			assertEquals(1,as.getAllAuthors().size());
		}
	}
	
	@Nested
	class ParamterizedTests{
		@DisplayName("Email should match with required format")
		@ParameterizedTest
		@ValueSource(strings= {"Abc@xyz.com","abc@xyz.com","abcd@xyz.com"})
		public void shouldTestEmailFormatUsingValueSource(String email) {
			as.addAuthor("Rama",email,'m');
			assertFalse(as.getAllAuthors().isEmpty());
			assertEquals(1,as.getAllAuthors().size());
		}
	}
	
	private static List<String> emailList(){
		return Arrays.asList("Abc@xyz.com","abc@xyz.com","abcd@xyz.com");
	}
	
	@DisplayName("Testing Emails in required format using Method Source")
	@ParameterizedTest
	@MethodSource("emailList")
	public void testPhoneNumbersUsingMethodSource(String email) {
		as.addAuthor("Rama",email,'m');
		assertFalse(as.getAllAuthors().isEmpty());
		assertEquals(1,as.getAllAuthors().size());
	}
	
	@Test
	@DisplayName("disable test")
	@Disabled
	public void disabledTest() {
		throw new RuntimeException("this test is a disabled test");
	}
	
	@AfterEach
	public void tearDown() {
		System.out.println("Should execute after each test");
	}
	
	@AfterAll
	public static void tearDownAll() {
		System.out.println("Should execute after all tests");
	}
}
