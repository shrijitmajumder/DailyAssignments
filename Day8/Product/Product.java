package com.capgemini.product;

import java.util.Scanner;

public class Product {

	private int pId;
	private String name;
	private double price;
	
	Scanner sc = new Scanner(System.in);
	
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Product() {
		super();
	}
	public Product(int pId, String name, double price) {
		super();
		this.pId = pId;
		this.name = name;
		this.price = price;
	}
	
	Product[] prodList = new Product[3];
	
	public Product[] createProductList()
	{
		for(int i=0; i<prodList.length; i++)
		{
			System.out.println("Enter Details for Product "+(i+1)+":");
			prodList[i] = new Product();
			System.out.println("Enter Product ID:");
			prodList[i].setpId(sc.nextInt());
			System.out.println("Enter Product Name:");
			sc.nextLine();
			prodList[i].setName(sc.nextLine());
			System.out.println("Enter Product Price:");
			prodList[i].setPrice(sc.nextDouble());
		}
		return prodList;
	}
	
	public void updateProductById(Product[] prodList1, int prodId)
	{
		for(int i=0; i<prodList1.length; i++)
		{
			if(prodList1[i].getpId() == prodId)
			{
				System.out.println("ID Matched for Product " + (i+1));
				System.out.println("Enter new Product Name:");
				sc.nextLine();
				prodList1[i].setName(sc.nextLine());
				System.out.println("Enter new Product Price:");
				prodList1[i].setPrice(sc.nextDouble());
				System.out.println("Updated Product Details:");
				System.out.println("pId: " + pId + 
						", prodName:" + name +
						", prodPrice: " + price);
				System.out.println();
				return;
			}
		}
		System.out.println("Product not found for this ID!!!");
		System.out.println();
	}
	
	public Product[] deleteProductById(Product[] prod, int id) {
		int originalLength = prod.length;
		boolean found = false;
		for(int i=0; i<originalLength; i++) {
			if(prod[i].getpId() == id)
			{
				System.out.println("ID matched for Product: " + (i+1));
				prod[i] = null;
				System.out.println("Deleted");
				found = true;
				break;
			}
		}
		if(!found)
			System.out.println("Product not found for this id");
		System.out.println();
		return prod;
	}
	
	public void displayProdList(Product[] prod)
	{
		for(int i=0; i<prod.length; i++)
		{
			if(prod[i] != null)
				System.out.println("pId: " + prod[i].getpId() + 
						"|| prodName:" + prod[i].getName() +
						"|| prodPrice: " + prod[i].getPrice());
			System.out.println();
		}
	}
	
	public void displayProdDetailsById(Product[] prod, int id)
	{
		for(int i=0; i<prod.length; i++)
		{
			if(prod[i].getpId() == id)
			{
				if(prod[i] != null)
					System.out.println("pId: " + prod[i].getpId() + 
							"|| Product Name:" + prod[i].getName() +
							"|| Price: " + prod[i].getPrice());
				System.out.println();
				return;
			}
			System.out.println("Product not found");
			System.out.println();
		}
	}
}
