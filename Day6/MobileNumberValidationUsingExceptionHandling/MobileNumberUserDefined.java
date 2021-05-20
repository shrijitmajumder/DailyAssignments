package com.capgemini.userdefinedexceptionexample;

import java.util.Scanner;
import java.util.regex.Pattern;

public class MobileNumberUserDefined {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter mobile number");
		String mobNo=sc.next();
		String regex="[789]{1}[0-9]{9}";
		boolean result=Pattern.matches(regex, mobNo);//using character classes and quantifiers
		try {
			if(result==true)
				throw new MobileNumberException("Valid Mobile Number");
			else if(mobNo.length()<10)
				throw new MobileNumberException("It is less than 10 digits");
			else if(mobNo.length()>10)
				throw new MobileNumberException("It is more than 10 digits");
			else
				throw new MobileNumberException("It is contains characters apart from digits");
		}catch(MobileNumberException e) {
			System.out.println(e.getMessage());
		}
	}

}
