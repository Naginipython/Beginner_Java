package CrossReference;/*
 * Name: Prof. Tony Silvestri
 * Date: 11/22/2020
 * Course Number: CSC-220
 * Course Name: Data Structures
 * Problem Number: Binary Search Tree Homework
 * Email: silvestri@stcc.edu
 * WORD class to support the line numbers associated with a word
 */

public class Word implements Comparable<Word> {
	private String word;
	private MyLinkedList<Integer> linenos;
	

	public Word(String word) {
		this.word = word;
		linenos = new MyLinkedList<>();
	}

	public Word(String word, int lineno) {
		this(word);
		this.addLineno(lineno);
	}
	
	public String getWord() {
		return word;
	}
	
	public MyLinkedList<Integer> getLinenos() {
		return linenos;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public void addLineno(int lineno) {
		//Ben Code
		if (this.linenos.size() == 0)
			this.linenos.addLast(lineno);
		else {
			if (this.linenos.getLast() != lineno)
				this.linenos.addLast(lineno);
		}
	}
	
	@Override
	public String toString() {
		return String.format("%-15s: %s", this.word, this.linenos);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}

	@Override
	public int compareTo(Word o) {
		return this.word.compareTo(o.word);
	}

}