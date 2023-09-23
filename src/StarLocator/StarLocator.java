package StarLocator;/*
 * Name:Benjamin McCann
 * Date: 9/23/2020
 * Course Number: CSC-220
 * Course Name: Data Structures and Algorithms
 * Problem Number: HW3
 * Email: bnmccann0001@student.stcc.edu
 * Find stars based on a grid of numbers and display it
 */

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class StarLocator {
	private final static String TITLE = "NASA Star Locator";
	private final static String CONTINUE_PROMPT = "Do this again? [y/N] ";
	
	//**********************************************
	// Put as many methods you need here
	private static int[][] readData(String strURL) throws MalformedURLException, IOException  {
		int[][] starData;
		URL url = new URL(strURL);
		Scanner input = new Scanner(url.openStream());
		int aSize = input.nextInt();
		int bSize = input.nextInt();
		starData = new int[aSize][bSize];
		for (int i = 0; i < starData.length; i++) {
			for (int j = 0; j < starData[i].length; j++) {
				starData[i][j] = input.nextInt();
			}
		}
		input.close();		
		return starData;
	}
	
	private static char[] analyzeStarData (int[][] stardata, int line) {
		char[] stars = new char[stardata[line].length];
		stars[0] = ' ';
		stars[stars.length-1] = ' ';
		for (int i = 1; i < stardata[line].length-1; i++) {
			//Finding sum
			int sum = 0;
			for (int j = i-1; j < i+1; j++) {
				//Upper 3 Numbers
				sum += stardata[line-1][j];
			}
			for (int j = i-1; j < i+1; j++) {
				//Lower 3 Numbers
				sum += stardata[line+1][j];
			}
			//Side 2 Numbers
			sum+= stardata[line][i-1];
			sum+= stardata[line][i+1];
			
			
			
			if ((sum+stardata[line][i])/5 > 6) {
				stars[i] = '*';
			} else {
				stars[i] = ' ';
			}
		}
		return stars;
	}
	
	private static void outputStarData (char[][] pattern) {
		//Creates repeatable line
		String repeatedLine = "+";
		for (int i = 0; i < pattern[0].length; i++) {
			repeatedLine = repeatedLine + "---+";
		}
		System.out.print(repeatedLine);
		
		//Finds and displays entire 2d array
		for (int i = 0; i < pattern.length; i++) {
			for (int j = 0; j < pattern[i].length; j++) {
				if (j == 0) {
					System.out.println();
					System.out.print("| ");
				}
				System.out.print(pattern[i][j]+" | ");
			}
			System.out.println();
			System.out.print(repeatedLine);
		}
		System.out.println();
	}
	
	//**********************************************
	// Start your logic coding in the process method
	private static void process(Scanner sc, String args[]) throws MalformedURLException, IOException {
		// Start Coding your problem in the process method
		System.out.print("Enter website of star data: ");
		String DATA_URL = sc.next();
		//String DATA_URL = "https://cs.stcc.edu/wp-content/uploads/2018/10/StarData1.txt";
		int[][] starData = readData(DATA_URL);
		sc.nextLine();
		
		//Creates char 2d array of star locations
		char[][] starLocations = new char[starData.length][starData[0].length];
		for (int i = 1; i < starData.length-1; i++) {
			starLocations[i] = analyzeStarData(starData, i);
		}
		outputStarData(starLocations);
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
	public static void main(String args[]) throws MalformedURLException, IOException {
		System.out.println("Welcome to " + TITLE);
		Scanner sc = new Scanner(System.in);
		do {
			process(sc, args);
		} while (doThisAgain(sc, CONTINUE_PROMPT));
		sc.close();
		System.out.println("Thank you for using " + TITLE);
	}

}