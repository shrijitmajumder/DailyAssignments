package com.capgemini.author.service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.management.RuntimeErrorException;

import com.capgemini.author.model.Author;

/**
 * Author Service class used to store data in a map
 * 
 * @author Shrijit
 *
 */
public class AuthorService {
	Map<String, Author> authorList = new ConcurrentHashMap<String,Author>();

	/*
	 * Constructor
	 */
	public AuthorService() {

	}

	/**
	 * Add author method to add authors in  authorlist objrct
	 * 
	 * @param Name gets name
	 * @param email  gets email
	 * @param gender  gets gender
	 */

	public void addAuthor(String name, String email, char gender) {
		Author author = new Author(name, email, gender);

		validateAuthor(author);
		checkIfAlreadyExists(author);
		authorList.put(generateKey(author), author);
	}

	/**
	 * generateKey method generates key
	 * 
	 * @param author
	 * @return String
	 */
	private String generateKey(Author author) {

		return String.format("%s(%c) at %s", author.getName(), author.getEmail(),author.getGender());
	}

	/**
	 * checkIfAlreadyExist method checks if author already exists or not
	 * 
	 * @param contact
	 */
	private void checkIfAlreadyExists(Author author) {
		if (authorList.containsKey(generateKey(author)))
		throw new RuntimeException("Author Already exists");
	}

	/**
	 * validateAuthor method validates the contact
	 * 
	 * @param contact
	 */
	private void validateAuthor(Author author) {
		author.validateName();
		author.validateEmail();
		author.validateGender();
	}

	/**
	 * returns all values of contact list
	 * 
	 * @return contactList.values()
	 */
	public Collection<Author> getAllAuthors() {
		return authorList.values();
	}
}
