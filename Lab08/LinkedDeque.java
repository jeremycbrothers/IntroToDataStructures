import java.util.NoSuchElementException;

public class LinkedDeque<E> implements Deque<E> {

  private static class DNode<E> {
    private E data;
    private DNode<E> previous;
    private DNode<E> next;

    public DNode(E data, DNode<E> previous, DNode<E> next) {
      this.data = data;
      this.previous = previous;
      this.next = next;
    }

    public DNode(E data) {
      this(data, null, null);
    }

    public DNode() {
      this(null, null, null);
    }

    private void setNext(DNode<E> node) {
      next = node;
    }

    private void setPrevious(DNode<E> previous) { 
      this.previous = previous;
    }

    private void setData(E data) { this.data = data; }

    private DNode<E> getNext() { return next; }

    private DNode<E> getPrevious() { return previous; }

    private E getData() { return data; }
  }

  private DNode<E> head;
  private DNode<E> tail;
  private int size = 0;

// Creates both a dummy head and a dummy tail.
  public LinkedDeque() {
    head = new DNode<>();
    tail = new DNode<>();
    head.next = tail;
    tail.previous = head;
  }

  public boolean isEmpty() {
    return head.next == tail;
  }

  public void clear() {
    head.next = tail;
    tail.previous = head;
  }

// Complete the following methods:
  public void addFirst(E element) {
    if(element == null)
      throw new NullPointerException("element is null");

    System.out.println("adding to head: " + element);
    
    DNode<E> toAdd = head;
    DNode<E> before = new DNode<E>(element);
    head.previous = toAdd;
    toAdd.next = head;
    before.next = toAdd;
    toAdd.previous = before;
    size++;
  }

  public E removeFirst() {
    return null;
  }

  public E getFirst() {
    return null;
  }

  public boolean removeFirstOccurrence(Object obj) {

    return false;
  }

  public void addLast(E element) {
    System.out.println("adding to tail: " + element);
    DNode<E> node = new DNode<E>(element);
    if(isEmpty())
      tail = node;
    else  
      head.setNext(node);
    head = node;
    size++;
  }

  public E removeLast() {

    return null;
  }

  public E getLast() {

    return null;
  }

  public boolean removeLastOccurrence(Object obj) {

    return false;
  }

  public void printForward() {
    System.out.println("The deque printed forward:");
    DNode current = head.next;
    System.out.println(current.getData());
    // while (current != tail) {
    //   System.out.println(current.data);
    //   current = current.next;
    // }
    // System.out.println();
  }

  public void printBackward() {
    System.out.println("The deque printed backward:");
    DNode current = tail.previous;
    while (current != head) {
      System.out.println(current.data);
      current = current.previous;
    }
    System.out.println();
  }
}