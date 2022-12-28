import java.util.Scanner;

public class LinkedList<E extends Comparable<E>> { 

	//---------------- nested Node class ----------------
	private static class Node<E> { 
		private E data; 			// reference to the data stored at this node
		private Node<E> next; 		// reference to the subsequent node in the list
		public Node(E e, Node<E> n) { 
			data = e;
			next = n;
		} 
		public E getData( ) { 
			return data; } 
		public Node<E> getNext( ) { 
			return next; } 
		public void setNext(Node<E> n) { 
			next = n; } 
	} 

	// instance variables of the LinkedList
	private Node<E> head = null; 	// head node of the list (or null if empty)
	private Node<E> tail = null; 	// last node of the list (or null if empty)
	private int size = 0; 			// number of nodes in the list

	public LinkedList( ) { } 		// constructs an initially empty list

	// access methods
	public int size( ) { 
		return size; }
	
	public boolean isEmpty( ) { 
		return size == 0; } 
	
	public E first( ) { 			// returns (but does not remove) the first data
		if (isEmpty( )) 
			return null;
		return head.getData( );
	} 
	
	public E last( ) { 				// returns (but does not remove) the last data
		if (isEmpty( )) 
			return null;
		return tail.getData( );
	} 
	
	// update methods
	public void addFirst(E e) { 	// adds data e to the front of the list
		head = new Node<>(e, head); // create and link a new node
		if (size == 0)
			tail = head; 			// special case: new node becomes tail also
		size++;
	} 
	
	public void addLast(E e) { 		// adds data e to the end of the list
		Node<E> newest = new Node<>(e, null); // node will eventually be the tail
		if (isEmpty( ))
			head = newest; 			// special case: previously empty list
		else
			tail.setNext(newest); 	// new node after existing tail
		tail = newest; 				// new node becomes the tail
		size++;
	} 
	
	public E removeFirst( ) { 		// removes and returns the first data
		if (isEmpty( )) return null; // nothing to remove
		E answer = head.getData( );
		head = head.getNext( ); 	// will become null if list had only one node
		size--;
		if (size == 0)
			tail = null; 			// special case as list is now empty
		return answer;
	} 
	
	public E removeLast( ) { 		// removes and returns the last data
		if (isEmpty( )) return null; // nothing to remove
		E answer = tail.getData( );
		if (head == tail) {			// check for only one item on the list
			head = null;
			tail = null;
			size = 0;
			return answer;
		}
		Node<E> p = head;			// find the next to last item
		Node<E> prev;
		do {
			prev = p;
			p = p.getNext( );
		} while (p != tail);
		tail = prev;				// make the next to last item the last item
		prev.next = null;
		size--;
		return answer;
	} 
	
	public int indexOf(E e) {		// return the position of a value in the list
		if (isEmpty()) return -1;
		Node<E> p = head;
		for (int i = 0; i<size; i++) {
			if (e.equals(p.getData( )))
				return i;
			p = p.getNext();
		}
		return -1;
	}
		
	public boolean contains(E e) {
		return indexOf(e) >= 0;
	}
	/**
	 * Sort Method
	 * Sorts the linkedlist in ascending order by order. 
	 */
	public void sort() {
		//Checks to see if the size is 0 or 1, in case it is sorted. 
		if (isEmpty() || size == 1) return;
		//Created an empty sorted list then adds the first object
		LinkedList<E> sorted = new LinkedList<E>();
		LinkedList.Node<E> objCurrent = head;
		sorted.size = 1;
		sorted.head = this.head;
		sorted.tail = this.head;
		head = head.getNext();
		sorted.head.next = null;
		size --;
		LinkedList.Node<E> trailsToCompare = null;
		LinkedList.Node<E> objToCompare;
		objCurrent.next = null;
		//If there are still objects in in the list:
		while (!isEmpty())
		{
			objCurrent = head;
			//boolean isInCorrectSpot = false;
			objToCompare = sorted.head;
			//boolean indexAt = 0;
			boolean atHead = true;
			boolean atTail = false;
			if (size != 1) head = objCurrent.next;
			//Check to see if we are in the right spot. 
			while (objCurrent.getData().compareTo(objToCompare.getData()) > 0)
			{
				//We aren't at the head if we have to iterate 
				atHead = false;
				//There are no more objects to compare, so we are in the correct spot. 
				if (objToCompare.next == null)
				{
					atTail = true;
					break;
				}
				trailsToCompare = objToCompare;
				objToCompare = objToCompare.next;
			}
			//Tail and head cases
			if (atTail){
				sorted.tail.next = objCurrent;
				sorted.tail = objCurrent;
				objCurrent.next = null;
			} else if (atHead)
			{
				objCurrent.next = sorted.head;
				sorted.head = objCurrent;
			} else {
				//If we are not at the tail or the head, we must be in the middle.
				objCurrent.next = objToCompare;
				trailsToCompare = objCurrent;
			}
			//Reset the sizes/ 
			sorted.size++;
			size--;			
		}
		//Sets the sorted list back to the original list. 
		head = sorted.head;
		size = sorted.size();
		tail = sorted.tail;
		return;		
	}


	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (! (o instanceof LinkedList)) return false;
		LinkedList<E> list2 = (LinkedList<E>) o;
		if (size != list2.size) return false;
		Node<E> p = head;
		Node<E> q = list2.head;
		while (p != null && q != null) {
			if (! p.getData().equals(q.getData())) return false;
			p = p.getNext();
			q = q.getNext();
		}
		return true;
	}
	
	@Override
	public String toString() {

		String result = "";
		Node<E> p = head;
		while (p != null) {
			result = result + "," + p.getData();
			p = p.getNext();
		}
		result = result.substring(1);
		return result;
	}

	/**
	 * Lab 1 Data Structures
	 * John Henry Mejia
	 * @param args
	 */
	public static void main(String[] args) {
	
		
		
		// Main Method: 
		// 1. create a LinkedList that can hold Integers
		// 2. read from System.in a value for n
		// 3. read n integers adding them to the LinkedList
		// 4. use the sort method to sort the integers
		// 5. print the first and last values in the list
		// 6. create a LinkedList that can hold Strings
		// 7. read from System.in a value for m
		// 8. read m Strings adding them to the LinkedList
		// 9. use the sort method to sort the Strings
		// 10.print the first and last Strings in the list
		Scanner s = new Scanner(System.in);
		
		
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		int c = s.nextInt();
		for (int i=0; i<c; i++) {
			list1.addLast(s.nextInt());
		}
		list1.sort();
		System.out.println("The first # is " + list1.first() + ". The last is " + list1.last());


		LinkedList<String> list2 = new LinkedList<String>();
		int d = s.nextInt();
		for (int i=0; i<d; i++) {
			list2.addLast(s.nextLine());
		}
		list2.sort();
		System.out.println("The first # is " + list2.first() + ". The last is " + list2.last());
		
	}


}
