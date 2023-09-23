package hw2;/*
 * Benjamin McCann	
 * 9/11/18
 * CSC-111
 * Problem 1
 * Calaculate the population in 5 years
 * bnmccann0001@student.stcc.edu
 */

import java.util.Scanner;

public class Temp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter Temperture:");
		double fahrenheit = input.nextDouble();
		double celsius = (fahrenheit-32.0)*(5.0/9.0);
		System.out.print("Enter Dewpoint:");
		double dewpointF = input.nextDouble();
		double dewpointC = (dewpointF-32.0)*(5.0/9.0);
		double humidity = 100*(Math.exp((17.625*dewpointC)/(243.04+dewpointC))/Math.exp((17.625*celsius)/(243.04+celsius)));
		System.out.printf("With a Temperture of %.3f and a Dewpoint of %.3f, the Relative Humidity is %.3f%%.\n",
				fahrenheit,
				dewpointF,
				humidity);
		
		System.out.print("Enter Temperture:");
		fahrenheit = input.nextDouble();
		celsius = (fahrenheit-32.0)*(5.0/9.0);
		System.out.print("Enter Humidity:");
		humidity = input.nextDouble();
		dewpointC = 243.04*(Math.log(humidity/100)+((17.625*celsius)/(243.04+celsius)))/(17.625-Math.log(humidity/100)-((17.625*celsius)/(243.04+celsius)));
		dewpointF = dewpointC*(9.0/5.0)+32.0;
		System.out.printf("With a Temperture of %.3f and a Relative Humidity of %.3f, the Dewpoint is %.3f� Fahrenheit.\n",
				fahrenheit,
				humidity,
				dewpointF);
		
		System.out.print("Enter Dewpoint:");
		dewpointF = input.nextDouble();
		dewpointC = (dewpointF-32.0)*(5.0/9.0);
		System.out.print("Enter Humidity:");
		humidity = input.nextDouble();
		celsius = 243.04*(((17.625*dewpointC)/(243.04+dewpointC))-Math.log(humidity/100))/(17.625+Math.log(humidity/100)-((17.625*dewpointC)/(243.04+dewpointC)));
		fahrenheit = celsius*(9.0/5.0)+32.0;
		System.out.printf("With a Dewpoint of %.3f and a Relative Humidity of %.3f, the Temperture is %.3f� Fahrenheit.\n",
				dewpointF,
				humidity,
				fahrenheit);
		
		input.close();
	}

}
