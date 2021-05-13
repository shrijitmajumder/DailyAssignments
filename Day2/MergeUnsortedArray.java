// Write a Java program to merge two unsorted arrays of different lengths

import java.util.Scanner;
public class MergeUnsortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in); // object creation of Scanner class
		System.out.print("Enter the size of first array : ");
		int size1=sc.nextInt(); // input size for first array
		int array1[]=new int[size1];
		for(int i=0;i<size1;i++) {
			System.out.print("Enter Element "+(i+1)+" : "); // input elements of array1
			array1[i]=sc.nextInt();
		}
		System.out.print("Enter the size of second array : ");
		int size2=sc.nextInt(); // input size for second array
		int array2[]=new int[size2];
		for(int i=0;i<size2;i++) {
			System.out.print("Enter Element "+(i+1)+" : "); // input elements of array2
			array2[i]=sc.nextInt();
		}
		System.out.print("The array elements after merging the two arrays :\n");
		
		// displaying after merging
		for(int i=0;i<size1;i++) {
			System.out.print(array1[i] +" ");
		}
		for(int i=0;i<size2;i++) {
			System.out.print(array2[i] +" ");
		}
		
		sc.close();
	}

}
