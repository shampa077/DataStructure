package DataStructure;

import java.util.*;

public class Queue<T> {
	
	LinkedList<T> queue;
	
	public Queue()
	{
		queue= new LinkedList<T>();
	}
	
	public void enqueue(T element)
	{
		queue.addElement(element);
	}
	public ListElement<T> dequeue()
	{
		ListElement<T> ret=queue.deleteElementFront();;
		if (ret!=null)
			System.out.println(ret.toString());
		else
			System.out.println("Empty queue");
				return ret;
		
	}
	public void printQueue()
	{
		queue.printList();
	}
	public int getSize()
	{
		return queue.getSize();
	}
	public boolean isEmpty()
	{
		if (queue.getSize()>0)
			return false;
		else 
			return true;
	}

}
