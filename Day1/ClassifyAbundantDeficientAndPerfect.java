/* 4.Write a Java program to classify Abundant, deficient and perfect number (integers) between 1 to 10,000.
Hint : The integer 12 is the first abundant number. Its proper divisors are 1, 2, 3, 4 and 6 for a total of 16.
       divisors of 21 are 1, 3 and 7, and their sum is 11. Because 11 is less than 21, the number 21 is deficient. Its deficiency is 2 × 21 − 32 = 10. */

import java.util.*;
public class ClassifyAbundantDeficientAndPerfect {
	public static String classify(int num) {
	int newnum=0; 
		for(int i=1;i<num;i++) {
			if(num%i==0) // checking for proper divisors of num
				newnum=newnum+i; // generating sum of proper divisors of num
		}
		if(newnum==num) // if num equals newnum then it's a perfect number
			return (num+" is a perfect number.");
		else if(newnum>num) // if newnum exceeds num then it's an abundant number
			return(num+" is an abundant number.");
		else
			return(num+" is a deficient number.");
	}
	public static void main(String[] args) {
		for(int i=1;i<=10000;i++)
		{
			System.out.println(classify(i));
		}
	}

}
