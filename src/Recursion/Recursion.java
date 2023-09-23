package Recursion;/*
 * Name: Benjamin McCann
 * Date: 11/14/2020
 * Course Number: CSC-220
 * Course Name: Data Structures and Algorithms
 * Problem Number: Chapter 18 HW
 * Email: bnmccann0001@student.stcc.edu
 * Create 2 recursion programs based on stuff from codebat. Place them in a nice template to test easy
 */

import java.util.Scanner;

public class Recursion {
	private final static String TITLE = "CSC111 Project Template";
	private final static String CONTINUE_PROMPT = "Do this again? [y/N] ";
	
	//**********************************************
	// Put as many methods you need here
	public static int count8(int n) {
		if (n < 10) {
			if (n == 8) {
				return 1;
			} else {
				return 0;
			}
		} else {
			if (n%100 == 88) {
				return 2 + count8(n/10);
			} else if (n%10 == 8) {
				return 1 + count8(n/10);
			} else {
				return 0 + count8(n/10);
			}
		}
	}

	
	public static int countHi(String str) {
		if (str.length() < 2) {
		    return 0;
		} else {
		    if (str.charAt(str.length()-2) == 'h' && str.charAt(str.length()-1) == 'i') {
		    	return 1 + countHi(str.substring(0, str.length()-1));
		    } else {
		    	return 0 + countHi(str.substring(0, str.length()-1));
		    }
		}
	}

	
	//Taken from NameClassTesterApp
	private static String getFirstCharacter(String str) {
		str = str.trim().toUpperCase();
		return str.isEmpty() ? "" : str.substring(0, 1);
	}
	
	//**********************************************
	// Start your logic coding in the process method
	private static void process(Scanner sc, String args[]) {
		// Start Coding your problem in the process method
		System.out.print("Would you like to do [8] Count, or [H]i count: ");
		String strShape = getFirstCharacter(sc.nextLine());
		
		switch (strShape) {
			case "8":
				int number;
				do {
					System.out.print("Please enter a non-negative number: ");
					number = sc.nextInt();
				} while (number < 0);
				System.out.println("The sum of digit "+ number + " is: " + count8(number));
				break;
			case "H":
			case "h":
				String str = "";
				System.out.print("Enter a String that contains or doesn't contain 'hi': ");
				str = sc.next();
				System.out.println("The amount of the word 'hi' in the String " + str + " is: " + countHi(str));
		}
		sc.nextLine();  // Clear Keyboard
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