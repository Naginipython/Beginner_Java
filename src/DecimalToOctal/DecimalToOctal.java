package DecimalToOctal;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Ben McCann
 * 09/18/20
 * Digital Logic
 */
public class DecimalToOctal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the Decimal to Octal Base Calculator!");
		System.out.print("Please enter a decimal number: ");
		int num = sc.nextInt();
		int arr[] = new int[1];
		int count = 0;
		int x = num;
		
		//Converting to octal on array arr
		do {
			arr[count] = x % 8;
			x = (x-arr[count]) / 8;
			count++;
			arr = Arrays.copyOf(arr, arr.length+1); //just in case it's bigger
		} while (x != 0);
		
		//Convert array to int
		int octalNum = 0;
		for (int i = 0; i < arr.length; i++) {
			octalNum = octalNum*10;
			octalNum += arr[arr.length-i-1];
		}
		
		System.out.println("Decimal Number: "+num+"\nOctal Number: "+octalNum);
		
		
		
		sc.close();
	}

}
