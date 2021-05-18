// Person and Subclasses

import java.util.Scanner;

public class PersonMain {

	 public static void studentDetails() {
	        Scanner sc = new Scanner(System.in);
	        Student student = new Student();
	        System.out.print("Enter the year : ");
	        student.year = sc.nextInt();
	        System.out.print("Enter the program : ");
	        student.program = sc.next();
	        System.out.print("Enter the fee : ");
	        student.fee = sc.nextDouble();
	        System.out.println("\n"+student);
	        
	        sc.close();

	    }

	    public static void staffDetails() {
	        Scanner sc = new Scanner(System.in);
	        Staff staff = new Staff();
	        System.out.print("Enter the school : ");
	        staff.school = sc.nextLine();
	        System.out.print("Enter the pay : ");
	        staff.pay = sc.nextDouble();
	        System.out.println("\n"+staff);
	        
	        sc.close();

	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("\n1. Student details\n2. Staff details\nEnter your choice : ");
	        int choice = sc.nextInt();
	        switch(choice) {
	        case 1:studentDetails();
	        		break;
	        case 2:staffDetails();
	        		break;
	        default: System.out.println("Enter correct choice(1-2)...");
	        }
	        sc.close();
	    }

}
