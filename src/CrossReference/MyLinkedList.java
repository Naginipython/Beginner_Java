package CrossReference;/*
 * Name: Prof. Tony Silvestri
 * Date: 11/22/2020
 * Course Number: CSC-220
 * Course Name: Data Structures
 * Problem Number: Binary Search Tree Homework
 * Email: silvestri@stcc.edu
 * Create an index table of words and the line numbers they are found
 * MyLinkedList exact code from Chapter 24
 */

public class MyLinkedList<E> implements MyList<E>, Iterable<E> {
	private static class Node<E> {
		private E data;
		private Node<E> next;

		public Node(E data) {
			this(data, null);
		}

		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node<E> head, tail;
	private int size = 0; // Number of datas in the list

	/** Create an empty list */
	public MyLinkedList() {
	}

	/** Return the head data in the list */
	public E getFirst() {
		if (head != null) {
			return head.data;
		}
		return null;
	}

	/** Return the last data in the list */
	public E getLast() {
		if (tail != null) {
			return tail.data;
		}
		return null;
	}

	/** Add an data to the beginning of the list */
	public void addFirst(E e) {
		Node<E> newNode = new Node<>(e); // Create a new node
		newNode.next = head; // link the new node with the head
		head = newNode; // head points to the new node
		size++; // Increase list size

		if (tail == null) // the new node is the only node in list
			tail = head;
	}

	/** Add an data to the end of the list */
	public void addLast(E e) {
		Node<E> newNode = new Node<>(e); // Create a new for data e

		if (tail == null) {
			head = tail = newNode; // The new node is the only node in list
		}
		else {
			tail.next = newNode; // Link the new with the last node
			tail = newNode; // tail now points to the last node
		}

		size++; // Increase size
	}

	@Override /**
				 * Add a new data at the specified index in this list. The index of the head
				 * data is 0
				 */
	public void add(int index, E e) {
		if (index == 0) {
			this.addFirst(e);
		}
		else if (index >= size) {
			this.addLast(e);
		}
		else {
			Node<E> current = head;
			Node<E> prev = null;
			for (int i = 0; i < index; i++) {
				prev = current;
				current = current.next;
			}
			Node<E> newNode = new Node<>(e);
			prev.next = newNode;
			newNode.next = current;
			size++;
		}
	}

	/**
	 * Remove the head node and return the object that is contained in the removed
	 * node.
	 */
	public E removeFirst() {
		if (head == null) {
			return null;
		}
		E temp = head.data;
		head = head.next;
		size--;
		if (head == null) {
			tail = null;
		}
		return temp;

	}

	/**
	 * Remove the last node and return the object that is contained in the removed
	 * node.
	 */
	public E removeLast() {
		if (tail == null) {
			return null;
		}
		if (head == tail) {
			E temp = head.data;
			head = tail = null;
			size = 0;
			return temp;
		}
		Node<E> current = head;
		Node<E> prev = null;
		
		while (current != tail) {
			prev = current;
			current = current.next;
		}

		E temp = tail.data;
		tail = prev;
		tail.next = null;
		size--;
		return temp;

	}

	@Override /**
				 * Remove the data at the specified position in this list. Return the data
				 * that was removed from the list.
				 */
	public E remove(int index) {
		if (index < 0 || index >= size) {
			return null;
		}
		if (index == 0) {
			return removeFirst();
		}
		if (index == size - 1) {
			return removeLast();
		}
		Node<E> current = head;
		Node<E> prev = null;
		for (int i = 0; i < index; i++) {
			prev = current;
			current = current.next;
		}
		
		prev.next = current.next;
		size--;
		return current.data;			
	}

	@Override /** Override toString() to return datas in the list */
	public String toString() {
		StringBuilder result = new StringBuilder("[");

		Node<E> current = head;
		while (current != null) {
			result.append(current.data);
			current = current.next;
			if (current != null) {
				result.append(", "); // Separate two datas with a comma
			}
			else {
				result.append("]"); // Insert the closing ] in the string
			}
		}

		return result.toString();
	}

	public void clear() {
		size = 0;
		head = tail = null;
	}

	@Override /** Return the number of datas in this list */
	public int size() {
		return size;
	}

	@Override /** Override iterator() defined in Iterable */
	public java.util.Iterator<E> iterator() {
		return new LinkedListIterator();
	}

	private class LinkedListIterator implements java.util.Iterator<E> {
		private Node<E> current = head; // Current index

		@Override
		public boolean hasNext() {
			return (current != null);
		}

		@Override
		public E next() {
			E e = current.data;
			current = current.next;
			return e;
		}

		@Override
		public void remove() {
		}
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(E e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public E set(int index, E e) {
		// TODO Auto-generated method stub
		return null;
	}

}