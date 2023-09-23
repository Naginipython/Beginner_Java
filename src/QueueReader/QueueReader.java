package QueueReader;/*
 * Name: Ben McCann
 * Date: 10/17/2018
 * Course Number: CSC-220
 * Course Name: Data Structures
 * Problem Number: Chapter 10 HW
 * Email: bnmccann0001@student.stcc.edu
 * Queue Reader main program, which reads from a website and sets a queue. It enqueues, dequeues, or peeks depending on what the file says to do
 */

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class QueueReader {
	private final static String TITLE = "Queue Reader v1.1";
	private final static String CONTINUE_PROMPT = "Do this again? [y/N] ";
	
	//**********************************************
	// Put as many methods you need here
	private static void readData(String strURL) throws MalformedURLException, IOException  {
		URL url = new URL("https://cs.stcc.edu/~silvestri/QueueQuery/"+strURL);
		Scanner input = new Scanner(url.openStream());
		int size = input.nextInt();
		
		Queue q = new Queue();
		for (int i = 0; i < size; i++) {
			switch (input.nextInt()) {
				case 1:
					q.enqueue(input.nextInt());
					break;
				case 2:
					q.dequeue();
					break;
				case 3:
					System.out.print(q.peek()+" ");
					break;
				default:
					System.out.println("Error");
					break;
			}
		}
		System.out.println();
		input.close();
	}
	
	//**********************************************
	// Start your logic coding in the process method
	private static void process(Scanner sc, String args[]) throws MalformedURLException, IOException {
		// Start Coding your problem in the process method
		
		System.out.print("Enter website with the data data: https://cs.stcc.edu/~silvestri/QueueQuery/"); //QueueQuery0.txt
		String DATA_URL = sc.next();
		//String DATA_URL = "https://cs.stcc.edu/wp-content/uploads/2018/10/StarData1.txt";
		readData(DATA_URL);
		sc.nextLine();
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