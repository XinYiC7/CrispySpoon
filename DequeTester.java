/*James Zhang
APCS2 pd4
HW #29: Stress is the Best
Due W 2017-04-05, 8:00am, EST.*/

public class DequeTester{

   
    public static void main(String args[]) {
	DNDeque<Integer> deque = new DNDeque<Integer>();


	for (int i = 0; i < 10; i++){
	    deque.addFirst(i);
	}	
	System.out.println("Starts as: " + deque);
	System.out.println(" returning size (should be 10):" + deque.size());
	/*
	
	//removes all elements to test size() and peek at 0	
	for (int x = 0; x < 10; x++){
	    deque.removeFirst();
	}
	System.out.println("Should be empty: " + deque);
		System.out.println(" returning size (should be 0):" + deque.size());
		System.out.println(" peeking front (should be error):" + deque.peekFirst());
	System.out.println(" peeking back (should be error):" + deque.peekLast());
	*/
	//System.out.println("removing front (should be an error):" + deque.removeFirst(1000));
	//System.out.println("removing back (should be an error):" + deque.removeLast(1000));

	
        //cycles elements as if iterating
	for (int i = 0 ; i < 7; i++){
	    int temp = deque.peekFirst();
	    deque.removeFirst();
	    deque.addLast(temp);
	}
	System.out.println(deque);
	
	

    }

}
