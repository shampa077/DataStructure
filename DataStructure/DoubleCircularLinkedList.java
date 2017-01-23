package DataStructure;
import java.util.*;
import DataStructure.ListElement;

public class DoubleCircularLinkedList<T>
{
	public ListElement<T> head;

	public DoubleCircularLinkedList()
	{
		head=null;
	}
	public void addElement(T val)
	{
		if (head==null)
		{
			head=new ListElement<T>(val);
			head.setNext(head);
			head.setPrevious(head);
		}
		else
		{
			ListElement<T> temp=head;
			while(temp.next()!=head)
			{
				temp=temp.next();
	
			}
			ListElement<T> newItem =new ListElement<T>(val);
			newItem.setNext(head);
			temp.setNext(newItem);
			newItem.setPrevious(temp);
			head.setPrevious(newItem);
			
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
			head.setNext(head);
			head.setPrevious(head);
		}
		else
		{
			ListElement<T> temp=head;
			if (compare(head.value(),val,type)>0)
			{
				ListElement<T> newItem =new ListElement<T>(val);
				newItem.setPrevious(head.previous());
				newItem.setNext(head);
				head.previous().setNext(newItem);
				head.setPrevious(newItem);
				head=newItem;
			}
			else
			{
				while(temp.next()!=head && compare(temp.next().value(),val,type)<=0)
				{
					temp=temp.next();
	
				}
				
				ListElement<T> newItem =new ListElement<T>(val);
				
				
				newItem.setNext(temp.next());
				newItem.setPrevious(temp);
				temp.setNext(newItem);
				if (newItem.next()==head)
				{
					head.setPrevious(newItem);
				}
				
				
			}
			
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
				
				head.next().setPrevious(head.previous());
				head=head.next();
				System.out.println("Item at front deleted");
			}
			else
			{
				
				while(temp.next()!=head && temp.next().value()!=val)
				{
					temp=temp.next();
				}
				if (temp.next()==head)
				{
					if (temp.value()!=val)
					{
						System.out.println("not found");
						
					}
					
				}
				else if (temp.next().value()==val)
				{
					(temp.next().next()).setPrevious(temp);
					temp.setNext(temp.next().next());
					//temp.previous().setNext(elem);
					System.out.println("Item deleted");
				}
				
			
			}
		}
	}
	public void printList()
	{
		ListElement<T> temp=head;
		System.out.println("List Content");
		if (temp==null)
			System.out.println("empty list");
		else if (head.next()==head)
		{
			System.out.print(head.previous().toString()+"<-"+head.toString()+"->"+head.next().toString()+"\n");
		}
		else{
			do
			{
				System.out.print(temp.previous().toString()+"<-"+temp.toString()+"->"+temp.next().toString()+"\t");
				temp=temp.next();

			}while (temp.next()!=head);
			System.out.print(temp.previous().toString()+"<-"+temp.toString()+"->"+temp.next().toString()+"\t");
		
			System.out.println("end");
		}
	}
	
}

