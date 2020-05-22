package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size =0;
		head = new LLNode <E> (null);
		tail = new LLNode <E> (null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		//return false;
		if(element == null) {
			throw new NullPointerException();
		}
		
		LLNode <E> n = new LLNode<E>(element);
		if(size == 0) {
			n.next = head.next;
			n.prev = tail.prev;
			head.next = n;
			tail.prev = n;
		}
		
		else {
			n.prev = tail.prev;
			tail.prev = n;
			n.prev.next = n;
			n.next = tail;
		}
		size ++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		//return null;
		if(index > this.size-1 || index <0) {
			throw new IndexOutOfBoundsException();
		}
		
		LLNode<E> temp = new LLNode<E>(null);
		temp= this.head;
		
		for(int i = 0; i <= index ; i++) {
			temp = temp.next;
			
		}
		
		return temp.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		
		if(index > this.size-1 || index <0) {
			
			//throw new IndexOutOfBoundsException();
		}
		if(element == null) {
			throw new NullPointerException();
		}
		
		LLNode<E> temp = new LLNode<E>(null);
		LLNode<E> n = new LLNode<E>(element);
		
		temp = head.next;
		for(int i = 0; i < index ; i++) {
			//System.out.println("i :" + i+" temp.data: " + temp.data);
			temp = temp.next;
		}
		//System.out.print("index :" + index+" temp.data add: " + temp.data);
		n.prev = temp.prev;
		n.next = n.prev.next;
		n.next.prev = n;
		n.prev.next = n;

	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		
		return this.size+1;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		if(index < 0) {
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> temp = new LLNode<E>(null);
		temp = head.next;
		for(int i = 0; i < index ; i++) {
			temp = temp.next;
		}
		temp.next.prev = temp.prev;
		temp.prev.next = temp.next;
		size--;
		return temp.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		if(element == null ) {
			throw new NullPointerException();
		}
		

		if(index > this.size-1 || index <0) {
		throw new IndexOutOfBoundsException();
    	}
		
		LLNode<E> temp = new LLNode<E>(null);
		temp = head.next;
		for(int i = 0; i < index ; i++) {
			temp = temp.next;
		}
		 E n = temp.data;
		 temp.data = element;
		 return n;
		
		// TODO: Implement this method
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode() {
		this.next = null;
		this.data = null;
		this.prev = null;
	}
	
	/*
	 * You need to check for nextNode.prev also... For now let it stay
	 * public LLNode(E data, LLNode<E> prevNode) {
	 
		this(data);
		this.next = prevNode.next;
		prevNode.next = this;
	}*/

}
