package by.it.pozdeev.jd01_11;
import java.util.*;

public class ListB<T> implements List<T> {


    private T[] elements = (T[]) new Object[]{};
    private int size = 0;


    @Override
    public T remove(int index) {
        T deleted = elements[index];
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        size = size > 0 ? size - 1 : 0;
        elements=Arrays.copyOf(elements,size);

        return deleted;
    }

    @Override
    public T set(int index, T element) {
        T deleted = elements[index];
        elements[index] = element;
        return deleted;
    }

    @Override
    public T get(int index) {
        return elements[index];
    }

    @Override
    public void add(int index, T element) {
        if (size == elements.length) elements = Arrays.copyOf(elements, elements.length + 1);
        size++;
        for (int i = elements.length - 1; i > index; i--) elements[i] = elements[i - 1];
        elements[index] = element;
        return;
    }




    @Override
    public boolean add(T t) {
        if (size==elements.length) elements=Arrays.copyOf(elements,elements.length+1);
        elements[size++] = t;
        return true;
    }


    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (!c.isEmpty()) {
            T[] ext = (T[])c.toArray();
            int len=elements.length;
            elements=Arrays.copyOf(elements,elements.length+ext.length);
            System.arraycopy(ext,0,elements,len,ext.length);
            size=elements.length;
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }


    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size; i++) {
            if (i>0) sb.append(", ");
            sb.append(elements[i]);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
