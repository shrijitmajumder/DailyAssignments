
public class Square extends Rectangle{
	
	public double getSide() {
		return length;
	}
	public void setSide(double length) {
		this.length = length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public void setWidth(double length) {
		this.length = length;
	}
	@Override
	public double getArea() {
		return length*length;
	}
	@Override
	public double getPerimeter() {
		return 4*length;
	}
	@Override
	public String toString() {
		Rectangle r=new Rectangle();
		
		return "Square["+r+"]";
	}
}
