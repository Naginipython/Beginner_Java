package hw2;/*
 * Benjamin McCann	
 * 10/1/18
 * CSC-111
 * Problem 3
 * Computer Rock Paper Scissors w/ human choice
 * bnmccann0001@student.stcc.edu
 */
import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int computer = (int) (3*Math.random());
		
		System.out.print("Let the game of Rock, Paper, Scissors commence!"
				+ "\nChoose '0' for Rock, '1' for Paper, or '2' for Scissors: ");
		int choice = input.nextInt();
		
		//The calculation; Checks computer, then sees if you win against it or not
		if (computer == 0) {//Rock
			if (choice == 0)
				System.out.print("You and the computer both chose Rock! It's a tie!");
			else if (choice == 1)
				System.out.print("You chose Paper, and the computer chose Rock! You Win!");
			else if (choice == 2)
				System.out.print("You chose Scissors, and the computer chose Rock! You Lose!");
			else 
				System.out.print("Choose between 0 and 2 >:(");
		} 
		
		else if (computer == 1) {//Paper
			if (choice == 0)
				System.out.print("You chose Rock, and the computer chose Paper! You Lose!");
			else if (choice == 1)
				System.out.print("You and the computer both chose Paper! It's a tie!");
			else if (choice == 2)
				System.out.print("You chose Scissors, and the computer chose Paper! You Win!");
			else 
				System.out.print("Choose between 0 and 2 >:(");
		} 
		
		else if (computer == 2) {//Scissors
			if (choice == 0)
				System.out.print("You chose Rock, and the computer chose Scissors! You Win!");
			else if (choice == 1)
				System.out.print("You chose Paper, and the computer chose Scissors! You Lose!");
			else if (choice == 2)
				System.out.print("You and the computer both chose Scissors! It's a tie!");
			else 
				System.out.print("Choose between 0 and 2 >:(");
		}
		
		else
			System.out.print("I messed up.");
		
		input.close();
	}

}
