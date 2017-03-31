public class DNDeque<T> implements Deque<T> {

    private DLLNode<T> _front, _end;
    private int _size;

    // default constructor creates an empty deque
    public DNDeque()
    {
	_front = _end = null;
	_size = 0;
    }

    //return the number of elements in the deque
    public int size();

    //Retrieves, but does not remove, the first element of this deque
    //returns null if this deque is empty.
    public T peek();

    //Retrieves, but does not remove, the first element of this deque
    //returns null if this deque is empty.
    public T peekFirst();

    //Retrieves, but does not remove, the last element of this deque
    //returns null if this deque is empty.
    public T peekLast();

    //adding an element at the tail of this deque
    //returning true upon success 
    public boolean add( T x );

    //inserts the specified element at the front of the deque 
    public void addFirst( T x );

    //inserts the specified element at the end of the deque
    public void addLast( T x );

    //Retrieves and removes the first element of this deque.
    public T remove();

    //Retrieves and removes the first element of this deque.
    public T removeFirst();

    //Retrieves and removes the last element of this deque.
    public T removeLast();

    //Returns true if this deque contains the specified element.
    public boolean contains( T x );

    //Removes the first occurrence of the specified element from this deque.
    public boolean remove( T x );

    //Removes the first occurrence of the specified element from this deque.
    public boolean removeFirstOccurrence( T x );

    //Removes the last occurrence of the specified element from this deque.
    public boolean removeLastOccurrence( T x );

    //Pops an element from the stack represented by this deque.
    public T pop();

    //Pushes an element at the head of this deque
    //returning true upon success 
    public void push( T x );

    public boolean isEmpty()
    { 
	return _size == 0;
    }

    // print each node
    public String toString() 
    { 
	String retStr = "FRONT->";
	DLLNode<T> tmp = _front; //init tr
	while( tmp != null ) {
	    retStr += tmp.getValue() + "->";
	    tmp = tmp.getNext();
	}
	retStr += "END";
	return retStr;
    }
    
    //main method for testing
    public static void main( String[] args ) 
    {

    }//end main
    
}//end class DNDeque                                                                                 
