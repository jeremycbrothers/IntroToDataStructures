/**
 * @author: Jeremy Brothers
 * @version: 9/28/2018
 * Title: ArrayStack.java
 * Description: Implments the stack class. Creates a fixed array
 *              And examines if the array is a palindrome.
 */

public class ArrayStack<E> implements Stack<E> {

    private static final int DEFAULTSIZE = 10;
    private E[] data;
    private int top;
    
    /**
     * Constructor to initialize the array and member variables
     * @param size
     */
    public ArrayStack(int size) {
        @SuppressWarnings("unchecked")
        E[] newdata = (E[]) new Object[size];
        data = newdata;
        top = 0;
    }

    /**
     * No argument constructor that calls the constructor
     * with an int paramter.
     */
    public ArrayStack() {
        this(DEFAULTSIZE);
    }
    
    /**
     * Returns true if the top is equal. 
     * Else returns false.
     */
    public boolean isEmpty() {
        return top == 0;
    }
    
    // Gets the value stored in top.
    public int size() {
        return top;
    }

    // Returns the value of the first element of the array
    public E peek() {
        if (isEmpty()) throw new EmptyCollectionException("Stack");
        return data[top-1];
    }
    
    // Inserts a character of the string 'array' into the stack array.
    public boolean push(E element) {
        if (top == data.length) extendArray();
        data[top] = element;
        top++;
        return true;
    }
    
    // Returns the first value of the stack and 'removes it' from
    // the stack.
    public E pop() {
        E element = peek();
        top--;
        data[top] = null;
        return element;
    }
    
    // Clears the entire stack.
    public boolean clear() {
        while (!isEmpty())
            pop();
        return true;
    }

    @Override
    // Creates an intger value used for comparing objects more
    // quickly.
    public int hashCode() {
        int hash = 11;
        hash = 23 * hash + top;
        for (int i=0; i<top; i++)
            hash = 23 * hash + data[i].hashCode();
        return hash;
    }

    @Override
    /**
     * Takes an object parameter and casts it into an ArrayStack
     * Returns true of the objects match. Else returns flase.
     */
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        @SuppressWarnings("unchecked")
        ArrayStack<E> stack = (ArrayStack<E>) obj;
        if (top != stack.top) return false;
        for (int i=0; i<top; i++) {
            if (!data[i].equals(stack.data[i]))
                return false;
        }
        return true;
    }
    
    @Override
    // Takes the private members of the class and formats them 
    // into a string.
    public String toString() {
        if (top == 0) return "[ ]";
        StringBuilder sb = new StringBuilder("[");
        sb.append(data[top-1]);
        for (int i=top-2; i>=0; i--)
            sb.append(", " + data[i].toString());
        return sb.append("]").toString();
    }

    // Creates a new stack that is twice the size of the original.
    private void extendArray() {
        @SuppressWarnings("unchecked")
        E[] newdata = (E[]) new Object[data.length*2];
        for (int i=0; i<top; i++)
            newdata[i] = data[i];
        data = newdata;
    }
}