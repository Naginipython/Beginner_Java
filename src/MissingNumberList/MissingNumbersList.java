package MissingNumberList;/*
 * Name: Benjamin McCann
 * Date: 9/23/2020
 * Course Number: CSC-220
 * Course Name: Data Structures and Algorithms
 * Problem Number: HW2
 * Email: bnmccann0001@student.stcc.edu
 * 2 Lists of the same numbers, with one of the lists missing a few of the numbers. Create an array for the numbers,
 * and search through the arrays for numbers that are missing. Then make it read from files.
 */

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class MissingNumbersList {
	private final static String TITLE = "Missing Number Finder";
	private final static String CONTINUE_PROMPT = "Do this again? [y/N] ";
	
	private static int arr[];
	private static int brr[];
	
	//**********************************************
	// Put as many methods you need here
	
	public static int[] missingNumbers (int[] arr, int[] brr) {
		int[] newArr = new int[Math.abs(arr.length-brr.length)];
		int index = 0;
		int count = 0;
		while (count < arr.length) {
			if (arr[count] != brr[count+index]) {
				newArr[index] = brr[count+index];
				index++;
			} else {
				count++;
			}
		}
		return newArr;
	}
	
	public static void sort (int[] x) {
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x.length-1; j++) {
				if (i != j && x[i] < x[j]) {
					int temp = x[i];
					x[i] = x[j];
					x[j] = temp;
				}
			}
		}
	}
	
	private static void readFile(Scanner sc) {
		try {
			System.out.print("Enter filename with the 2 number lists: ");
			String filename = sc.nextLine();
			Scanner fileInput = new Scanner(new File(filename));
			int aSize = fileInput.nextInt();
			arr = new int[aSize];
			for (int i = 0; i < arr.length; i++)
				arr[i] = fileInput.nextInt();
			int bSize = fileInput.nextInt();
			brr = new int[bSize];
			for (int i = 0; i < brr.length; i++)
				brr[i] = fileInput.nextInt();
			fileInput.close();
	    } 
	    catch (Exception ex) {
	    }
	}
	
	public static void printArray (int[] x) {
		for (int i = 0; i < x.length; i++) {
			System.out.print(x[i]+" ");
		}
		System.out.println();
	}
	
	//**********************************************
	// Start your logic coding in the process method
	private static void process(Scanner sc, String args[]) {
		// Start Coding your problem in the process method
		
		readFile(sc);
		sort(arr);
		sort(brr);
		System.out.println("First Number List: "+Arrays.toString(arr));
		System.out.println("Second Number List: "+Arrays.toString(brr));
		int[] crr = missingNumbers(arr, brr);
		System.out.println("The missing numbers are: "+Arrays.toString(crr));
		
		//Remnants of an inputting day
		/*
		int n, m;
		System.out.print("Number of items in first list: ");
		n = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.print("Enter item "+(i+1)+": ");
			arr[i] = sc.nextInt();
		}
		System.out.print("Number of items in second list: ");
		m = sc.nextInt();
		brr = new int[m];
		for (int i = 0; i < m; i++) {
			System.out.print("Enter item "+(i+1)+": ");
			brr[i] = sc.nextInt();
		}
		sort(arr);
		sort(brr);
		int[] crr = missingNumbers(arr, brr);
		printArray(crr);
		sc.nextLine();  // Clear Keyboard
		*/
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