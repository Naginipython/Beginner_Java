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
public class Rectangle extends Shape {
  private double length;
  private double width;

  public Rectangle() {
  }

  public Rectangle(double width, double height) {
    this(width, height, "white", false);
  }

  public Rectangle(double width, double height, String color, boolean filled) {
	super(color, filled);
    this.width = width;
    this.length = height;
  }

  /** Return width */
  public double getWidth() {
    return width;
  }

  /** Set a new width */
  public void setWidth(double width) {
    this.width = width;
  }

  /** Return height */
  public double getLength() {
    return length;
  }

  /** Set a new height */
  public void setHeight(double height) {
    this.length = height;
  }

  /** Return area */
  public double getArea() {
    return this.width * this.length;
  }

  /** Return perimeter */
  public double getPerimeter() {
    return 2 * (width + length);
  }
  
  public String toString() {
	  return "Rectangle: " + this.length + " x " + this.width + "\n" +
             super.toString();
  }
}