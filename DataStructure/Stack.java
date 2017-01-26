package DataStructure;
import java.util.*;

public class Stack<T> {
	
	LinkedList<T> stack;
	
	public Stack()
	{
		stack= new LinkedList<T>();
	}
	
	public void push(T element)
	{
		stack.addElementFront(element);
	}
	public ListElement<T> pop()
	{
		ListElement<T> ret=stack.deleteElementFront();;
		if (ret!=null)
			System.out.println(ret.toString());
		else
			System.out.println("Empty stack");
				return ret;
		
	}
	public void printStack()
	{
		stack.printList();
	}
	public int getSize()
	{
		return stack.getSize();
	}
	public boolean isEmpty()
	{
		if (stack.getSize()>0)
			return false;
		else 
			return true;
	}

}
