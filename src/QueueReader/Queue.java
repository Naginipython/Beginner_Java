package QueueReader;/*
 * Name: Ben McCann
 * Date: 10/17/2018
 * Course Number: CSC-220
 * Course Name: Data Structures
 * Problem Number: Chapter 10 HW
 * Email: bnmccann0001@student.stcc.edu
 * The Queue Class which creates and manipulates Stacks
 */

public class Queue {
	private Stack s = new Stack();
	private Stack sReverse = new Stack();
	
	public void enqueue(int x) {
		s.push(x);
	}
	
	public int peek() {
		shiftStacks();
		return sReverse.peek();
	}
	
	public void dequeue() {
		shiftStacks();
		sReverse.pop();
	}
	
	public boolean isEmpty() {
		return s.empty();
	}
	
	private void shiftStacks() {
		if (sReverse.empty()) {
			while (!s.empty()) {
				sReverse.push(s.pop());
			}
		}
	}
}
