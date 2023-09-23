package NameApp;/*
 * Name: Benjamin McCann
 * Date: 11/09/2020 & 12/17/2020
 * Course Number: CSC-220
 * Course Name: Data Structures and Algorithms
 * Problem Number: HW Chapter 13 part 2 & HW Chapter 21
 * Email: bnmccann0001@student.stcc.edu
 * Create the main app for the Names class, Have a male and female array lists that gather names from a website and shows the 
 * top names with the biggest amount of names
 * &
 * Redo the names appto account for HashMaps
 */

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class NameClassApp {
	private final static String TITLE = "Name App v2.0";
	private final static String CONTINUE_PROMPT = "Do this again? [y/N] ";
	
	//**********************************************
	// Put as many methods you need here
	public static void addToArray(ArrayList<Name> male, ArrayList<Name> female, int year) throws MalformedURLException, IOException, NameAppException {
		URL url = new URL("https://cs.stcc.edu/~silvestri/names/yob"+year+".txt");
		Scanner input = new Scanner(url.openStream());
		input.useDelimiter("\\s*,\\s*|\\s+");
		while (input.hasNextLine()) {
			String name = input.next();
			String sex = input.next();
			int number = input.nextInt();
			input.nextLine();
			//System.out.printf("%15s%2s%10d\n", name, sex, number);
			Name person = new Name(name, sex, number);
			if (sex.equals("M")) {
				int index = male.indexOf(person);
				if (index == -1)
					male.add(person);
				else
					male.get(index).addToNumber(person.getNumber());
			}
			if (sex.equals("F")) {
				int index = female.indexOf(person);
				if (index == -1)
					female.add(person);
				else
					female.get(index).addToNumber(person.getNumber());
			}
			
		}
		input.close();
	}
	
	public static void displayTop(ArrayList<Name> male, ArrayList<Name> female, int num) {
		System.out.println();
		System.out.println("************************");
		System.out.println("Males:");
		for (int i = 0; i < num; i++) {
			System.out.println("\t"+(i+1)+"."+male.get(i).toString());
		}
		
		System.out.println();
		System.out.println("Females:");
		for (int i = 0; i < num; i++) {
			System.out.println("\t"+(i+1)+"."+female.get(i).toString());
		}
		System.out.println();
	}
	
	//----------2.0 Functions-----------
	
	public static void addToHashMap(Map<String, Integer> male, Map<String, Integer> female, int year) throws MalformedURLException, IOException {
		URL url = new URL("https://cs.stcc.edu/~silvestri/names/yob"+year+".txt");
		Scanner input = new Scanner(url.openStream());
		input.useDelimiter("\\s*,\\s*|\\s+");
		while (input.hasNextLine()) {
			String name = input.next();
			String sex = input.next();
			int number = input.nextInt();
			input.nextLine();
			
			if (sex.equals("M")) {
				male.put(name, number);
			} else if (sex.equals("F")) {
				female.put(name, number);
			}
		}
	}
	
	public static void displayTopHash(Map<String, Integer> male, Map<String, Integer> female, int top) throws NameAppException {
		TreeMap<String, Integer> newMale = sortByValues(male);
		TreeMap<String, Integer> newFemale = sortByValues(female);
		
		ArrayList<Name> topNamesM = arraySetter(newMale, "M", top);
		ArrayList<Name> topNamesF = arraySetter(newFemale, "F", top);
		
		displayTop(topNamesM, topNamesF, top);
	}
	
	public static ArrayList<Name> arraySetter (TreeMap<String, Integer> gender, String letter, int top) throws NameAppException {
		ArrayList<Name> names = new ArrayList<>();
		int count = 0;
		for (Map.Entry<String, Integer> entry : gender.entrySet()) {
			String key = entry.getKey();
			int value = entry.getValue();
			if (count >= top)
				break;
			names.add(new Name(key, letter, value));
			count++;
		}
		return names;
	}
	
	private static <K, V extends Comparable<V>> TreeMap<K, V> sortByValues(Map<K, V> map) {
		Comparator<K> valueComparator = new Comparator<K>() {
			public int compare(K k1, K k2) {
				int compare = map.get(k1).compareTo(map.get(k2));
				return -compare;
			}
		};
		TreeMap<K, V> sortedByValues = new TreeMap<>(valueComparator);
		sortedByValues.putAll(map);
		return sortedByValues;
	}
	
	
	//**********************************************
	// Start your logic coding in the process method
	private static void process(Scanner sc, String args[]) throws MalformedURLException, IOException, NameAppException {
		// Start Coding your problem in the process method
		int yearStart, yearEnd, topNum;
		do {
			System.out.print("Enter a valid start and end years: ");
			yearStart = sc.nextInt();
			yearEnd = sc.nextInt();
		} while (yearStart > yearEnd || yearStart < 1880 || yearEnd > 2019);
		do {
			System.out.print("Enter how many to appear in the top names: ");
			topNum = sc.nextInt();
		} while (topNum < 0);
		sc.nextLine();  // Clear Keyboard

		Map<String, Integer> male = new HashMap<>();
		Map<String, Integer> female = new HashMap<>();
//		ArrayList<Name> males = new ArrayList<>();
//		ArrayList<Name> females = new ArrayList<>();
		for (int i = yearStart; i <= yearEnd; i++) {
//			addToArray(males, females, i);
			addToHashMap(male, female, i);
			System.out.print(". ");
		}
		displayTopHash(male, female, topNum);
//		displayTop(males, females, topNum);
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
	public static void main(String args[]) throws MalformedURLException, IOException, NameAppException {
		System.out.println("Welcome to " + TITLE);
		Scanner sc = new Scanner(System.in);
		do {
			process(sc, args);
		} while (doThisAgain(sc, CONTINUE_PROMPT));
		sc.close();
		System.out.println("Thank you for using " + TITLE);
	}

}