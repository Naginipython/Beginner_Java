package GeometricTriangle;/*
 * Name: Benjamin McCann
 * Date: 10/25/2020
 * Course Number: CSC-220
 * Course Name: Data Structures and Algorithms
 * Problem Number: Chapter 11 HW
 * Email: bnmccann0001@student.stcc.edu
 * Create an extention of Shape, Triangle
 */
import java.util.*;

abstract public class Shape {
	private String color;
	private boolean filled;
	private Date dateCreated;

	/** Construct a default geometric object */
	public Shape() {
		this("white", false);
	}

	/**
	 * Construct a geometric object with the specified color and filled value
	 */
	public Shape(String color, boolean filled) {
		this.dateCreated = new Date();
		this.color = color;
		this.filled = filled;
	}

	/** Return color */
	public String getColor() {
		return color;
	}

	/** Set a new color */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Return filled. Since filled is boolean, its get method is named isFilled
	 */
	public boolean isFilled() {
		return filled;
	}

	/** Set a new filled */
	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	/** Get dateCreated */
	public Date getDateCreated() {
		return dateCreated;
	}

	/** Return a string representation of this object */
	public String toString() {
		return "Shape: created on " + dateCreated + "\ncolor: " + color
				+ " and filled: " + filled;
	}
	
	abstract public double getArea();

	abstract public double getPerimeter(); 	
	
}