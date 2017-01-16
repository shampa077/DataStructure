import java.util.*;


import DataStructure.LinkedList;
import DataStructure.GenericClass;

class Name extends GenericClass{
	int age;
	double salary;
	String name;
	public Name(String name, int age, double salary)
	{
		this.name=name;
		while (age <0 || salary<0)
		{
			System.out.println("Invalid value");
			if(age<0)
			{
				System.out.println("Enter valid age value");
				age=Main.scan.nextInt();
				
			}
			if(salary<0)
			{
				System.out.println("Enter valid salary value");
				salary=Main.scan.nextDouble();
				
			}
		}
		
		this.age=age;
		this.salary=salary;
	}
	public int getAge()
	{
		return age;
	}
	public double getSalary()
	{
		return salary;
	}
	public String getName()
	{
		return name;
	}
 public int compareObject( GenericClass othern)
	{
	 	Name other=(Name) othern;
		if ( (age> other.age && salary>other.salary) || (age> other.age && salary==other.salary) || (age ==other.age && salary> other.salary))
			return 10;
		else if ( (age< other.age && salary<other.salary) || (age< other.age && salary==other.salary) || (age ==other.age && salary< other.salary))
			return -10;
		else 
			return 0;
		
	}
 public String toString()
 {
	return "Name:"+ name+" Age:"+ age+ " salary:"+salary;
	 
 }
}


public class Main {
	
	public static Scanner scan=new Scanner(System.in);
	public static void main(String args[])
	{
		System.out.println("Testing Linked List with Integer");
		LinkedList <Integer> l= new LinkedList<Integer>();
		int choice=-1;
		char type;
		System.out.println("Enter choice 1. ascending 2. descending");
		while (true)
		{
			choice=Main.scan.nextInt();
			if (choice==1)
			{
			type='a';
			break;
			}
			else
			{
			type='d';
			break;
			}
		}
		l.addElementSorted(25,type);
		l.addElementSorted(5,type);
		
		l.printList();
		for (int i=1;i<=5;i++)
		{
			l.addElementSorted(i*33,type);
		}
		l.addElementSorted(15,type);
		l.addElementSorted(35,type);
		l.printList();
		l.deleteElement(66);
		l.printList();
		l.deleteElement(222);
		l.deleteElement(5);
		l.printList();

		
		System.out.println("-------------------------------------------");
		System.out.println("Testing Linked List with Any Object");
		LinkedList <Name> l1= new LinkedList<Name>();
		
		l1.addElementSorted(new Name("Mr A", 12, 20),type);
		l1.addElementSorted(new Name("Mr B", 5, 2),type);
		l1.printList();
		l1.addElementSorted(new Name("Mr A1", 1212, 9020),type);
		l1.printList();
		l1.addElementSorted(new Name("Mr B1", 5, -20),type);
		l1.printList();
		
	}

}
