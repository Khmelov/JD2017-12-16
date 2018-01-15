package by.it.patsko.jd01_11;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/*
TaskC.
Свой SetC. Напишите класс SetC<T>, который реализует toString()как в HashSet и 8 методов add(T e),remove(Object o),
contains(Object o), size(), isEmpty(), addAll(List<?> c), containsAll(Collection<?> c), removeAll(Collection<?> c) интерфейса Set<T>(остальные методы –заглушки).
 */
public class SetC<E> implements Set<E>{
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
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection collection) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean removeAll(Collection collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection collection) {
        return false;
    }

    @Override
    public boolean containsAll(Collection collection) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] objects) {
        return new Object[0];
    }
}
