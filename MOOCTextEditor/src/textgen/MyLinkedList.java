package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E>
{
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList()
	{
		// TODO: Implement this method
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		size = 0;
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element) 
	{
		// TODO: Implement this method
//		try
//		{
			if (element == null)
			{
				throw new NullPointerException("Your adding element is invalid!");
			}
			LLNode<E> newNode = new LLNode<E>(element);
			(tail.prev).next = newNode;
			newNode.next = tail;
			newNode.prev = tail.prev;
			tail.prev = newNode;
			this.size += 1;
//		}
//		catch (NullPointerException e)
//		{
//			System.out.println(e);
//			return false;
//		}
		
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
//		try
//		{
			if (index < 0 || index >= this.size)
			{
//				System.out.println("index = " + index + "; size = " + this.size);
				throw new IndexOutOfBoundsException();
			}
			
			LLNode<E> curNode = this.head;
			for (int i = 0; i <= index; i++)
			{
				curNode = curNode.next;
			}
			
			return curNode.data;
//		}
//		catch (IndexOutOfBoundsException e)
//		{
////			System.out.println(e);
//			return null;
//		}
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if (element == null)
		{
			throw new NullPointerException("Your adding element is invalid!");
		}
//		System.out.println("Now size = " + this.size);
//		System.out.println("element: " + element);
//		System.out.println("index: " + index);
//		System.out.println("size: " + this.size);
		if (index < 0 || index > this.size)
		{
//			System.out.println("index = " + index + "; size = " + this.size);
			throw new IndexOutOfBoundsException();
		}
		
		LLNode<E> newNode = new LLNode<E>(element);
		LLNode<E> curNode = this.head;
		for (int i = 0; i <= index; i++)
		{
			curNode = curNode.next;
		}
		
		(curNode.prev).next = newNode;
		newNode.next = curNode;
		newNode.prev = curNode.prev;
		curNode.prev = newNode;
		this.size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if (index < 0 || index >= this.size())
		{
			throw new IndexOutOfBoundsException();
		}
		
		LLNode<E> curNode = this.head;
		for (int i = 0; i <= index; i++)
		{
			curNode = curNode.next;
		}
		
		(curNode.prev).next = curNode.next;
		(curNode.next).prev = curNode.prev;
		
		E thisData = curNode.data;
		this.size -= 1;
//		curNode = null;
		return thisData;
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
		// TODO: Implement this method
		if (index < 0 || index >= this.size())
		{
			throw new IndexOutOfBoundsException();
		}
		
		LLNode<E> curNode = head;
		for (int i = 0; i <= index; i++)
		{
			curNode = curNode.next;
		}
		
		return (curNode.set(element));
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
	
	public E set(E e)
	{
		if (e == null)
		{
			throw new NullPointerException();
		}
		
		E prevData = this.data;
		this.data = e;
		
		return prevData;
	}
	
	public LLNode()
	{
		this.data = null;
		this.prev = null;
		this.next = null;
	}

}
