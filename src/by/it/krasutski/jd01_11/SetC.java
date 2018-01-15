package by.it.krasutski.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {

    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = size - 1; i >= 0; i--) {
            elements[i] = null;
            size--;
        }
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return true;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(T t) {
        if (contains(t)) return false;
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length + 1);
        }
        elements[size] = t;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    System.arraycopy(elements, i + 1, elements, i, size - 1 - i);
                    size--;
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    System.arraycopy(elements, i + 1, elements, i, size - 1 - i);
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean result = true;
        for (Object e : c) {
            if (!contains(e) && result) result = false;
        }
        return result;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean added = false;
        for (T e : c) {
            if (add(e) && !added) added = true;
        }
        return added;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean removed = false;
        for (Object e : c) {
            if (remove(e) && !removed) removed = true;
        }
        return removed;
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

    //fictive
    @Override
    public Spliterator<T> spliterator() {
        return null;
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
    public boolean retainAll(Collection<?> c) {
        return false;
    }
}
