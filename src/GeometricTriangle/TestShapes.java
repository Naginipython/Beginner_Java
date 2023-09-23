package GeometricTriangle;/*
 * Name: Benjamin McCann
 * Date: 10/25/2020
 * Course Number: CSC-220
 * Course Name: Data Structures and Algorithms
 * Problem Number: Chapter 11 HW
 * Email: bnmccann0001@student.stcc.edu
 * Create an extention of Shape, Triangle
 */
import java.util.Scanner;

public class TestShapes {
	private final static String TITLE = "Test Shapes V1.0";
	private final static String CONTINUE_PROMPT = "Do this again? [y/N] ";
	
	//**********************************************
	// Put as many methods you need here
	
	private static String getFirstCharacter(String str) {
		str = str.trim().toUpperCase();
		return str.isEmpty() ? "" : str.substring(0, 1);
	}
	
	
	//**********************************************
	
	private static void process(Scanner sc, String args[]) {
		System.out.print("Enter Shape to create [C]ircle, [R]ectangle, [T]riangle: ");
		String strShape = getFirstCharacter(sc.nextLine());
		Shape shape = null;
		switch (strShape) {
		case "C": {
			System.out.print("Enter radius: ");
			double radius = sc.nextDouble();
			System.out.print("Enter color: ");
			String color = sc.next();
			System.out.print("Enter is filled: ");
			boolean isFilled = sc.nextBoolean();
			sc.nextLine();
			shape = new Circle(radius, color, isFilled);
			break;
			}
		case "R": {
			System.out.print("Enter length & width: ");
			double length = sc.nextDouble();
			double width = sc.nextDouble();
			System.out.print("Enter color: ");
			String color = sc.next();
			System.out.print("Enter is filled: ");
			boolean isFilled = sc.nextBoolean();
			sc.nextLine();
			shape = new Rectangle(length, width, color, isFilled);
			break;
			}
		case "T": {
			System.out.print("Enter side1, side2, and side3: ");
			double side1 = sc.nextDouble();
			double side2 = sc.nextDouble();
			double side3 = sc.nextDouble();
			System.out.print("Enter color: ");
			String color = sc.next();
			System.out.print("Enter is filled: ");
			boolean isFilled = sc.nextBoolean();
			sc.nextLine();
			shape = new Triangle(side1, side2, side3, color, isFilled);
			break;
			}
		default:
			System.out.println("Bad Shape Specified.");
			break;
		}
		if (shape != null) {
			System.out.println(shape);
			System.out.printf("Perimeter = %.2f\n", shape.getPerimeter());
			System.out.printf("Area = %.2f\n", shape.getArea());
		}
	}

	//**********************************************
	// Do not change the doThisAgain method
	private static boolean doThisAgain(Scanner sc, String prompt) {
		System.out.print(prompt); 
		String doOver = sc.nextLine();
		return doOver.trim().equalsIgnoreCase("Y");
	}
	
	//**********************************************
	// Do not change the main method
	public static void main(String args[]) {
		System.out.println("Welcome to " + TITLE);
		Scanner sc = new Scanner(System.in);
		do {
			process(sc, args);
		} while (doThisAgain(sc, CONTINUE_PROMPT));
		sc.close();
		System.out.println("Thank you for using " + TITLE);
	}

}