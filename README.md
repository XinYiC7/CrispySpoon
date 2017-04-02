# CrispySpoon
Deque methods that we implemented:
size(),
peek(),
peekFirst(),
peekLast(),
add( T x ),
addFirst( T x ),
addLast( T x ),
remove(),
removeFirst(),
removeLast(),
contains( T x ),
remove( T x ),
removeFirstOccurrence( T x ),
removeLastOccurrence( T x ),
pop(),
push( T x ).

For our implementation of the class Deque, we decided to implement all the methods listed in the Java API except element(), getFirst(), getLast(), offer() methods, poll() methods. 

We didn't implement those methods because we feel that they are quite redundant. We can combine it with the other similar methods. We implemented peek() methods instead of get() methods, add() methods instead of offer() methods, and remove() methods instead of poll() methods.

We also implemented pop() and push() because it's interesting to see how we can use deque as a stack.
