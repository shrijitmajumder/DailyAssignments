/* 9. 11. Write a Java program to check 
whether a given number is a Disarium number or unhappy number.
A Disarium number is a number defined by the following process :
Sum of its digits powered with their respective position is equal to the original number.
For example 175 is a Disarium number :
As 11+32+53 = 135
Some other DISARIUM are 89, 175, 518 etc.
A number will be called Disarium if the sum of its digits powered with their respective position 
is equal with the number itself. 
Sample Input: 135.
Expected Output

Input a number : 25                                                     
Not a Disarium Number. */
import java.util.*;
public class DisariumNumber {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in); // object creation of Scanner Class
		System.out.print("Input a number : ");
		int num = sc.nextInt(); // input for number
		String number = ""+num; // storing the number in String format
		int sum=0; // for storing sum of digits to the power of their respective position
		int length_num=number.length();
		int temp=num; // temporary storage
		while(num>0) {
			sum=sum+(int)Math.pow(num%10,length_num--);
			num=num/10;
		}
		if(sum==temp) // check if sum equals value in temporary storage
			System.out.println("Disarium Number.");
		else
			System.out.println("Not a Disarium Number.");

	}

}
