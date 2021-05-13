/* 10.  Write a Java program to check whether a number is a Harshad Number or not.
In recreational mathematics, a harshad number in a given number base, 
is an integer that is divisible by the sum of its digits when written in that base.
Example: Number 200 is a Harshad Number 
because the sum of digits 2 and 0 and 0 is 2(2+0+0) and 200 is divisible by 2. 
Number 171 is a Harshad Number because the sum of digits 1 and 7 and 1 is 9(1+7+1) 
and 171 is divisible by 9.
Expected Output

Input a number : 353  
                                                  
353 is not a Harshad Number. */

import java.util.*;
public class HarshadNumber {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in); // object creation of Scanner Class
		System.out.print("Input a number : ");
		int num = sc.nextInt(); // input for number
		int sum_of_digits=0;
		int temp=num; // temporary storage
		while(num>0) {
			sum_of_digits=sum_of_digits+num%10; // calculating sum of digits of num
			num=num/10;
		}
		if(temp%sum_of_digits==0) // checking if value in temporary storage is divisible by sum of digits of num
			System.out.println(temp+" is a Harshad Number.");
		else
			System.out.println(temp+" is not a Harshad Number.");
	}

}
