package com.capgemini.shopping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Shopping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sm=new Scanner(System.in);
		System.out.print("Enter the number of items for shopping : ");
		int num=sm.nextInt();
		HashMap<Integer,String> shopping_list = new HashMap<Integer,String>();
		
		for(int i=0;i<num;i++) {
			System.out.print("Enter the id of Item "+(i+1)+" : ");
			int id=sm.nextInt();
			System.out.print("Enter the name of Item "+(i+1)+" : ");
			sm.nextLine();
			String nameofitem=sm.next();
			shopping_list.put(id, nameofitem);
		}
		
		System.out.println("\nShopping List after adding elements : \n");
		int k=1;
		for(Map.Entry<Integer, String> s : shopping_list.entrySet()) {
			System.out.printf("Key %d : %d, Value %d : %s\n",k,s.getKey(),k,s.getValue());
			k++;
		}
		
		
		ArrayList<Integer> keys = new ArrayList<Integer>();
		for(Map.Entry<Integer,String> m : shopping_list.entrySet()) {
			keys.add(m.getKey());
		}
		
		int temp=0;
		do {
			System.out.print("\nEnter the Key you want to replace : ");
			int id = sm.nextInt();
			for(int i=0;i<keys.size();i++) {
				if(id==keys.get(i)) {
					temp=1;
					break;
				}
			}
			if(temp==0) {
				System.out.println("Sorry id "+id+" not found...");
			}
			else {
				System.out.print("\nEnter the value you want to replace with : ");
				String value = sm.next();
				shopping_list.replace(id, value);
				System.out.println("\nShopping List after replacing : \n");
				k=1;
				for(Map.Entry<Integer, String> s : shopping_list.entrySet()) {
					System.out.printf("Key %d : %d, Value %d : %s\n",k,s.getKey(),k,s.getValue());
					k++;
				}
			}
		}while(temp!=1);
		
		Map<Integer,String> treeList = new TreeMap<Integer,String>();
		treeList.putAll(shopping_list);
		System.out.println("\nAfter sorting the List is given below :\n");
		k=1;
		for(Map.Entry<Integer, String> t : treeList.entrySet()) {
			System.out.printf("Key %d : %d, Value %d : %s\n",k,t.getKey(),k,t.getValue());
			k++;
		}
		sm.close();
	}

}
