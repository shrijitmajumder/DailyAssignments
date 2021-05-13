/* Write  a Java Program to count number of duplicated values in
a) integer array */

import java.util.Scanner;
public class IntegerDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in); // object creation of Scanner class
		System.out.print("Enter the size of the array : ");
		int size=sc.nextInt(); // input size for first array
		int array[]=new int[size];
		int i,j;
		for(i=0;i<size;i++) {
			System.out.print("Enter Element "+(i+1)+" : "); // input elements of array
			array[i]=sc.nextInt();
		}
		
		int count = 0; // counter for counting number of duplicate integers
		i=0;
		while(i < size) 
		{
			j = i + 1;
			while(j < size && i != j)
			{		
				if(array[i] == array[j]) {
					count++; // counting number of duplicates
					break;
				}
				j++;
			}
			i++;
		}
		
		System.out.println("Total number of duplicate values in integer array is "+count);

	}

}
