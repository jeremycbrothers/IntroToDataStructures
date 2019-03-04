public class ArrayQueue<E> implements Queue<E> {
    private static final int DEFAULTSIZE = 10;
    private E[] data;
    private int front;
    private int rear;
    private int size;
    
    public Arrayqueue(int size) {
        @SuppressWarnings("unchecked")
        E[] newData (E[]) new Object[size];
        data = newData;
        front = 0;
        rear = 0;
        size = 0;
    }
    
    public ArrayQueue() { this(DEFAULTSIZE); }
    
    public int size() { return size; }
    
    private boolean isFull() { return size == data.length; }
    
    public E peek() {
        if(isEmpty()) throw new EmptyCollectionException("Queue");
        
        return data[front];
    }
    
    public boolean enqueue(E element) {
        if(isFull()) extendArray();
        data[rear] = element;
        rear = (rear + 1) % data.length;
        size++;
        return true;
    }
    
    public E dequeue() {
        E element = peek();
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return element;
    }
    
    @Override
    public int hashCode() {
        int hash = 13;
        hash = 29 * hash + size;
        for (int i = 0; i < size; i++) {
            hash = 29 * hash + data[(front + i) % data.length].hashCode();
        }
        return hash;
    }
    
    @Override
    public String toString() {
        if(size() == 0) return "[ ]";
        StringBuilder sb = new StringBuilder("[");
        sb.append(data[front]);
        for (int i = 0; i < size; i++) {
            sb.append(", " + data[(front + 1) % data.length]);
        }
        return sb.append("]").toString();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        
        @SuppressWarnings("unchcecked");
        ArrayQueue<E> queue = (ArrayQueue<E>)obj;
        if(size != queue.size) return false;
        
        int index1, index2;
        for(int i = 0; i < size; i++) {
            index1 = (front + i) % data.length;
            index2 = (queue.front + i) % queue.data.length;
            if(!data[index1].equals(queue.data[index2])) {
                return false;
            }
        }
        return true;
    }
}