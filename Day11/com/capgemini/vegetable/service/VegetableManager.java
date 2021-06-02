package com.capgemini.vegetable.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.capgemini.vegetable.model.Vegetable;
import com.capgemini.vegetable.model.VegetableComparatorByPrice;

public class VegetableManager {

	ArrayList<Vegetable> vegList = new ArrayList<Vegetable>();
	public void createVegetable() {
		Scanner sm=new Scanner(System.in);
		int id=0;
		String name="";
		float price=0;
		if(vegList.size()<1) {
			do {
				System.out.print("Enter ID : ");
				id=sm.nextInt();
				if(id<=0) {
					System.out.println("\nId cannot be zero or negative.");
				}
			}while(id<=0);

			do {
				System.out.print("Enter Name : ");
				sm.nextLine();
				name=sm.next();
				if(name.length()==0) {
					System.out.println("\nName cannot be a null value.");
				}
			}while(name.length()==0);

			do {
				System.out.print("Enter Price : ");
				price=sm.nextFloat();
				if(price<=0) {
					System.out.println("\nPrice cannot be zero or negative.");
				}
			}while(price<=0);
			Vegetable veg = new Vegetable(id,name,price);
			vegList.add(veg);
			System.out.println("\nVegetable Created");
		}
		else {
			int temp=0;
			do {
				temp=0;
			do {
				System.out.print("Enter ID : ");
				id=sm.nextInt();
				if(id<=0) {
					System.out.println("\nId cannot be zero or negative.");
				}
			}while(id<=0);
			for(int i=0;i<vegList.size();i++) {
				if(vegList.get(i).getVegId()==id) {
					temp=1;
					break;
				}
			}
			if(temp==1) {
				System.out.println("\nID already found...Try Again...");
			}else {
				do {
					System.out.print("Enter Name : ");
					sm.nextLine();
					name=sm.next();
					if(name.length()==0) {
						System.out.println("\nName cannot be a null value.");
					}
				}while(name.length()==0);

				do {
					System.out.print("Enter Price : ");
					price=sm.nextFloat();
					if(price<=0) {
						System.out.println("\nPrice cannot be zero or negative.");
					}
				}while(price<=0);
				Vegetable veg = new Vegetable(id,name,price);
				vegList.add(veg);
				System.out.println("\nVegetable Created");
			}
			}while(temp==1);
		}
	}

	public void read() {
		if(vegList.size()<1) {
			System.out.println("\nNo vegetables to read them.");
		}
		else {
			for(int i=0;i<vegList.size();i++) {
				System.out.println("Vegetable No."+(i+1));
				System.out.println(vegList.get(i));
			}
		}
	}
	
	public void update() {
		Scanner sm=new Scanner(System.in);
		int id=0;
		String name="";
		float price=0;
		if(vegList.size()<1) {
			System.out.println("\nNo vegetables to update.");
		}
		else {
			int temp=0;
			int k=0;
			do {
				temp=0;
				k=0;
			do {
				System.out.print("Enter ID of vegetable you want to update : ");
				id=sm.nextInt();
				if(id<=0) {
					System.out.println("\nId cannot be zero or negative.");
				}
			}while(id<=0);
			for(int i=0;i<vegList.size();i++) {
				if(id==vegList.get(i).getVegId()) {
					temp=1;
					k=i;
					break;
				}
			}
			if(temp==0) {
				System.out.println("\nId Not Found...Try Again...");
			}
			else {
				do {
					System.out.print("Enter new Name : ");
					sm.nextLine();
					name=sm.next();
					if(name.length()==0) {
						System.out.println("\nName cannot be a null value.");
					}
				}while(name.length()==0);

				do {
					System.out.print("Enter new Price : ");
					price=sm.nextFloat();
					if(price<=0) {
						System.out.println("\nPrice cannot be zero or negative.");
					}
				}while(price<=0);
				Vegetable veg = new Vegetable(id,name,price);
				vegList.set(k, veg);
				System.out.println("\nVegetable Updated.");
			}
		}while(temp==0);
		}
	}
	public void delete() {
		Scanner sm=new Scanner(System.in);
		int id=0;
		String name="";
		float price=0;
		if(vegList.size()<1) {
			System.out.println("\nNo vegetables to delete them.");
		}
		else {
			int temp=0;
			int k=0;
			do {
				temp=0;
				k=0;
			do {
				System.out.print("Enter ID of vegetable you want to update : ");
				id=sm.nextInt();
				if(id<=0) {
					System.out.println("\nId cannot be zero or negative.");
				}
			}while(id<=0);
			for(int i=0;i<vegList.size();i++) {
				if(id==vegList.get(i).getVegId()) {
					temp=1;
					k=i;
					break;
				}
			}
			if(temp==0) {
				System.out.println("\nId Not Found...Try Again...");
			}
			else {
				vegList.remove(k);
				System.out.println("\nVegetable Deleted.");
			}
		}while(temp==0);
		}
	}
	
	public void sort() {
		if(vegList.size()<1) {
			System.out.println("\nList is empty...Nothing to sort.");
		}
		Collections.sort(vegList);
		System.out.println("\nAfter Sorting");
		for(Vegetable v : vegList) {
			System.out.println(v);
		}
	}
	
	public void sortByPrice() {
		if(vegList.size()<1) {
			System.out.println("\nList is empty...Nothing to sort.");
		}
		Collections.sort(vegList, new VegetableComparatorByPrice());
		System.out.println("\nAfter Sorting");
		for(Vegetable v : vegList) {
			System.out.println(v);
		}
	}
}
