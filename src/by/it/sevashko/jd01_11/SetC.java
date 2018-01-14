package by.it.sevashko.jd01_11;

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
    public boolean contains(Object o) {
        if (o == null){
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return true;
            }
        } else{
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(T t) {
        if (contains(t)) return false;
        checkSize();
        elements[size] = t;
        size++;
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean changed = false;
        for (T e : c){
            if (add(e) && !changed) changed = true;
        }
        return changed;
    }

    //because there is no Iterator
    public boolean addAll(SetC<? extends T> c) {
        Object[] o = c.toArray();
        boolean changed = false;
        for (Object e : o){
            if (add((T)e) && !changed) changed = true;
        }
        return changed;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean result = true;
        for (Object e : c){
            if (!contains(e) && result) result = false;
        }
        return result;
    }

    //because there is no Iterator
    public boolean containsAll(SetC<?> c) {
        Object[] o = c.toArray();
        boolean result = true;
        for (Object e : o){
            if (!contains(e) && result) result = false;
        }
        return result;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null){
            for (int i = 0; i < size; i++){
                if (elements[i] == null){
                    System.arraycopy(elements, i + 1, elements, i, size - 1 - i);
                    size--;
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++){
                if (o.equals(elements[i])){
                    System.arraycopy(elements, i + 1, elements, i, size - 1 - i);
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean changed = false;
        for (Object e : c){
            if (remove(e) && !changed) changed = true;
        }
        return changed;
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

    private void checkSize(){
        if (size ==  elements.length){
            elements= Arrays.copyOf(elements, elements.length + 1);
        }
    }

    @Override
    public Object[] toArray() {
        return elements;
    }

    @Override
    public void clear() {
        for (int i = size - 1; i >= 0; i--) {
            elements[i] = null;
            size--;
        }
    }





    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

        @Override
    public Iterator<T> iterator() {
        return null;
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
