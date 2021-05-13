/*Write a Java Program to find sum of numbers 
* a) even index
 b) odd index */


import java.util.Scanner;
public class SumOfOdd_Even_Index {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in); // object creation of Scanner class
		System.out.print("Enter the size of the array : ");
		int size=sc.nextInt(); // input size for first array
		int array[]=new int[size];
		int oddsum=0,evensum=0;
		for(int i=0;i<size;i++) {
			System.out.print("Enter Element "+(i+1)+" : "); // input elements of array
			array[i]=sc.nextInt();
		}
		for(int i=0;i<size;i++) {
			if((i+1)%2==0) // determining whether index is odd or even
				evensum+=array[i];
			else
				oddsum+=array[i];
		}
		System.out.println("Sum of elements of even index = "+evensum);
		System.out.println("Sum of elements of odd index = "+oddsum);
		
		sc.close();
	}

}
