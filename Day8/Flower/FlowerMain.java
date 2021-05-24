package com.capgemini.flower;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class FlowerMain {
	
	static int max=100;
	static HashSet<Flower> flowerList=new HashSet<Flower>();
	static Iterator<Flower> fitr = flowerList.iterator();
	static Flower flower[]=new Flower[max];
	static int num;
	public static void read() {
		Scanner sm=new Scanner(System.in);
		System.out.print("Enter the number of flowers you want to add : ");
		num=sm.nextInt();
		if(num<=100) {
		for(int i=0;i<num;i++) {
			System.out.println("Enter Details of Flower "+(i+1));
			System.out.print("Enter flower id : ");
			int fid=sm.nextInt();
			System.out.print("Enter flower name : ");
			sm.nextLine();
			String fname=sm.nextLine();
			System.out.print("Enter price per kg : ");
			double pricePerKg=sm.nextDouble();
			System.out.print("Enter quantity : ");
			float qty=sm.nextFloat();
			flower[i]=new Flower(fid,fname,pricePerKg,qty);
			flowerList.add(flower[i]);
		}
		}else {
			System.out.println("Maximum Size Exceeded....");
		}
	}
	
	public static void displayFlowers() {
		fitr = flowerList.iterator();
		if(flowerList.size()<1) {
		System.out.println("\nDisplay not possible since no flower is added...");
	}else {
		int k=1;
			System.out.println("The flowers are : ");
			while(fitr.hasNext()) {
				System.out.println(fitr.next().toString(k));
				k++;
			}
	}
	}

	public static void remove() {
		if(flowerList.size()<1) {
			System.out.println("\nRemoval not possible since no flower is added...");
		}else {
			for(int i=0;flower[i]!=null;i++) {
				if(flower[i].getQty()<=0) {
					flowerList.remove(flower[i]);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sm=new Scanner(System.in);
		int choice;
		char ch='y';
		
		while(ch=='y' || ch=='Y') {
			System.out.print("\n1. Create List of Flowers\n2. Display Flower List\n3. Remove Flower where quantity <= 0\n\nEnter your choice : ");
			choice=sm.nextInt();
			switch(choice) {
				case 1 : read();
						break;
				case 2 : displayFlowers();
						
						break;
				case 3: 
				
					remove();
					
				break;
			}
			System.out.println("Do you want to continue?(y/n) ");
			ch=sm.next().trim().charAt(0);
		}
		
		sm.close();
	}

}
