package com.capgemini.product;

import java.util.Scanner;

public class ProductMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		char ch = 'y';
		
		Product prod = new Product();
		Product[] prodList = new Product[3];
		
		while(ch == 'y')
		{
			System.out.println("1) Create Product List\n"
					+ "2) Update Product By ID\n"
					+ "3) Delete Product By ID\n"
					+ "4) Display All Details\n"
					+ "5) Display Product Details By ID\n");
			System.out.println("******************************");
			System.out.print("Enter your choice : ");
			int choice = sc.nextInt();
			
			switch(choice)
			{
			case 1:prodList = prod.createProductList();
				break;
			case 2:System.out.println("Enter Product ID:");
				int id = sc.nextInt();
				prod.updateProductById(prodList, id);
				System.out.println();
				break;
			case 3:System.out.println("Enter Product ID:");
				int delId = sc.nextInt();
				prod.deleteProductById(prodList, delId);
				System.out.println();
				break;
			case 4:prod.displayProdList(prodList);
				System.out.println();
				break;
			case 5:System.out.println("Enter Product ID:");
				int dispId = sc.nextInt();
				prod.displayProdDetailsById(prodList, dispId);
				System.out.println();
				break;
			default:System.out.println("Wrong Choice");
				System.out.println();
			}
			
			System.out.println("Do you wish to Continue?(y/n):");
			ch = sc.next().charAt(0);
			System.out.println();
		}
		
		System.out.println("--------------Thank You-----------------");
		
		sc.close();
	}

}
