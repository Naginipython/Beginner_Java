package hw2;/*
 * Benjamin McCann	
 * 10/1/18
 * CSC-111
 * Problem 3 Bonus
 * Rock Paper Scissors Lizard Spock
 * bnmccann0001@student.stcc.edu
 */
import java.util.Scanner;

public class BonusRockPaperScissors {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int computer = (int) (5*Math.random()); // #0-4
		
		System.out.print("Let the game of Rock, Paper, Scissors, Lizard, Spock commence!"
				+ "\nChoose '0' for Rock, '1' for Paper, '2' for Scissors, '3' for Lizard, or '4' for Spock: ");
		int choice = input.nextInt();
		
		if (computer == choice) {//Tie
			System.out.print("You and the computer chose the same! It's a tie!");
		}
		
		else if (computer == 0) {//Rock
			//Winning
			if (choice == 1)
				System.out.print("You chose Paper, and the computer chose Rock! You Win!");
			else if (choice == 4)
				System.out.print("You chose Spock, and the computer chose Rock! You Win!");
			//Losing
			else if (choice == 2)
				System.out.print("You chose Scissors, and the computer chose Rock! You Lose!");
			else if (choice == 3)
				System.out.print("You chose Lizard, and the computer chose Rock! You Lose!");
			else 
				System.out.print("Choose between 0 and 4 >:(");
		}
		
		else if (computer == 1) {//Paper
			//Winning
			if (choice == 2)
				System.out.print("You chose Scissors, and the computer chose Paper! You Win!");
			else if (choice == 3)
				System.out.print("You chose Lizard, and the computer chose Paper! You Win!");
			//Losing
			else if (choice == 0)
				System.out.print("You chose Rock, and the computer chose Paper! You Lose!");
			else if (choice == 4)
				System.out.print("You chose Spock, and the computer chose Paper! You Lose!");
			else 
				System.out.print("Choose between 0 and 4 >:(");
		}
		
		else if (computer == 2) {//Scissors
			//Winning
			if (choice == 0)//Rock
				System.out.print("You chose Rock, and the computer chose Scissors! You Win!");
			else if (choice == 4)//Spock
				System.out.print("You chose Spock, and the computer chose Scissors! You Win!");
			//Losing
			else if (choice == 1)//Paper
				System.out.print("You chose Paper, and the computer chose Scissors! You Lose!");
			else if (choice == 3)//Lizard
				System.out.print("You chose Lizard, and the computer chose Scissors! You Lose!");
			else 
				System.out.print("Choose between 0 and 4 >:(");
		}
		
		else if (computer == 3) {//Lizard
			//Winning
			if (choice == 0)//Rock
				System.out.print("You chose Rock, and the computer chose Lizard! You Win!");
			else if (choice == 2)//Scissors
				System.out.print("You chose Scissors, and the computer chose Lizard! You Win!");
			//Losing
			else if (choice == 1)//Paper
				System.out.print("You chose Paper, and the computer chose Lizard! You Lose!");
			else if (choice == 4)//Spock
				System.out.print("You chose Spock, and the computer chose Lizard! You Lose!");
			else 
				System.out.print("Choose between 0 and 4 >:(");
		}
		
		else if (computer == 4) {//Spock
			//Winning
			if (choice == 1)//Paper
				System.out.print("You chose Paper, and the computer chose Spock! You Win!");
			else if (choice == 3)//Lizard
				System.out.print("You chose Lizard, and the computer chose Spock! You Win!");
			//Losing
			else if (choice == 0)//Rock
				System.out.print("You chose Rock, and the computer chose Spock! You Lose!");
			else if (choice == 2)//Scissors
				System.out.print("You chose Scissors, and the computer chose Spock! You Lose!");
			else 
				System.out.print("Choose between 0 and 4 >:(");
		}
		
		else 
			System.out.print("I did something wrong.");
		input.close();
	}

}
