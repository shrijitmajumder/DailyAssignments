/* Write a program to print array elements in the reverse order using swapping method?
Hint: take even number array
input: 20 30 40 50 60 70
output: 70 60 50 40 30 20 */

import java.util.Scanner;
public class ReverseArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in); // object creation of Scanner class
		System.out.print("Enter the size of the array : ");
		int size=sc.nextInt(); // input size for first array
		int array[]=new int[size];
		int temp[]=new int[size];
		int oddsum=0,evensum=0;
		for(int i=0;i<size;i++) {
			System.out.print("Enter Element "+(i+1)+" : "); // input elements of array
			array[i]=sc.nextInt();
			temp[i]=array[i];
		}
		for(int i=0;i<size;i++) {
			array[i]=temp[size-i-1]; // swapping the elements of the array
		}
		System.out.println("The array after reversing :");
		for(int i=0;i<size;i++) {
			System.out.print(array[i]+" ");
		}
		
		sc.close();
	}

}
