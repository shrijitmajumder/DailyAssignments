package com.capgemini.flower;

import java.util.Scanner;

public class Flower {
	
	private int fid;
	private String fname;
	private double pricePerKg;
	private float qty;
	
	Scanner sc=new Scanner(System.in);
	
	public Flower() {
		super();
	}

	public Flower(int fid, String fname, double pricePerKg, float qty) {
		super();
		this.fid = fid;
		this.fname = fname;
		this.pricePerKg = pricePerKg;
		this.qty = qty;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public double getPricePerKg() {
		return pricePerKg;
	}

	public void setPricePerKg(double pricePerKg) {
		this.pricePerKg = pricePerKg;
	}

	public float getQty() {
		return qty;
	}

	public void setQty(float qty) {
		this.qty = qty;
	}
	
	public void getDetails() {
		System.out.print("Enter flower id : ");
		fid=sc.nextInt();
		System.out.print("Enter flower name : ");
		sc.nextLine();
		fname=sc.nextLine();
		System.out.print("Enter price per kg : ");
		pricePerKg=sc.nextDouble();
		System.out.print("Enter quantity : ");
		qty=sc.nextFloat();
	}

	
	public String toString(int i) {
		return "Flower "+i+"[flower id=" + fid + ", flower name=" + fname + ", price Per Kg=" + pricePerKg + ", quantity=" + qty + "]";
	}
	
	
}
