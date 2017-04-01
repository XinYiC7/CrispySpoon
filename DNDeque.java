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
    public int size()
    {
	return _size;
    }

    public boolean isEmpty()
    { 
	return _size == 0;
    }
    
    //Retrieves, but does not remove, the first element of this deque
    //returns null if this deque is empty.
    public T peek()
    {
	if (isEmpty()){
	    return null;
	}
	return peekFirst();
    }

    //Retrieves, but does not remove, the first element of this deque
    //returns null if this deque is empty.
    public T peekFirst()
    {
	return _front.getCargo();
    }

    //Retrieves, but does not remove, the last element of this deque
    //returns null if this deque is empty.
    public T peekLast()
    {
	if (isEmpty()){
	    return null;
	}
	return _end.getCargo();
    }

    //adding an element at the tail of this deque
    //returning true upon success 
    public boolean add( T x )
    {
	_end.setNext(new DLLNode(x, _end, null));
	_end = _end.getNext();
	_size += 1;
	return true;
    }

    //inserts the specified element at the front of the deque 
    public void addFirst( T x )
    {
	_front.setPrev(new DLLNode(x, null, _front));
	_front = _front.getPrev();
	_size += 1;
    }

    //inserts the specified element at the end of the deque
    public void addLast( T x )
    {
	_end.setNext(new DLLNode(x, _end, null));
	_end = _end.getNext();
	_size += 1;
    }

    //Retrieves and removes the first element of this deque.
    public T remove()
    {
	return removeLast();
    }

    //Retrieves and removes the first element of this deque.
    public T removeFirst()
    {
	T temp = _front.getCargo();
	_front.getNext().setPrev(null);
	_front = _front.getNext();
	_size -= 1;
	return temp;
    }

    //Retrieves and removes the last element of this deque.
    public T removeLast()
    {
	T temp = _end.getCargo();
	_end.getPrev().setNext(null);
	_end = _end.getPrev();
	_size -= 1;
	return temp;
    }

    //Returns true if this deque contains the specified element.
    public boolean contains( T x )
    {
	DLLNode temp = _front;
	for (int y = 0; y < _size; y += 1){
	    if (temp.getCargo().equals(x)){
		return true;
	    }
	    temp = temp.getNext();
	}
	return false;
    }

    //Removes the first occurrence of the specified element from this deque.
    public boolean remove( T x ){
	return removeFirstOccurrence(x);
    }

    //Removes the first occurrence of the specified element from this deque.
    public boolean removeFirstOccurrence( T x )
    {
	DLLNode temp = _front;
	for (int y = 0; y < _size; y += 1){
	    if (temp.getCargo().equals(x)){
		if (!temp.equals(_front)){
		    temp.getPrev().setNext(temp.getNext());
		}
		else if (!temp.equals(_end)){
		    temp.getNext().setPrev(temp.getPrev());
		}
		else {
		    _front = _end = null;
		}
		_size -= 1;
		return true;
	    }
	    temp = temp.getNext();
	}
	return false;
    }

    //Removes the last occurrence of the specified element from this deque.
    public boolean removeLastOccurrence( T x )
    {
	DLLNode temp = _end;
	for (int y = 0; y < _size; y += 1){
	    if (temp.getCargo().equals(x)){
		if (!temp.equals(_front)){
		    temp.getPrev().setNext(temp.getNext());
		}
		else if (!temp.equals(_end)){
		    temp.getNext().setPrev(temp.getPrev());
		}
		else {
		    _front = _end = null;
		}
		_size -= 1;
		return true;
	    }
	    temp = temp.getPrev();
	}
	return false;
    }

    //Pops an element from the stack represented by this deque.
    public T pop()
    {
	return removeFirst();
    }

    //Pushes an element at the head of this deque
    //returning true upon success 
    public void push( T x )
    {
	addFirst(x);
    }

    // print each node
    public String toString() 
    { 
	String retStr = "FRONT->";
	DLLNode<T> tmp = _front; //init tr
	while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
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
