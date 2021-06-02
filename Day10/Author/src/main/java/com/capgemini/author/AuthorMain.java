package com.capgemini.author;

import java.util.Scanner;

import com.capgemini.author.model.Author;

public class AuthorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sm=new Scanner(System.in);
		Author au;
		System.out.print("\nEnter the name : ");
		String name=sm.next();
		System.out.print("\nEnter the name : ");
		String email=sm.next();
		System.out.print("\nEnter the name : ");
		char gender=sm.next().trim().charAt(0);
		au=new Author(name,email,gender);
		au.print();
	}

}
