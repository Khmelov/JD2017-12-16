package by.it.sevashko.jd01_11;

import java.util.*;
import java.util.function.UnaryOperator;

public class ListB<T> implements List<T>{

    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

    @Override
    public boolean add(T t) {
        if (size == elements.length)
            elements=Arrays.copyOf(elements,elements.length+1);
        elements[size] = t;
        size++;
        return true;
    }

    @Override
    public T remove(int index) {
            T deleted = elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size = size - 1;
        return deleted;
    }

    @Override
    public T get(int index) {
        return elements[index];
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append('[');
        for (int i = 0; i < size; i++) {
            if (i > 0) result.append(", ");
            result.append(elements[i]);
        }
        result.append(']');
        return result.toString();
    }

    @Override
    public T set(int index, T element) {
        T currentElement = elements[index];
        elements[index] = element;
        return currentElement;
    }

    @Override
    public void add(int index, T element) {
        if (size==elements.length)
            elements=Arrays.copyOf(elements,elements.length+1);
        for (int i = size; i > index ; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean addAll(List<? extends T> c) {
        if (size + c.size() >= elements.length)
            elements = Arrays.copyOf(elements,elements.length + c.size());
        for (int i = 0; i < c.size(); i++) {
            elements[size] =  c.get(i);
            size++;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (size + c.size() >= elements.length)
            elements = Arrays.copyOf(elements,elements.length + c.size());
        Iterator<? extends T> iterator = c.iterator();
        while (iterator.hasNext()){
            elements[size] = iterator.next();
            size++;
        }
        return true;
    }




    @Override
    public void replaceAll(UnaryOperator<T> operator) {

    }

    @Override
    public void sort(Comparator<? super T> c) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
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
    public boolean addAll(int index, Collection<? extends T> c) {
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
