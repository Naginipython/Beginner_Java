package PalindromicPrimeNumbers;/*
 * Name: Benjamin McCann
 * Date: 9/15/2020
 * Course Number: CSC-220
 * Course Name: Data Structures and Algorithms
 * Problem Number: HW1
 * Email: bnmccann0001@student.stcc.edu
 * Prompt for a range of integers, the starting and ending points, and calculate the sum of all the palindromic primes found in this range.  
 * The range points are inclusive.
   A palindromic number is one whose digits when reversed form the same value.  i.e 919 and 2332 is palindromic.
   Make sure you define and use as many methods as possible.
 */

import java.util.Scanner;

public class PalindromicPrimeNumbers {
	private final static String TITLE = "Palindromic and Prime Number Locator V1.1";
	private final static String CONTINUE_PROMPT = "Do this again? [y/N] ";
	
	//**********************************************
	// Put as many methods you need here
	private static long reverse(long n) {
		int x = 0;
		while (n > 0) {
			int lsd = (int) (n % 10);
			x = 10 * x + lsd;
			n = n / 10;
		}
		return x;
	}
	
	private static boolean isPrime(long x) {
		for (int div = 2; div <= x/2; div++) {
			if (x % div == 0) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean isPalindromic(long x) {
		if (x == reverse(x)) {
			return true;
		} else {
			return false;
		}
	}
	
	//**********************************************
	// Start your logic coding in the process method
	private static void process(Scanner sc, String args[]) {
		//Asking for info
		long num1;
		long num2;
		System.out.println("");
		System.out.print("Enter the start of range: ");
		num1 = sc.nextInt();
		System.out.print("Enter the end of range: ");
		num2 = sc.nextInt();
		System.out.println("Processing " + num1 + " and " + num2 + "...");
		sc.nextLine();  // Clear Keyboard
		
		//checking if info entered correctly
		if (num1 > num2) {
			System.out.println("Error: End of range is lower than the start");
		} else {
			//Looping to find prime number and Palindromic Numbers
			long count = num1;
			long sum = 0;
			
			while (count <= num2) {
				if (isPrime(count) && isPalindromic(count)) {
					sum += count;
//					System.out.println(count);
				}
				count++;
			}
			System.out.println("The sum of the Palindromic Primes numbers between "+num1+" and "+num2+" is "+sum);
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