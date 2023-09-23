package fiveYears;

/*
 * Benjamin McCann	
 * 9/11/18
 * CSC-111
 * Problem 1
 * Calaculate the population in 5 years
 * bnmccann0001@student.stcc.edu
 */
public class Population {

	public static void main(String[] args) {
		System.out.println("Year 1: "+312032486);
		System.out.println("Year 5: "+(5*(((60*60*24*365)/7)+((60*60*24*365)/45)-((60*60*24*365)/13)+312032486)));
	}

}
