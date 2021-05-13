/* 2.Write a Java Program to find where given number has duplicated digits or not?
	print the duplicate number?
hint: 144 = 4 is duplicated */

import java.util.*;
public class DuplicateDigit {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in); // object creation of Scanner Class
		System.out.print("Enter a number : ");
		int num = sc.nextInt(); // input for number
		int temp=0; // flag variable for true or false
		while(num>0) {
			int k=num%10; // extracting last digit of the number
			num=num/10; // reducing each digit of the number
			while(num>0) {
				int d = num%10; // extracting last digit of the obtained number
				if(d==k) {
					System.out.println(d+" is duplicated");
					temp=1;
					break;
				}
				num=num/10;
			}
		}
		if(temp==0) {
			System.out.println("No digit is duplicated");
		}
	}

}
