package CrossReference;/*
 * Name: Benjamin McCann
 * Date: 12/6/2020
 * Course Number: CSC-220
 * Course Name: Data Structures and Algorithms
 * Problem Number: Chapter 25 HW
 * Email: bnmccann0001@student.stcc.edu
 * Create a BST for noise words, and give the option to remove noise words from BST. Remove repeats as well.
 */

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class CrossReferenceApp {
	private final static String TITLE = "Cross Reference App V1.0";
	private final static String CONTINUE_PROMPT = "Do this again? [y/N] ";
	
	//**********************************************
	// Put as many methods you need here

	private static boolean isTextFile(String strURL) {
		try {
			URL url = new URL(strURL);
			URLConnection urlconn = url.openConnection();
			return urlconn != null && urlconn.getContentType().contains("text/plain");
		}
		catch (Exception ex) {
		}
		return false;
	}
	
	private static BST<Word> buildCrossReference(String strURL, String noise) throws Exception {
		BST<Word> noiseWord = new BST<>();
		if (noise.equalsIgnoreCase("n")) {
			noiseWord = buildCrossReference("https://cs.stcc.edu/~silvestri/crossreference/CommonWords.txt", "y");
		}
		
		if (!isTextFile(strURL)) 
			return null;
		BST<Word> crossref = new BST<>();
		try(ScannerWithLineno swl = new ScannerWithLineno(new URL(strURL).openStream())) {
			while (swl.hasNext()) {
				String word = swl.next().toLowerCase();
				int lineno = swl.getLineno();
				Word item = new Word(word, lineno);
				Word wordInBST = crossref.search(item);
				if (!noiseWord.contains(item)) {
					if (wordInBST == null) {
						crossref.add(item);
					}
					else {
						wordInBST.addLineno(lineno);
					}
				}
			}
		}
		return crossref;
	}

	private static void outputCrossReference(BST<Word> crossref) {
		for (Word w : crossref)
			System.out.println(w);
		System.out.println();
	}	
	
	//**********************************************
	// Start your logic coding in the process method
	private static void process(Scanner input, String args[]) throws Exception {
		System.out.print("Enter Complete URL: ");
		String strURL = input.nextLine();
		
		System.out.print("Include Noise Words? (Y/N): ");
		String noise = input.next();
		input.nextLine();
		
		BST<Word> crossref = buildCrossReference(strURL, noise);
		if (crossref != null)	
			outputCrossReference(crossref);
		else
			System.out.println("Cannot determine if this is a textfile.");
	}

	//**********************************************
	// Do not change the doThisAgain method
	private static boolean doThisAgain(Scanner input, String prompt) {
		System.out.print(prompt); 
		String doOver = input.nextLine();
		return doOver.trim().equalsIgnoreCase("Y");
	}
	
	//**********************************************
	// Do not change the main method
	public static void main(String args[]) throws Exception {
		System.out.println("Welcome to " + TITLE);
		Scanner input = new Scanner(System.in);
		do {
			process(input, args);
		} while (doThisAgain(input, CONTINUE_PROMPT));
		input.close();
		System.out.println("Thank you for using " + TITLE);
	}

}