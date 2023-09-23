package NameApp;/*
 * Name: Benjamin McCann
 * Date: 11/04/2020
 * Course Number: CSC-220
 * Course Name: Data Structures and Algorithms
 * Problem Number: Chapter 13 HW
 * Email: bnmccann0001@student.stcc.edu
 * An exception for the Name App
 */

public class NameAppException extends Exception {
	public NameAppException (String s) {
		super("Invalid String: " + s);
	}
}
