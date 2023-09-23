package hw2;/*
 * Name: Benjamin McCann
 * Date: 12/2/18
 * Course Number: CSC-111
 * Course Name: Java 1
 * Problem Number: 9
 * Email: bnmccann0001@student.stcc.edu
 * Find random 5 numbers in an array of 43, in ascending order, and print them. Then find one unrelated lucky ball number
 */

import java.util.Scanner;

public class LotteryNumberGenerator {
	
	
	//**********************************************
	
	private static void process(Scanner sc, String args[]) {
		// Code here is merely a sample
		int[] numbers = fortyThree();
		numbers = shuffleNum(numbers);
		int[] winNums = {numbers[0], numbers[1], numbers[2], numbers[3], numbers[4]};
		winNums = organizeNum(winNums);
		System.out.print("Your Lucky For Life Cash numbers are: ");
		printNum(winNums);
		System.out.print("Your Lucky Ball Number is: ");
		int random = (int) (Math.random()*43);
		System.out.print(numbers[random]+"\n");
	}
	
	//**********************************************
	
	private static int[] fortyThree() {
		int[] numbers = new int[43];
		for (int i=1; i <= 43; i++)
			numbers[i-1] = i;
		return numbers;
	}
	
	//**********************************************
	
	private static int[] shuffleNum(int[] num) {
		int index = 0;
		int temp = 0;
		for (int i=0; i<num.length;i++) {
			index = (int) (Math.random()*43);
			temp = num[i];
			num[i] = num[index];
			num[index] = temp;
		}
		return num;
	}
	
	//**********************************************
	
	private static int[] organizeNum(int[] num) {
		int prev = 0;
		for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                if (num[i] > num[j]) {
                    prev = num[i];
                    num[i] = num[j];
                    num[j] = prev;
                }
            }
		}
		return num;
	}
	
	//**********************************************
	
	private static void printNum(int[] num) {
		for (int i=0;i<num.length;i++) {
			if (i > 0)
				System.out.print(", ");
			System.out.print(num[i]);
		}
		System.out.print("\n");
	}
	
	//**********************************************
	
	private static boolean doThisAgain(Scanner sc, String prompt) {
		System.out.print(prompt);
		String doOver = sc.nextLine();
		return doOver.equalsIgnoreCase("Y");
	}
	
	//**********************************************
	
	public static void main(String args[]) {
		final String TITLE = "Lottery Number Generator";
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