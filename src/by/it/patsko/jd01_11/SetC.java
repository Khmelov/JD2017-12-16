package by.it.patsko.jd01_11;

import java.util.*;

/*
TaskC.
Свой SetC. Напишите класс SetC<T>, который реализует toString()как в HashSet и 8 методов add(T e),remove(Object o),
contains(Object o), size(), isEmpty(), addAll(List<?> c), containsAll(Collection<?> c), removeAll(Collection<?> c) интерфейса Set<T>(остальные методы –заглушки).
 */
public class SetC<E> implements Set<E> {
//    ListB<E> listB;
    HashMap<Object, E> map = new HashMap<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SetC<?> setC = (SetC<?>) o;
        HashSet<String> s=new HashSet<>();
        return Objects.equals(map, setC.map);
    }

    @Override
    public int hashCode() {
        return Objects.hash(map);
    }

    @Override
    public boolean contains(Object o) {
//        return  map.containsKey(o);
        for (Map.Entry<Object, E> entry : this.map.entrySet()) {
            if (entry.getValue() == null) {
                if (o == null) return true;
            } else if (entry.getValue().equals(o)) return true;
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection collection) {
        for (Object aCollection : collection)
            return this.contains(aCollection);
        return false;
    }

    @Override
    public boolean add(Object o) {
        if (!this.contains(o)) {
            if (o == null) map.put(-1, (E) o);
            else map.put(o.hashCode(), (E) o);
            return true;
        } else return false;
    }

    @Override
    public boolean addAll(Collection collection) {
        boolean check = false;
//        collection
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            E e = (E) iterator.next();
//            if(!this.contains(iterator.next())){this.add(iterator.next());check=true;}
            if (this.add(e)) check = true;
        }
        return check;
    }

    @Override
    public java.lang.String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<Object, E>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next().getValue());
            if (iterator.hasNext()) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public int size() {
        return this.map.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }


    @Override
    public Iterator iterator() {
        return this.map.keySet().iterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }


    @Override
    public boolean remove(Object o) {

        if (this.contains(o)) {
            if (o == null) this.map.remove(-1);
            else this.map.remove(o.hashCode());
            return true;
        } else return false;
    }


    @Override
    public void clear() {
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
    }

    @Override
    public boolean removeAll(Collection collection) {
        boolean check = false;
        for (Object obj : collection) {
            if (this.contains(obj)) {
                this.remove(obj);
                check = true;
            }
        }
        return check;
    }

    @Override
    public boolean retainAll(Collection collection) {
        return false;
    }


    @Override
    public Object[] toArray(Object[] objects) {
        return new Object[0];
    }
}
