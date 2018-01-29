package by.it.pozdeev.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {

    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

    @Override
    public boolean add(T t) {
        if (size == elements.length) elements = Arrays.copyOf(elements, elements.length + 1);
        elements[size++] = t;
        return true;
    }


    @Override
    public boolean addAll(Collection<? extends T> c) {
        T[] ext = (T[]) c.toArray();
        int len = elements.length;
        elements = Arrays.copyOf(elements, elements.length + ext.length);
        System.arraycopy(ext, 0, elements, len, ext.length);
        size = elements.length;
        return true;

    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals(o)) return true;
        }
        return false;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size; i++) {
            if (i > 0) sb.append(", ");
            sb.append(elements[i]);
        }
        sb.append(']');
        return sb.toString();
    }


    @Override
    public int size() {
        return size;
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
    public boolean isEmpty() {
        if (size == 0) return true;
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
    public boolean containsAll(Collection<?> c) {
        if (!c.isEmpty()) {
            boolean flag = false;
            T[] ext = (T[]) c.toArray();
            for (int i = 0; i < elements.length; i++) {
                flag = false;
                for (int j = 0; j < ext.length; j++) {
                    if (elements[i].equals(ext[j])) flag = true;
                }
                if (!flag) return false;
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (!c.isEmpty()) {
            T[] ext = (T[]) c.toArray();
            for (int j = 0; j < ext.length; j++) {
                this.remove(ext[j]);
            }
        }

        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}