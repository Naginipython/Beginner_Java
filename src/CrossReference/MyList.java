package CrossReference;/*
 * Name: Prof. Tony Silvestri
 * Date: 11/22/2020
 * Course Number: CSC-220
 * Course Name: Data Structures
 * Problem Number: Binary Search Tree Homework
 * Email: silvestri@stcc.edu
 * Create an index table of words and the line numbers they are found
 * MyList Interface stripped down code from textbook to be lightweight
 */

public interface MyList<E> {
  /** Add a new element at the specified index in this list */
  public void add(int index, E e);

  /** Return the element from this list at the specified index */
  public E get(int index);

  /** Return the index of the first matching element in this list.
   *  Return -1 if no match. */
  public int indexOf(Object e);

  /** Return the index of the last matching element in this list
   *  Return -1 if no match. */
  public int lastIndexOf(E e);

  /** Remove the element at the specified position in this list
   *  Shift any subsequent elements to the left.
   *  Return the element that was removed from the list. */
  public E remove(int index);

  /** Replace the element at the specified position in this list
   *  with the specified element and returns the new set. */
  public E set(int index, E e);
  
  public int size();
  
  public default boolean add(E e) {
    add(size(), e);
    return true;
  }

  public default boolean isEmpty() {
    return size() == 0;
  }

  /** Remove the first occurrence of the element e 
   *  from this list. Shift any subsequent elements to the left.
   *  Return true if the element is removed. */
  public default boolean remove(Object e) {
    if (indexOf(e) >= 0) {
      remove(indexOf(e));
      return true;
    }
    else
      return false;
  }

}