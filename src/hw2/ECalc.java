package hw2;// Tony Silvestri
// CSCI-111
// e series calculation program
// e^x = 1+x/1!+x2/2!+x3/3!+....

import java.util.*;

public class ECalc  
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter x: ");
		double x = input.nextDouble();
		
		double sum = 0.0;
		int i = 0;
		while (i < 25) {
			//Calculate power numerator
			double num = 1.0;
			int j = 0;
			while (j < i) {
				num *= x;
				j++;
			}
						
			//Calculate factorial denominator
			double den = 1;
			j = 1;
			while (j <= i) {
				den *= j;   // product = product * term;
				++j;
			}

			double fraction = num / den;
			sum += fraction;
			
			i++;
		}
		
		//sum contains e calculation
		System.out.printf("exp(%.2f) = %.5f\n", x, sum);
	}
	
	public static void main2(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter x: ");
		double x = input.nextDouble();
		
		double sum = 0.0;
		for (int i = 0; i < 25; i++) {
			//Calculate power numerator
			double num = 1.0;
			for (int j = 0; j < i; j++) 
				num *= x;
						
			//Calculate factorial denominator
			double den = 1;
			for (int j = 1; j <= i; j++) 
				den *= j;

			double fraction = num / den;
			sum += fraction;			
		}

		//sum contains e calculation
		System.out.printf("exp(%.2f) = %.5f\n", x, sum);
	}

}
