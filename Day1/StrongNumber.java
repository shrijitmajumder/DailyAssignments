/* 1.Write a Java Program to find where given number is strong number or not?
hint: 145 = 1! + 4! + 5! = 145 */

import java.util.*;

public class StrongNumber {
	
	// function to return factorial of a number
	public static int Factorial(int n) {
		if(n==0)
			return 1;
		return n*Factorial(n-1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // object creation of Scanner Class
		System.out.print("Enter a number : ");
		int num = sc.nextInt(); // input for number
		int newnum=0;
		int temp=num; // temporary storage
		while (num>0) {
			newnum=newnum+Factorial(num%10); // producing new number using factorial of digits
			num=num/10;
		}
		if(temp==newnum) // checking if value in temporary storage equals new number
			System.out.println(temp+" is a Strong Number.");
		else
			System.out.println(temp+" is not a Strong Number.");
	}

}
