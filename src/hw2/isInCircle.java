package hw2;/*
 * Benjamin McCann	
 * 10/15/18
 * CSC-111
 * Problem 4
 * Point in a Circle
 * bnmccann0001@student.stcc.edu
 */
import java.util.Scanner;

public class isInCircle {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Let�s find out if a point is in a circle on the first quadrant!");
		System.out.print("Enter a positive number for Radius: ");
		double radius = input.nextDouble();
		if (radius > 0) { // We gotta have a real radius
			System.out.print("Enter two numbers for x and y: ");
			double x = input.nextDouble();
			double y = input.nextDouble();
			if (x >= 0 && y >= 0) {
				double d = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
				if (d <= radius) {
					System.out.printf("A circle with a radius of %f includes the point of (%f, %f)", radius, x, y);
				} else {
					System.out.printf("A circle with a radius of %f does not includes the point of (%f, %f)", radius, x,
							y);
				}
			} else { //if the points aren't positive, it aint in the first quadrant, thus not worth our time
				System.out.println("Point is not in first quadrant!");
			}
		} else { //when it isnt a real radius, why task the computer with more work?
			System.out.println("Radius does not exist! Enter number > 0");
		}
		input.close();

	}

}
