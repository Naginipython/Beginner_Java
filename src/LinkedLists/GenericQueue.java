package LinkedLists;

import java.util.*;

public class GenericQueue<E> {
	private LinkedList<E> list = new LinkedList<E>();

	public void enqueue(E e) {
		list.addLast(e);
	}

	public E dequeue() {
		return list.removeFirst();
	}

	public int getSize() {
		return list.size();
	}

	@Override
	public String toString() {
		return "Queue: " + list.toString();
	}
}