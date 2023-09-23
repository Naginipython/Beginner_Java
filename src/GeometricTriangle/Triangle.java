package GeometricTriangle;

/*
 * Name: Benjamin McCann
 * Date: 10/25/2020
 * Course Number: CSC-220
 * Course Name: Data Structures and Algorithms
 * Problem Number: Chapter 11 HW
 * Email: bnmccann0001@student.stcc.edu
 * Create an extention of Shape, Triangle
 */
public class Triangle extends Shape {
	private double side1;
	private double side2;
	private double side3;
	
	public Triangle() {
		this(1.0, 1.0, 1.0);
	}
	
	public Triangle(double side1, double side2, double side3) {
		this(side1, side2, side3, "white", false);
	}
	
	public Triangle(double side1, double side2, double side3, String color, boolean isFilled) {
		super(color, isFilled);
		if (side1 < 0 || side2 < 0 || side3 < 0)
			throw new RuntimeException("Side can't be negative");
		else if (side1+side2 < side3 || side1+side3 < side2 || side2+side3 < side1)
			throw new RuntimeException("Not a valid triangle");
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	//Getters
	public double getSide1() {
		return side1;
	}
	public double getSide2() {
		return side2;
	}
	public double getSide3() {
		return side3;
	}
	
	//setters
	public void setSide1(double side1) {
		if (side1 < 0)
			throw new RuntimeException("Side can't be negative");
		else if (side2+side3 < side1)
			throw new RuntimeException("Not a valid triangle");
		this.side1 = side1;
	}
	public void setSide2(double side2) {
		if (side2 < 0)
			throw new RuntimeException("Side can't be negative");
		else if (side1+side3 < side2)
			throw new RuntimeException("Not a valid triangle");
		this.side2 = side2;
	}
	public void setSide3(double side3) {
		if (side3 < 0)
			throw new RuntimeException("Side can't be negative");
		else if (side1+side2 < side3)
			throw new RuntimeException("Not a valid triangle");
		this.side3 = side3;
	}
	
	//Methods
	public double getArea() {
		double s = (this.side1 + this.side2 + this.side3)/2; 
		return Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
	}
	public double getPerimeter() {
		return side1 + side2 + side3;
	}
	public String toString() {
		return "Triangle: side1 = " + side1 + ",  side2 = " + side2 + ", side3 = " + side3 + "\n" + super.toString();
	}
}
