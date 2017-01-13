package DataStructure;
import java.util.*;

class ListElement<T> {
public ListElement( T value ) { data = value; }
public ListElement<T> next() { return next; }
public T value() { return data; }
public void setNext( ListElement<T> elem ) { next = elem; }
public void setValue( T value ) { data = value; }
public String toString()
{
	return data.toString();
}
private ListElement<T> next;
private T data;
}
public class LinkedList<T>
{
	public ListElement<T> head;
	public LinkedList()
	{
		head=null;
	}
	public void addElement(T val)
	{
		if (head==null)
		{
			head=new ListElement<T>(val);
			head.setNext(null);
		}
		else
		{
			ListElement<T> temp=head;
			while(temp.next()!=null)
			{
				temp=temp.next();
	
			}
			ListElement<T> newItem =new ListElement<T>(val);
			newItem.setNext(null);
			temp.setNext(newItem);
			
		}
	}
	public void deleteElement(T val)
	{
		if (head==null)
		{
			System.out.println("Empty list");
		}
		else
		{
			ListElement<T> temp=head;
		    if (head.value()==val)
			{
				head=head.next();
				System.out.println("Item at front deleted");
			}
			else
			{
				
				while(temp.next()!=null && temp.next().value()!=val)
				{
					temp=temp.next();
				}
				if (temp.next()==null)
				{
					if (temp.value()!=val)
					{
						System.out.println("not found");
						
					}
					
				}
				else if (temp.next().value()==val)
				{
					temp.setNext(temp.next().next());
					System.out.println("Item deleted");
				}
				
			
			}
		}
	}
	public void printList()
	{
		ListElement<T> temp=head;
		while(temp!=null)
		{
			System.out.print(temp.toString()+"\t");
			temp=temp.next();

		}
		System.out.println("end");
	}
	
}

