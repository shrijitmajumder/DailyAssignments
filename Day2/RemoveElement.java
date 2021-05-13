// write a Java program to remove an element by taking an index from the user

import java.util.Scanner;

public class RemoveElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in); // object creation of Scanner class
		System.out.print("Enter the size of the array : ");
		int size=sc.nextInt(); // input size for first array
		int array[]=new int[size];
		for(int i=0;i<size;i++) {
			System.out.print("Enter Element "+(i+1)+" : "); // input elements of array
			array[i]=sc.nextInt();
		}
		System.out.print("Enter the index to be deleted : ");
		int index = sc.nextInt();
		if(index==1) {
			System.out.println("The array after deleting element at index 1 : ");
			for(int i=1;i<size;i++) {
				System.out.print(array[i] +" ");
			}
		}else if(index==size-1)
		{
			System.out.println("The array after deleting element at index "+index+" : ");
			for(int i=0;i<size-1;i++) {
				System.out.print(array[i] +" ");
			}
		}
		else {
			System.out.println("The array after deleting element at index "+index+" : ");
			int last=array[size-1];
			for(int i=index-1;i<size-1;i++) {
				array[i]=array[i+1];
			}
			array[size-1]=last;
			for(int i=0;i<size-1;i++) {
				System.out.print(array[i] +" ");
			}
		}
		sc.close();
	}

}
