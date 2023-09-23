package hw2;/*
 * Benjamin McCann	
 * 11/13/18
 * CSC-111
 * Problem 7
 * Sin calculator
 * bnmccann0001@student.stcc.edu
 */
import java.util.Scanner;

public class SinCalc {

	public static void main(String[] args) {
		//I made this from scartch :)
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the sin(x) Calculator!");
		String loop = "Y";
		do {
			System.out.print("Type a number for x in degrees and how many times to go through: ");
			
			double x = RadiansCalc(input.nextDouble()); //auto makes it radians
			int numTimes = input.nextInt(); // how much closer it'll get
			
			// THE SIN
			double sin = MySinCalc(x, numTimes);

			System.out.printf("The sin of %.9f Radians is %.9f\n", x, sin);
			System.out.print("Another[Y/N]? "); //looper :)
			loop = input.next();
		} while (!loop.equalsIgnoreCase("N"));
		System.out.print("Bye Friend :)");
		
		input.close();
	}

	private static double RadiansCalc(double x) {
		return (x * Math.PI) / 180; // easy math
	}

	private static double MySinCalc(double x, int numTimes) {
		// numerator and denominator in sin function
		double power = 0;
		double factorial = 0;
		double sin = 0;
		boolean changeSign = false; // helps change the sign

		for (int i = 1; i <= numTimes * 2; i += 2) {
			power = PowerCalc(x, i);
			factorial = FactorialCalc(x, i);

			changeSign = !changeSign; //change the + and -
			if (changeSign)
				sin += (power / factorial);
			else
				sin -= (power / factorial);
		}

		return sin;
	}

	private static double PowerCalc(double x, int numTimes) {
		double result = 1;
		for (int i = 0; i < numTimes; i++)
			result *= x;
		return result;
	}

	private static double FactorialCalc(double x, int numTimes) {
		double result = 1;
		for (int i = 1; i <= numTimes; i++)
			result *= i;
		return result;
	}
}
