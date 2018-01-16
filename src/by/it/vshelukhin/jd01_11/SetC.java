package by.it.vshelukhin.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {

    T[] arr_value = (T[]) new Object[0];

    private int size = 0;

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

        if (contains(t)) return false;

        int ind_insert = size;
        if (t != null) {
            for (int i = 0; i < size; i++) {
                if (arr_value[i] == null) break;
                if (t.hashCode() < arr_value[i].hashCode()) {
                    ind_insert = i;
                    break;
                }
            }
        }
        if (ind_insert < size) {
            arr_value = Arrays.copyOf(arr_value, size + 1);
            for (int i = size; i > ind_insert; i--) {
                arr_value[i] = arr_value[i - 1];
            }
            arr_value[ind_insert] = t;
            size++;
        }
        else if (ind_insert == size) {
            arr_value = Arrays.copyOf(arr_value, size + 1);
            arr_value[ind_insert] = t;
            size++;
        }
        return true;
    }



    @Override
    public boolean remove(Object o) {

        if (!contains(o)) return false;
        int ind_remove = -1;
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (arr_value[i] == null) ind_remove = i;
            }
        }
        else {
            for (int i = 0; i < size; i++) {
                if (arr_value[i].hashCode() == o.hashCode()) {
                    ind_remove = i;
                    break;
                }
            }
        }
            for (int i = ind_remove + 1; i < size; i++) {
                arr_value[i - 1] = arr_value[i];
            }
            size--;
        return true;
        }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (arr_value[i] == null) return true;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(arr_value[i])) return true;
            }
        }
        return false;
    }

//    @Override
//    public boolean contains(Object o) {
//        if (o == null) {
//            for (int i = 0; i < size; i++) {
//                if (arr_value[i] == null) return true;
//            }
//        }
//
//        for (int i = 0; i < size; i++) {
//            if (arr_value[i] == null) continue;
//            if (arr_value[i].hashCode() == o.hashCode()) return true;
//        }
//        return false;
//    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) return true;
        else return false;
    }

    @Override
     public boolean addAll(Collection<? extends T> c) {
        int size_temp = size;
                for (T o : c) {
                    this.add(o);
                    }
                return size_temp != size;
            }



    @Override
    public boolean containsAll(Collection<?> c) {

        for (Object o : c) {
            if (!contains(o)) return false;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int size_temp = size;
        for (Object o : c) {
            this.remove(o);
        }
        return size_temp != size;
    }

    @Override
    public void clear() {
        size = 0;

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
