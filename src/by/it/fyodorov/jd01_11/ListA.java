package by.it.fyodorov.jd01_11;

import java.util.*;

public class ListA<T> implements List<T> {

    T[] arr_value = (T[]) new Object[0];

    int size = 0;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < size; i++) {
            if (i > 0) sb.append(", ");
            sb.append(arr_value[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean add(T t) {
        if (arr_value.length == size) {
            arr_value = Arrays.copyOf(arr_value, size + 1);

        }
        arr_value[size] = t;
        size++;
        return true;
    }

    @Override
    public T remove(int index) {
        T temp = arr_value[index];
        if (index+1<=size) {

            for (int i = index+1; i < size; i++) {
                arr_value[i-1] = arr_value[i];
            }
            size = size > 0 ? size-1 : 0;
        }
        return temp;
    }

    @Override
    public T get(int index) {
        return arr_value[index];
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
    public boolean addAll(Collection<? extends T> c) {
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
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

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
