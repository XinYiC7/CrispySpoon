# CrispySpoon

## Method Selection: List

```
1. size()
2. peek()
3. peekFirst()
4. peekLast()
5. add( T x )
6. addFirst( T x )
7. addLast( T x )
8. remove()
9. removeFirst()
10. removeLast()
11. contains( T x )
12. remove( T x )
13. removeFirstOccurrence( T x )
14. removeLastOccurrence( T x )
15. pop()
16. push( T x )
```

## Method Selection: Explanation
For our implementation of the class Deque, we decided to implement all the methods listed in the Java API except element(), getFirst(), getLast(), offer() methods, poll() methods. 

We didn't implement those methods because we feel that they are quite redundant. We can combine it with the other similar methods. We implemented peek() methods instead of get() methods, add() methods instead of offer() methods, and remove() methods instead of poll() methods.

We also implemented pop() and push() because it's interesting to see how we can use deque as a stack.

## Architecture
We chose to use doubly-linked node-based architecture because we don't need to traverse through the list when we want to remove or add in the front or end. Doubly-linked node-based architecture would be more efficient and should have a faster runtime than array-based or ArrayList-based.
