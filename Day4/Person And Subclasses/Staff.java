import java.util.Scanner;

public class Staff extends Person{
	
	String school;
	double pay;
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public double getPay() {
		return pay;
	}
	public void setPay(double pay) {
		this.pay = pay;
	}
	
	@Override
	public String toString() {
		Person p=new Person();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the name :");
		p.name=sc.next();
		sc.nextLine();
		System.out.print("Enter the address :");
		p.address=sc.nextLine();
		
		sc.close();
		return "Staff["+p+",school="+this.school+",pay="+this.pay+"]";
	}

}
