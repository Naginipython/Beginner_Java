package CrossReference;/*
 * Name: Prof. Tony Silvestri
 * Date: 11/22/2020
 * Course Number: CSC-220
 * Course Name: Data Structures
 * Problem Number: Binary Search Tree Homework
 * Email: silvestri@stcc.edu
 * Create an index table of words and the line numbers they are found
 * BST is lightweight version of code from Chapter 25
 */

public class BST<E extends Comparable<E>> implements Tree<E>, Iterable<E> {
    /**
	 * This inner class is static, because it does not access any instance members
	 * defined in its outer class
	 */
	private static class TreeNode<E> {
		private E data;
		private TreeNode<E> left;
		private TreeNode<E> right;

		private TreeNode(E e) {
			this.data = e;
			this.left = this.right = null;
		}
	}
	
	protected TreeNode<E> root = null;
	protected int size = 0;

	/** Create a default binary tree */
	public BST() {
	}

	/** Remove all elements from the tree */
	public void clear() {
		root = null;
		size = 0;
	}

	@Override /** Get the number of nodes in the tree */
	public int getSize() {
		return size;
	}

	/** Returns the root of the tree */
	public TreeNode<E> getRoot() {
		return root;
	}
	
	@Override /** Returns true if the data is in the tree */
	public E search(E e) {
		TreeNode<E> current = root; // Start from the root

		while (current != null) {
			if (e.compareTo(current.data) < 0) {
				current = current.left;
			} else if (e.compareTo(current.data) > 0) {
				current = current.right;
			} else // data matches current.data
				return current.data; // data is found
		}

		return null;
	}
	
	public boolean contains(E e) { //Ben Code
		TreeNode<E> current = root; // Start from the root

		while (current != null) {
			if (e.compareTo(current.data) < 0) {
				current = current.left;
			} else if (e.compareTo(current.data) > 0) {
				current = current.right;
			} else // data matches current.data
				return true; // data is found
		}
		
		return false;
	}

	@Override /**
				 * Insert data e into the binary tree Return true if the data is inserted
				 * successfully
				 */
	public boolean insert(E e) {
		if (root == null)
			root =  new TreeNode<E>(e); // Create a new root
		else {
			// Locate the parent node
			TreeNode<E> parent = null;
			TreeNode<E> current = root;
			while (current != null)
				if (e.compareTo(current.data) < 0) {
					parent = current;
					current = current.left;
				} else if (e.compareTo(current.data) > 0) {
					parent = current;
					current = current.right;
				} else
					return false; // Duplicate node not inserted

			// Create the new node and attach it to the parent node
			if (e.compareTo(parent.data) < 0)
				parent.left = new TreeNode<E>(e);
			else
				parent.right = new TreeNode<E>(e);
		}

		size++;
		return true; // data inserted successfully
	}

	@Override /** Obtain an iterator. Use inorder. */
	public java.util.Iterator<E> iterator() {
		return new InorderIterator();
	}

	// Inner class InorderIterator
	private class InorderIterator implements java.util.Iterator<E> {
		// Store the elements in a list
		private java.util.ArrayList<E> list = new java.util.ArrayList<>();
		private int current = 0; // Point to the current data in list

		public InorderIterator() {
			inorder(); // Traverse binary tree and store elements in list
		}

		/** Inorder traversal from the root */
		private void inorder() {
			inorder(root);
		}

		/** Inorder traversal from a subtree */
		private void inorder(TreeNode<E> root) {
			if (root == null)
				return;
			inorder(root.left);
			list.add(root.data);
			inorder(root.right);
		}

		@Override /** More elements for traversing? */
		public boolean hasNext() {
			if (current < list.size())
				return true;

			return false;
		}

		@Override /** Get the current data and move to the next */
		public E next() {
			return list.get(current++);
		}

		@Override // Remove the data returned by the last next()
		public void remove() {
		}
	}

}