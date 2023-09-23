package CrossReference;/*
 * Name: Prof. Tony Silvestri
 * Date: 11/22/2020
 * Course Number: CSC-220
 * Course Name: Data Structures
 * Problem Number: Binary Search Tree Homework
 * Email: silvestri@stcc.edu
 * Tree Interface stripped down code from textbook to be lightweight
 */


public interface Tree<E> {
	/** Return the element if it is in the tree */
	public E search(E e);

	/**
	 * Insert element e into the binary tree Return true if the element is
	 * inserted successfully
	 */
	public boolean insert(E e);

	/** Get the number of elements in the tree */
	public int getSize();

	public default boolean isEmpty() {
		return this.size() == 0;
	}

	@SuppressWarnings("unchecked")
	public default boolean contains(Object e) {
		return search((E) e) != null;
	}

	public default boolean add(E e) {
		return insert(e);
	}

	public default int size() {
		return getSize();
	}

}