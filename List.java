public interface List<E> {
    default boolean isEmpty() { return size() == 0; }
    int size();
    E get(int index);
    E set(int index, E element);
    boolean contains(E element);
    int indexOf(E element);
    boolean add(E element);
    boolean add(int index, E element);
    E remove(int index, E element);
    boolean remove(E element);
    default boolean clear() { 
        while(!isEmpty())
            remove(element);
    }
}