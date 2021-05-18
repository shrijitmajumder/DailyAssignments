import java.util.Scanner;

public class Circle extends Shape{
	

	double radius;

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getArea() {
		return Math.PI*radius*radius;
	}
	
	public double getPerimeter() {
		return 2*Math.PI*radius;
	}

	@Override
	public String toString() {
		Shape s=new Shape();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the color with which you want to fill : ");
		s.color=sc.next();
		if(s.color!=null)
			s.filled=true;
		
		sc.close();
		return "Circle["+s+",radius="+this.radius+"]";
	}

}
