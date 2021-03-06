package DataStructure;
import java.util.*;

public class LinkedList<T>
{
	public ListElement<T> head;
	public LinkedList()
	{
		head=null;
	}
	public void addElement(T val) // add element in rear
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
	public void addElementFront(T val) //add element in front
	{
		if (head==null)
		{
			head=new ListElement<T>(val);
			head.setNext(null);
		}
		else
		{
			ListElement<T> temp=head;
			ListElement<T> newItem =new ListElement<T>(val);
			newItem.setNext(temp);
			head=newItem;
			
		}
	}
	public int compare(T one, T two)
	{
		if (one instanceof Integer)
		{
			Integer first=(Integer) one;
			Integer second=(Integer) two;
			
			return first.compareTo(second);
			
		}
		else if (one instanceof String)
		{
			String first=(String) one;
			String second=(String) two;
			return first.compareTo(second);
		}
		else if (one instanceof GenericClass)
		{
			GenericClass first=(GenericClass) one;
			GenericClass second=(GenericClass) two;
			return first.compareObject(second);
			
		}
		else
		{
			return -1;
		}
		
		
	}
	
	public int compare(T one, T two,char order)
	{
		if (order=='d')
		{
			T temp=one;
			one=two;
			two=temp;
		}
				
		if (one instanceof Integer)
		{
			Integer first=(Integer) one;
			Integer second=(Integer) two;
			
			return first.compareTo(second);
			
		}
		else if (one instanceof String)
		{
			String first=(String) one;
			String second=(String) two;
			return first.compareTo(second);
		}
		else if (one instanceof GenericClass)
		{
			GenericClass first=(GenericClass) one;
			GenericClass second=(GenericClass) two;
			return first.compareObject(second);
			
		}
		else
		{
			return -1;
		}
		
		
	}
	public void addElementSorted(T val, char type)
	{
		if (head==null)
		{
			head=new ListElement<T>(val);
			head.setNext(null);
		}
		else
		{
			ListElement<T> temp=head;
			if (compare(head.value(),val,type)>0)
			{
				ListElement<T> newItem =new ListElement<T>(val);
				newItem.setNext(temp);
				head=newItem;
			}
			else
			{
				while(temp.next()!=null  && compare(temp.next().value(),val,type)<=0)
				{
					temp=temp.next();
	
				}
				
				ListElement<T> newItem =new ListElement<T>(val);
				newItem.setNext(temp.next());
				temp.setNext(newItem);
				
			}
			
		}
	}
	public ListElement<T> deleteElementFront()
	{
		if (head==null)
		{
			System.out.println("Empty list");
			return null;
		}
		else
		{
			ListElement<T> temp=head;
			head=head.next();
			System.out.println("Item at front deleted");
			return temp;
		}
		
	}
	public ListElement<T> deleteElementRear()
	{
		if (head==null)
		{
			System.out.println("Empty list");
			return null;
		}
		else if (head.next()==null)
		{
			ListElement<T> temp=head;
			head=null;
			System.out.println("List is now empty");
			return temp;
		}
		else
		{
			ListElement<T> temp=head;
			while(temp.next().next()!=null)
			{
				temp=temp.next();
			}
			ListElement<T> temp1=temp.next();
			temp.setNext(null);
			return temp1;
			
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
	public int getSize()
	{
		ListElement<T> temp=head;
		int s=0;
		
		while(temp!=null)
		{
			s++;
			temp=temp.next();
		}
		return s;
		
	}
	public void printList()
	{
		ListElement<T> temp=head;
		System.out.println("List Content");
		while(temp!=null)
		{
			System.out.print(temp.toString()+"\t");
			temp=temp.next();

		}
		System.out.println("end");
	}
	
}

