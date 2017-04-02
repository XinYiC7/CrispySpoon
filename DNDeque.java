// CrispySpoon
// Xin Yi Chen, Joanna Zhou
// APCS2 pd4
// LAB #02: All Hands on Deque!
// 2017-4-1

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
	if( isEmpty() ){
	    _front = _end = new DLLNode<T>(x, _end, null);
	    _size ++;
	}
	else{
	    addLast(x);
	}
	return true;
    }

    //inserts the specified element at the front of the deque 
    public void addFirst( T x )
    {
	if( isEmpty() ){
	    add(x);
	}
	else{
	    _front.setPrev(new DLLNode<T>(x, null, _front));
	    _front = _front.getPrev();
	    _size ++;
	}
    }

    //inserts the specified element at the end of the deque
    public void addLast( T x )
    {
	if( isEmpty() ){
	    add(x);
	}
	else{
	    _end.setNext(new DLLNode<T>(x, _end, null));
	    _end = _end.getNext();
	    _size ++;
	}
    }

    //Retrieves and removes the first element of this deque.
    public T remove()
    {
	if (isEmpty()){
	    return null;
	}
	if ( size() == 1 ){
	    T temp = _front.getCargo();
	    _front = _end = null;
	    _size --;
	    return temp;
	}
	return removeLast();
    }

    //Retrieves and removes the first element of this deque.
    public T removeFirst()
    {
	if (isEmpty()){
	    return null;
	}
	if ( size() == 1 ){
	    return remove();
	}
	T temp = _front.getCargo();
	_front.getNext().setPrev(null);
	_front = _front.getNext();
	_size --;
	return temp;
    }

    //Retrieves and removes the last element of this deque.
    public T removeLast()
    {
	if (isEmpty()){
	    return null;
	}
	if ( size() == 1 ){
	    return remove();
	}
	T temp = _end.getCargo();
	_end.getPrev().setNext(null);
	_end = _end.getPrev();
	_size --;
	return temp;
    }

    //Returns true if this deque contains the specified element.
    public boolean contains( T x )
    {
	DLLNode<T> temp = _front;
	for (int y = 0; y < _size; y ++){
	    if (temp.getCargo().equals(x)){
		return true;
	    }
	    temp = temp.getNext();
	}
	return false;
    }

    //Removes the first occurrence of the specified element from this deque.
    public boolean remove( T x ){
	if ( !contains(x) ){
	    System.out.println("the deque does not contain "+ x + " .........");
	    return false;
	}
	return removeFirstOccurrence(x);
    }

    //Removes the first occurrence of the specified element from this deque.
    public boolean removeFirstOccurrence( T x )
    {
	if ( !contains(x) ){
	    System.out.println("the deque does not contain "+ x + " .........");
	    return false;
	}
	DLLNode<T> temp = _front;
	for (int y = 0; y < _size; y ++){
	    if (temp.getCargo().equals(x)){
		if (temp.equals(_front)){
		    removeFirst();
		}
		else if (temp.equals(_end)){
		    removeLast();
		}
		else {
		    temp.getPrev().setNext(temp.getNext());
		    _size --;
		}
		return true;
	    }
	    temp = temp.getNext();
	}
	return false;
    }

    //Removes the last occurrence of the specified element from this deque.
    public boolean removeLastOccurrence( T x )
    {
	if ( !contains(x) ){
	    System.out.println("the deque does not contain "+ x + " .........");
	    return false;
	}
	DLLNode<T> temp = _end;
	for (int y = 0; y < _size; y ++){
	    if (temp.getCargo().equals(x)){
		if (temp.equals(_front)){
		    removeFirst();
		}
		else if (temp.equals(_end)){
		    removeLast();
		}
		else {
		    temp.getNext().setPrev(temp.getPrev());
		    _size --;
		}
		return true;
	    }
	    temp = temp.getPrev();
	}
	return false;
    }

    //Pops an element from the stack represented by this deque.
    public T pop()
    {
	if( isEmpty() ){
	    return null;
	}
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
	DNDeque<String> spoon = new DNDeque<String>();

	System.out.println("testing add....");

	spoon.addFirst("I");
	System.out.println(spoon + "   size:" + spoon.size());
	spoon.addLast("am");
	System.out.println(spoon + "   size:" + spoon.size());
	spoon.add("hungry");
	System.out.println(spoon + "   size:" + spoon.size());

	System.out.println("===============================================");
	
	System.out.println("testing remove....");
	
	spoon.remove();
	System.out.println(spoon + "   size:" + spoon.size());
	spoon.removeFirst();
	System.out.println(spoon + "   size:" + spoon.size());
	spoon.removeLast();
	System.out.println(spoon + "   size:" + spoon.size());
	spoon.remove();
	System.out.println(spoon + "   size:" + spoon.size());

	System.out.println("===============================================");
	
	System.out.println("testing remove(Object)....");

	spoon.addFirst("I");
	spoon.addLast("am");
	spoon.add("hungry");
	spoon.addFirst("hi");
	spoon.addLast("am");
	spoon.add("hungry");
	
	spoon.removeFirstOccurrence("am");
	System.out.println(spoon + "   size:" + spoon.size());
	spoon.removeLastOccurrence("hungry");
	System.out.println(spoon + "   size:" + spoon.size());
	spoon.remove("I");
	System.out.println(spoon + "   size:" + spoon.size());
	spoon.remove("meow");
	System.out.println(spoon + "   size:" + spoon.size());


	System.out.println("===============================================");

	System.out.println("testing pop and push....");

	spoon.push("byeee");
	System.out.println(spoon + "   size:" + spoon.size());
	System.out.println(spoon.pop()+ "   size:" + spoon.size() );
	System.out.println(spoon.pop()+ "   size:" + spoon.size() );
    }//end main
    
}//end class DNDeque                                                                                 
