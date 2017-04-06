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
	//if adding first node
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
    /******************************************
    If the Deque is empty, the add method is used.
    Else, the front gets a node before it and that node is made the new front.
     ******************************************/
    public void addFirst( T x )
    {
	//if adding first node
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
    /******************************************
    If the Deque is empty, the add method is used.
    Else, the end node gets a node after and that node is the new end.
     ******************************************/
    public void addLast( T x )
    {
	//if adding first node
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
    /******************************************
    If the Deque is empty, nothing is returned.
    Else, if there is only one node left, front and end are set to null.
    Else, removeLast().
     ******************************************/
    public T remove()
    {
	//if theres nothing to remove
	if (isEmpty()){
	    return null;
	}
	//if theres only one node left
	if ( size() == 1 ){
	    T temp = _front.getCargo();
	    _front = _end = null;
	    _size --;
	    return temp;
	}
	return removeLast();
    }

    //Retrieves and removes the first element of this deque.
    /******************************************
    If empty, return null.
    Else, if one is left, remove().
    Else, Set front to the node after the front and set prev of that to null.
     ******************************************/
    public T removeFirst()
    {
	//if theres nothing to remove
	if (isEmpty()){
	    return null;
	}
	//if theres only one node left
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
    /******************************************
    If empty, return null.
    Else, if one is left, remove().
    Else, Set end to the node before the end and set next of that to null.
    ******************************************/
    public T removeLast()
    {
	//if theres nothing to remove
	if (isEmpty()){
	    return null;
	}
	//if theres only one node left
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
    /******************************************
    Traverses the string. If the cargo matches the search value, true is
    returned. After the whole Deque is traversed without returning true, false
    is returned.
     ******************************************/
    public boolean contains( T x )
    {
	DLLNode<T> temp = _front;

	//traverse through the list of nodes
	for (int y = 0; y < _size; y ++){
	    //if matches
	    if (temp.getCargo().equals(x)){
		return true;
	    }
	    temp = temp.getNext();
	}
	return false;
    }

    //Removes the first occurrence of the specified element from this deque.
    /******************************************
    If no x, false is returned, as well as an error message. First occurrance
    is then removed.
     ******************************************/
    public boolean remove( T x ){
	//if x is not in the list 
	if ( !contains(x) ){
	    System.out.println("the deque does not contain "+ x + " .........");
	    return false;
	}
	return removeFirstOccurrence(x);
    }

    //Removes the first occurrence of the specified element from this deque.
    /******************************************
    If x is not there, false is returned. Else the Deque is traversed from the
    front to end. If the item is found at the front, removeFirst() is used,
    else if at the end, removeEnd() is used, or the prev and next of the node
    are connected, circumventing the node.
     ******************************************/
    public boolean removeFirstOccurrence( T x )
    {
	//if x is not in the list 
	if ( !contains(x) ){
	    System.out.println("the deque does not contain "+ x + " .........");
	    return false;
	}
	
	DLLNode<T> temp = _front;
	for (int y = 0; y < _size; y ++){
	    if (temp.getCargo().equals(x)){
		//if matches with the first node
		if (temp.equals(_front)){
		    removeFirst();
		}
		//if matches with the last node
		else if (temp.equals(_end)){
		    removeLast();
		}
		//if matches with a node in between
		else {
		    temp.getPrev().setNext(temp.getNext());
		    temp.getNext().setPrev(temp.getPrev());
		    _size --;
		}
		return true;
	    }
	    temp = temp.getNext();
	}
	return false;
    }

    //Removes the last occurrence of the specified element from this deque.
    /******************************************
    If x is not there, false is returned. Else the Deque is traversed from the
    end to front. If the item is found at the front, removeFirst() is used,
    else if at the end, removeEnd() is used, or the prev and next of the node
    are connected, circumventing the node.
     ******************************************/
    public boolean removeLastOccurrence( T x )
    {
	//if x is not in the list 
	if ( !contains(x) ){
	    System.out.println("the deque does not contain "+ x + " .........");
	    return false;
	}
	
	DLLNode<T> temp = _end;
	for (int y = 0; y < _size; y ++){
	    if (temp.getCargo().equals(x)){
		//if matches with the first node
		if (temp.equals(_front)){
		    removeFirst();
		}
		//if matches with the last node
		else if (temp.equals(_end)){
		    removeLast();
		}
		//if matches with a node in between 
		else {
		    temp.getNext().setPrev(temp.getPrev());
		    temp.getPrev().setNext(temp.getNext());
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

    //print each node
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
