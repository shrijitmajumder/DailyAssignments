// Shape and Subclasses 

import java.util.Scanner;
public class ShapeMain {
	
	public static void CircleData() {
		Scanner sc=new Scanner(System.in);
		Circle c=new Circle();
		System.out.print("Enter the radius of the circle : ");
		c.radius=sc.nextDouble();
		System.out.println(c);
		System.out.printf("Area of the circle : %.2f square units\n",c.getArea());
		System.out.printf("Perimeter of the circle : %.2f units\n",c.getPerimeter());
		
		sc.close();
	}
	public static void RectangleData() {
		Scanner sc=new Scanner(System.in);
		Rectangle r = new Rectangle();
		System.out.print("Enter the length of the rectangle : ");
		r.length=sc.nextDouble();
		System.out.print("Enter the width of the rectangle : ");
		r.width=sc.nextDouble();
		
		System.out.println(r);
		System.out.printf("Area of the rectangle : %.2f square units\n",r.getArea());
		System.out.printf("Perimeter of the rectangle : %.2f units\n",r.getPerimeter());
		
		sc.close();
	}
	
	public static void SquareData() {
		Scanner sc=new Scanner(System.in);
		Square s=new Square();
		
		System.out.print("Enter the side of the square : ");
		s.length=sc.nextDouble();
		
		System.out.println(s);
		System.out.printf("Area of the square : %.2f square units\n",s.getArea());
		System.out.printf("Perimeter of the square : %.2f units\n",s.getPerimeter());
		
		sc.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int choice;
		System.out.print("\n1.Compute for Circle\n2.Compute for Rectangle\n3.Compute for Square\nEnter your choice : ");
		choice = sc.nextInt();
		switch(choice) {
		case 1: CircleData();
				break;
		case 2: RectangleData();
				break;
		case 3: SquareData();
				break;
		default : System.out.println("Enter correct choice (1-3)...");
		}
		
		sc.close();
	}

}
