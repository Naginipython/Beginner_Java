package hw2;/*
 * Name: Benjamin McCann
 * Date: 11/27/18
 * Course Number: csc-111
 * Course Name: Java 1
 * Problem Number: 8
 * Email: bnmccann0001@student.stcc.edu
 * Short Description of the Problem
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class deviationApp {
	
	
	//**********************************************
	
	private static void process(Scanner sc, String args[]) throws FileNotFoundException {
		// Code here is merely a sample
		System.out.print("Enter file name: ");
		String filename = sc.nextLine();
		File dataFile = new File(filename);
		Scanner inputFile = new Scanner(dataFile);
		int total = inputFile.nextInt();
		double[] Array = readData(inputFile, total);
		double deviation = findDeviation(Array, total);
		System.out.printf("The Deviation of the file is: %f\n", deviation);
	}
	
	//**********************************************
	
	private static double[] readData (Scanner sc, int total) {
		double[] result = new double[total];
		for (int i = 0; i < total; i++) {
			result[i] = sc.nextDouble();
		}
		return result;
	}
	
	//**********************************************	
	
	private static Double findDeviation (double[] Array, int total) {
		double mean = findMean(Array, total);
		double numerator = 0;
		for (int i = 0; i < total; i++)
			numerator += ((Array[i]-mean)*(Array[i]-mean));
		return Math.sqrt(numerator/(total-1));
	}
	
	//**********************************************	
	
	private static double findMean (double[] Array, int total) {
		double sum = 0;
		for (int i=0;i<total;i++)
			sum += Array[i];
		return (sum/total);
	}
	
	//**********************************************
	
	private static boolean doThisAgain(Scanner sc, String prompt) {
		System.out.print(prompt);
		String doOver = sc.nextLine();
		return doOver.equalsIgnoreCase("Y");
	}
	
	//**********************************************
	
	public static void main(String args[]) throws FileNotFoundException {
		final String TITLE = "Deviation App";
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