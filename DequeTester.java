//Iris Tao
//APCS2 pd4
//HW #29: Stress is the Best
//2017-04-05

 
import java.util.Deque;
import java.util.LinkedList;


public class DequeTester{
 
        
    public static void main(String[] args){
	
        Deque<String> d = new LinkedList<String>();

	//============= addFirst
	//inserts an element at the front of the deque, return void
	//[] -> [apple]
	//[apple] -> [bigApple, apple]
	
	
	d.addFirst("apple");
	d.addFirst("bigApple");
	System.out.println("addFirst...\nreturn: \n" + "void");
	System.out.println( d + "\n");

	//============= addLast
	//inserts an element at the end of the deque, return void
	//[bigApple, apple] -> [bigApple, apple, smallApple]

	d.addLast("smallApple");
	System.out.println("addLast...\nreturn: \n" + "void");
	System.out.println( d + "\n");

	/*	//============= pollFirst
	//removes the first element of the deque - returns null if deque is empty
	//return the removed element
	//[bigApple, apple, smallApple] -> [apple, smallApple]
	//return: bigApple
	
	System.out.println("pollFirst...\nreturn: \n" + d.pollFirst());
	System.out.println( d+ "\n");
	*/


	//============= peekFirst
	//returns the first element of the deque - returns null if deque is empty
	//[apple, smallApple] -> [apple, smallApple]
	//return: apple

	System.out.println("peekFirst...\nreturn: \n" + d.peekFirst());
	System.out.println(d+ "\n");


	
	//============= contains
	//Returns true if this deque contains the specified element.
	//[apple, smallApple] -> [apple, smallApple]
	//d.contains("apple") --> return true
	//d.contains("pear") --> return false


	System.out.println("contains...");
	System.out.print("d.contains('apple') --> return ");
	System.out.println("contains...");
	System.out.print("d.contains('pear') --> return ");
	System.out.println(d.contains("pear"));
			  

	//============= add
	//Inserts the specified element into the queue represented by this deque (in other words, at the tail of this deque) if it is possible to do so immediately without violating capacity restrictions, returning true upon success and throwing an IllegalStateException if no space is currently available.
	//[apple, smallApple] -> [apple, smallAppl, hugeApple]
	//return: true

	System.out.println("\nadd...\nreturn: \n" + d.add("hugeApple"));
	System.out.println(d+ "\n");


	//============= removeFirstOccurrence(Object o)
	//Removes the first occurrence of the specified element from this deque.
	//d.removeFirstOccurrence("hugeApple");
	//[apple, smallApple, hugeApple] -> [apple, smallApple]
	//return: true

	System.out.println("\nremoveFirstOccurrence...\nreturn: \n" + 	d.removeFirstOccurrence("hugeApple"));
			   
	System.out.println(d+ "\n");
	

	
    }
}
