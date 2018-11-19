/**
 * @author: Jeremy Brothers
 * @version: 9/28/2018
 * Title: LinkedStack.java
 * Description: Similiar to the ArrayStack except it uses a linked
 *              list structure. The linked list allows for
 *              a stack whose size can be determined at run time.
 */

public class LinkedStack<E> implements Stack<E> {

    /**
     * An inner class that creates the node in the link stack.
     * @param <E> A Template type determined when the object is 
     *            created.
     */
    private static class Node<E> {
        private E data;
        private Node<E> next;
        
        // Initializes the private member variables of the class.
        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
        
        // A copy constructor that calls the first constructor
        // with the data parameter and null. Indicating that there
        // is no next node.
        public Node(E data) {
            this(data, null);
        }
        
        // Copy constructor that creates a node with null values
        public Node() {
            this(null, null);
        }
    }
    
    private Node<E> top;
    private int size;
    
    // Constructor to initialize private members
    public LinkedStack() {
        top = null;
        size = 0;
    }
    
    // Returns true is size equals zero.
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Returns the size of the stack
    public int size() {
        return size;
    }
    
    // Returns the value or object at the top of the stack
    public E peek() {
        if (isEmpty()) throw new EmptyCollectionException("Stack");
        return top.data;        
    }
    
    // Pushes a value or object to the top of the stack
    public boolean push(E element) {
        top = new Node<>(element, top);
        size++;
        return true;
    }
    
    // Removes the top value or object of the stack and returns
    // the value.
    public E pop() {
        E element = peek();
        top = top.next;
        size--;
        return element;
    }
    
    // clears the stack.
    public boolean clear() {
        top = null;
        size = 0;
        return true;
    }

    @Override
    // Used for comparing two LinkedStact objects more quickly
    public int hashCode() {
        int hash = 11;
        hash = 29 * hash + size;
        Node<E> current = top;
        while (current != null) {
            hash = 29 * hash + current.data.hashCode();
            current = current.next;
        }
        return hash;
    }

    @Override
    // Returns true if the objects match. False otherwise.
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        @SuppressWarnings("unchecked")
        LinkedStack<E> stack = (LinkedStack<E>) obj;
        if (size != stack.size) return false;
        Node<E> current = top;
        Node<E> otherCurrent = stack.top;
        // Checks every node and if the nodes don't match
        // return false
        while (current != null) {
            if (!current.data.equals(otherCurrent.data))
                return false;
            current = current.next;
            otherCurrent = otherCurrent.next;
        }
        return true;
    }
    
    @Override
    // Formats the private members into a string.
    public String toString() {
        if (top == null) return "[ ]";
        StringBuilder sb = new StringBuilder("[");
        sb.append(top.data);
        Node<E> current = top.next;
        while (current != null) {
            sb.append(", " + current.data);
            current = current.next;
        }
        return sb.append("]").toString();
    }
}