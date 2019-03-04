public class ArrayList<E> implements List<E> {
    private E[] data;
    private int size;
    
    public ArrayList(){
        data = new ArrayList<E>();
        size = 0;
    }
    public int size(){ return size; }
    
    public E get(int index) { 
        if (index < size && index >= 0)
            return data[index];
    }
    
    public E set(int index, E element) { 
        E oldElement = get(index);
        data[index] = element;
        return oldElement;
    }
    
    public boolean contains(E element) { return indexOf(element) != 0; }
    
    public int indexOf(E element) { 
        for (int i = 0; i < size - 1; i++) {
            if(data[i] == element) { return i };
        }
    
        return -1;
    } 
    public boolean add(E element) { return false; }
    public boolean add(int index, E element) { return false; }
    public E remove(int index, E element) { return E; }
    public boolean remove(E element) { return false; }
}