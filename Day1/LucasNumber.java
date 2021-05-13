/* 7.Write a Java program to display first 10 lucus numbers.
The Lucas numbers or series are an integer sequence named after 
the mathematician François Édouard Anatole Lucas, 
who studied both that sequence and the closely related Fibonacci numbers. 
Lucas numbers and Fibonacci numbers form complementary instances of Lucas sequences.
The sequence of Lucas numbers is: 2, 1, 3, 4, 7, 11, 18, 29, ….
Expected Output :

   First ten Lucas a numbers:                                              
2                                                                       
1                                                                       
3                                                                       
4                                                                       
7                                                                       
11                                                                      
18                                                                      
29                                                                      
47                                                                      
76 */

import java.util.*;
public class LucasNumber {
	
	// function to return Lucas series
	public static int Lucas(int n)
	{
		if(n==1)
			return 2;
		else if(n==2)
			return 1;
		return Lucas(n-1)+Lucas(n-2);
	}
	public static void main(String[] args) {
		System.out.println("First ten Lucas numbers are:");
		for(int i=1;i<=10;i++) {
			System.out.println(Lucas(i));
		}
		
	}

}
