package hw2;/*
 * Name: Benjamin McCann
 * Date: 12/11/18
 * Course Number: CSC-111
 * Course Name: Java 1
 * Problem Number: 10
 * Email: bnmccann0001@student.stcc.edu
 * tbh didn't really know what the problem asked, the video already showed how to find the right array.
 */

import java.util.Scanner;

public class TwoDimentionalArray {

	// **********************************************

	private static void process(Scanner sc, String args[]) {
		System.out.print("How many rows and columns will there be?");
		int row = sc.nextInt();
		int column = sc.nextInt();
		int[][] matrix = new int[row][column];
		System.out.print("Would you like first random matrix(0), or a system found true matrix(1)?");
		int choice = sc.nextInt();
		sc.nextLine();
		
		int count = 0;
		if (choice != 1) {
			randomMatrix(matrix);
			printMatrix(matrix);
		} else {
			count = computerMatrixLoop(matrix, count);
			printMatrix(matrix);
		}

		if (hasEvenOnes(matrix)) {
			System.out.println("All rows and columns have even rows");
		} else {
			System.out.println("All rows and columns did not have even rows");
		}
		if (count > 0)
			System.out.println("Computer looped "+count+" times");
	}
	
	// **********************************************
	
	public static void printMatrix (int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	// **********************************************
	
	public static void randomMatrix (int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = (int) (Math.random() * 2);
			}
		}
	}

	// **********************************************
	
	public static int computerMatrixLoop (int[][] matrix, int count) {
		do {
			randomMatrix(matrix);
			count++;
		} while (!hasEvenOnes(matrix));
		return count;
	}
	
	// **********************************************

	public static boolean hasEvenOnes(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			int oneCount = 0;
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 1) {
					oneCount++;
				}
			}
			if (oneCount % 2 != 0) {
				return false;
			}
		}
		for (int j = 0; j < matrix.length; j++) {
			int oneCount = 0;
			for (int i = 0; i < matrix[j].length; i++) {
				if (matrix[i][j] == 1) {
					oneCount++;
				}
			}
			if (oneCount % 2 != 0) {
				return false;
			}
		}
		return true;
	}

	// **********************************************

	private static boolean doThisAgain(Scanner sc, String prompt) {
		System.out.print(prompt);
		String doOver = sc.nextLine();
		return doOver.equalsIgnoreCase("Y");
	}

	// **********************************************

	public static void main(String args[]) {
		final String TITLE = "CSC111 Project Template";
		final String CONTINUE_PROMPT = "Do this again? [y/N] ";

		System.out.println("Welcome to " + TITLE);
		Scanner sc = new Scanner(System.in);
		do {
			process(sc, args);
		} while (doThisAgain(sc, CONTINUE_PROMPT));
		sc.close();
		System.out.println("Thank you for using " + TITLE);
	}

}