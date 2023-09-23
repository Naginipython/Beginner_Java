package LinkedLists;

//Mostly Prof.Silvestri code, lines 50-64 are Ben McCann's.
public class TestMyList {
	/** Main method */
	public static void main(String[] args) {
		// Create a list for strings
		
		long start = System.nanoTime();
		MyList<String> list = new MyLinkedList<>();
		//MyList<String> list = new MyArrayList<String>();

		// Add elements to the list
		list.add("America"); // Add it to the list
		System.out.println("(1) " + list);
		
		for (int i=0; i < 10000; i++) {
			list.add(0, "USAUSAUSA");
		}
		
		for (int i=0; i < 10000; i++) {
			list.remove(0);
		}

		list.add(0, "Canada"); // Add it to the beginning of the list
		System.out.println("(2) " + list);

		list.add("Russia"); // Add it to the end of the list
		System.out.println("(3) " + list);

		list.add("France"); // Add it to the end of the list
		System.out.println("(4) " + list);

		list.add(2, "Germany"); // Add it to the list at index 2
		System.out.println("(5) " + list);

		list.add(5, "Norway"); // Add it to the list at index 5
		System.out.println("(6) " + list);

		list.add(0, "Poland"); // Same as list.addFirst("Poland")
		System.out.println("(7) " + list);

		// Remove elements from the list
		list.remove(0); // Same as list.remove("Australia") in this case
		System.out.println("(8) " + list);

		list.remove(2); // Remove the element at index 2
		System.out.println("(9) " + list);

		list.remove(list.size() - 1); // Remove the last element
		System.out.println("(10) " + list);
		
		String word = "Canada";
		System.out.println("(11) List contains '"+word+"'? " + list.contains(word)); // Testing my contains
		
		System.out.println("(12) String at line 2 is " + list.get(2)); // Testing my get
		
		String word2 = "France";
		System.out.println("(13) String '"+word2+"' is at index " + list.indexOf(word2)); // Testing my indexOf
		
		String word3 = "America";
		list.add("America");
		System.out.println(("(14.1) "+list));
		System.out.println("(14.2) String '"+word3+"' appears last at index " + list.lastIndexOf(word3)); // Testing my lastIndexOf
		
		list.set(1, "Brazil");
		System.out.println("(15) " + list);

		//for (String s : list)
		//	System.out.print(s.toUpperCase() + " ");

		long end = System.nanoTime();

		System.out.printf("%,d", end - start);
		//list.clear();
		//System.out.println("\nAfter clearing the list, the list size is "
		//		+ list.size());
	}
}