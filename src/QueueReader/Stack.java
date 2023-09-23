package QueueReader;//prof. silvestri's stack3.java
import java.util.*;

public class Stack {
	private static final int DEFAULT_CAPACITY = 16;
	private ArrayList<Integer> data;

	public Stack() {
		this(DEFAULT_CAPACITY);
	}

	public Stack(int capacity) {
		data = new ArrayList<Integer>(capacity);
	}
	
	public void push(int i) {
		data.add(i);
	}

	public int pop() {
		if (!this.empty()) {
			int i = data.get(this.getSize() - 1);
			data.remove(this.getSize() - 1);
			return i;
		}
		System.out.println("Can't pop empty stack.");
		return 0;
	}

	public int peek() {
		if (!this.empty()) {
			int i = data.get(this.getSize() - 1);
			return i;
		}
		System.out.println("Can't peek empty stack.");
		return 0;
	}

	public boolean empty() {
		return data.isEmpty();
	}

	public int getSize() {
		return data.size();
	}

	/** Override the toString in the Object class */
	public String toString() {
		String retval = "";
		for (int i = 0; i < this.getSize(); i++) {
			retval += data.get(i);
			if (i < this.getSize() - 1) 
				retval += " ";			
		}
		return retval;
	}
}