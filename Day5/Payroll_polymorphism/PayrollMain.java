
import java.util.Scanner;

public class PayrollMain {
	
    public static void adminPanel() {
        Scanner sc = new Scanner(System.in);
        Admin a = new Admin();

        System.out.print("Enter the name: ");
        String name = sc.nextLine();
        System.out.print("Enter salary: ");
        int sal = sc.nextInt();

        a.adjustSalary(sal);
        a.doAdminStuff();
    }

    public static void academicPanel() {
        Scanner sc = new Scanner(System.in);
        Academic a = new Academic();

        System.out.print("Enter the name: ");
        String name = sc.nextLine();
        System.out.print("Enter salary: ");
        int sal = sc.nextInt();

        a.adjustSalary(sal);
        a.giveLecture();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Admin\n2. Academic\nEnter your choice : ");
        int choice = sc.nextInt();
        switch(choice) {
        case 1 :adminPanel();
        		break;
        case 2: academicPanel();
        		break;
        default : System.out.println("Wrong choice man!");
        }
    }
}