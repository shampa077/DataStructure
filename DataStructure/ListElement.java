package DataStructure;

public class ListElement<T> {
public ListElement( T value ) { data = value; }
public ListElement<T> next() { return next; }
public ListElement<T> previous() { return previous; }
public T value() { return data; }
public void setNext( ListElement<T> elem ) { next = elem; }
public void setPrevious( ListElement<T> elem ) { previous = elem; }
public void setValue( T value ) { data = value; }

public String toString()
{
	return data.toString();
}
private ListElement<T> next;
private ListElement<T> previous;
private T data;
}