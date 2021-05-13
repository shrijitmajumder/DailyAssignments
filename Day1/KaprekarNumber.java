/* 5.Write a Java program to generate and show all Kaprekar numbers less than 1000. 
Expected Output :

1       1         0 + 1                                  
9       81        8 + 1                                  
45      2025      20 + 25                                
55      3025      30 + 25                                
99      9801      98 + 01                                
297     88209     88 + 209                               
703     494209    494 + 209                              
999     998001    998 + 001                              
8 Kaprekar numbers */

import java.util.*;
public class KaprekarNumber {
	
	// function to count digits of a number
	public static int countdigits(int n)
	{
		int counter=0;
		if(n==1)
			return 1;
		while(n>0)
		{
			counter++;
			n=n/10;
		}
		return counter;
	}
	
    public static String formatKaprekar(int n)
    {
        if (n == 1)
            return "0 + 1";

       // count number of digits in square
        int sq_n = n * n;
        int count_digits = 0;
        while (sq_n != 0)
        {
            count_digits++;
            sq_n /= 10;
        }
        sq_n = n*n; // Recompute square as it was changed
      	// Split the square at different poitns and see if sum
        // of any pair of splitted numbers is equal to n.
        String w="";
        for (int i=1; i<count_digits; i++)
        {
             int eq_parts = (int) Math.pow(10,i);
             w="";
      
             // to avoid numbers which are not Kaprekar
             if (eq_parts == n)
                continue;
      
             // find sum of current parts and compare with n
             int sum = sq_n/eq_parts + sq_n % eq_parts;
             if (sum == n) {
            	 if(countdigits(n*n) % 2 == 0 && (sq_n % eq_parts>=1 && sq_n % eq_parts<=9)) {
            		 return sq_n/eq_parts +" + " + "0".repeat(countdigits(n*n)/2 - 1)+sq_n%eq_parts;
            	 }
               return sq_n/eq_parts +" + "+ sq_n % eq_parts;
             }
        }
      
        // compare with original number
        return "0";
    }
    
    // returns true if n is a Kaprekar number, else false
    public static boolean fnIsKaprekar(int n)
    {
        if (n == 1)
           return true;
       // count number of digits in square
        int sq_n = n * n;
        int count_digits = 0;
        while (sq_n != 0)
        {
            count_digits++;
            sq_n /= 10;
        }
        sq_n = n*n; // Recompute square as it was changed
      	// Split the square at different poitns and see if sum
        // of any pair of splitted numbers is equal to n.
        for (int i=1; i<count_digits; i++)
        {
             int eq_parts = (int) Math.pow(10,i);
      
             // To avoid numbers like 10, 100, 1000 (These are not Karprekar numbers)
             if (eq_parts == n)
                continue;
      
             // find sum of current parts and compare with n
             int sum = sq_n/eq_parts + sq_n % eq_parts;
             if (sum == n)
               return true;
        }
      
        // compare with original number
        return false;
    }
	public static void main(String[] args) {
		int count=0;
		for(int i=1;i<1000;i++)
		{
			if(fnIsKaprekar(i)) {
			System.out.println(i+"\t"+(i*i)+"\t"+formatKaprekar(i));
			count++;
			}
		}
		System.out.println(count + " Kaprekar numbers");
	}
}
