package CrossReference;/*
 * Name: Prof. Tony Silvestri
 * Date: 11/22/2020
 * Course Number: CSC-220
 * Course Name: Data Structures
 * Problem Number: Binary Search Tree Homework
 * Email: silvestri@stcc.edu
 * Returns a word/token with its associated line number and line
 */

import java.util.*;
import java.io.*;

public class ScannerWithLineno implements AutoCloseable {
	protected Scanner sc;

	protected String buffer;
	protected Scanner bufferScanner;

	protected int lineno = 0;

	public int getLineno() {
		return lineno;
	}
	
	public String getCurrentLine() {
		return this.buffer;
	}

	public ScannerWithLineno(File source) throws FileNotFoundException {
		sc = new Scanner(source);
		getNextLine(); // Initialize starting line
	}

	public ScannerWithLineno(InputStream source) {
		sc = new Scanner(source);
		getNextLine(); // Initialize starting line
	}
	
	public void close() {
		sc.close();
	}

	private void getNextLine() {
		if (sc.hasNextLine()) {
			// You have a line to read so do it.
			buffer = sc.nextLine();
			lineno++;
			// Set up Scanner for that line
			bufferScanner = new Scanner(buffer);
			bufferScanner.useDelimiter("([\\s\\.?!`,;:~{}'\"\\)\\(\\*\\[\\]]|--)+");
		} else {
			// No line so null out important vars
			buffer = null;
			bufferScanner = null;
		}
	}

	public boolean hasNext() {
		do {
			if (buffer == null || bufferScanner == null)
				return false;
			if (bufferScanner.hasNext())
				return true;
			getNextLine();
		} while (true);
	}

	// Should only be called if hasNext() is true
	public String next() {
		return hasNext() ? bufferScanner.next() : null;
	}

}