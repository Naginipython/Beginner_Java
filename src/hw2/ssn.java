package hw2;/*
 * Benjamin McCann	
 * 10/22/18
 * CSC-111
 * Problem 5
 * Find if ssn is valid
 * bnmccann0001@student.stcc.edu
 */
import java.util.Scanner;

public class ssn {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a SSN: ");
		String ssn = input.next();
		boolean isValid = false;
		
		switch (ssn.length()) {
			case 9: //for some reason, doesnt count with 0. �\_(._.)_/�
				if (Character.isDigit(ssn.charAt(0))) //unfortunately have to check them all without loop. Not sure if more efficient method
					if (Character.isDigit(ssn.charAt(1)))
						if (Character.isDigit(ssn.charAt(2)))
							if (Character.isDigit(ssn.charAt(3)))
								if (Character.isDigit(ssn.charAt(4)))
									if (Character.isDigit(ssn.charAt(5)))
										if (Character.isDigit(ssn.charAt(6)))
											if (Character.isDigit(ssn.charAt(7)))
												if (Character.isDigit(ssn.charAt(8)))
													isValid = true;
				break;
			case 11:
				if (ssn.charAt(2) == '-'&&ssn.charAt(6) == '-') {
					if (Character.isDigit(ssn.charAt(0)))
						if (Character.isDigit(ssn.charAt(1)))
							if (Character.isDigit(ssn.charAt(3)))
								if (Character.isDigit(ssn.charAt(4)))
									if (Character.isDigit(ssn.charAt(5)))
										if (Character.isDigit(ssn.charAt(7)))
											if (Character.isDigit(ssn.charAt(8)))
												if (Character.isDigit(ssn.charAt(9)))
													if (Character.isDigit(ssn.charAt(10)))
														isValid = true;
				}
				break;
		}
		System.out.printf(isValid ? "%s is a valid SSN" : "%s is not a valid SSN. Formats are: xxxxxxxxx or xx-xxx-xxxx, x being #0-9",
				ssn);
		input.close();
	}

}
