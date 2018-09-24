public class LinkedStructureExample<E> {
    private E data;
    private LinkedStructureExample next;

    public LinkedStructureExample(E data, LinkedStructureExample next) {
        this.data = data;
        this.next = next;

        // top = null
        // size = 0
    }

    public LinkedStructureExample(E data) {
        this.data = data;
    }

    public LinkedStructureExample() {
        this(null, null);
    }

    boolean isEmpty() {
        // size == null
        return false;
    }

    void clear() {
        // top = null
        // size = null
    }

    void peek() {
        // if top != null return top.data
    }

    void push(E element) {
        // top = new node(element, top)

        // node = new LinkedStructureExample
        // node.data = element
        // node.next = top
        // top = node
        // size ++
    }

    void pop() {
        // if top != null
        // element.peek()
        // top = top.next
        // size - 1
        // return element
    }
}