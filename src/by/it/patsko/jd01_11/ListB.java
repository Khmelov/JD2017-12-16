package by.it.patsko.jd01_11;


import java.util.*;

/*
TaskB.
Свой ListB.
Напишите класс ListB<T>,
который реализует toString()и 6 методов add(T e),remove(int index), get(int index), set(int index,T e),
add(int index, T e), addAll(List<?> c) интерфейса List<T>(остальные методы –заглушки).
 */
public class ListB<T> implements List<T> {
    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

    @Override
    public boolean add(T t) {
        if (size == elements.length)
            elements = Arrays.copyOf(elements, elements.length + 1);
        elements[size++] = t;
        return true;
    }

    @Override
    public void add(int index, T element) {
        if (index >= 0) {
            T[] temp;
            if (index < size) {
                temp = (T[]) new Object[++size];
                for (int i = 0; i < temp.length; i++) {
                    if (i < index) temp[i] = elements[i];
                    if (i > index) temp[i] = elements[i - 1];
                }
                temp[index] = element;
                elements = temp;
            } else if (index > size) {
                size = index + 1;
                temp = (T[]) new Object[size];
                for (int i = 0; i < temp.length; i++) {
                    if (i < elements.length) temp[i] = elements[i];
                    else if (i > index) temp[i] = null;
                    else temp[index] = element;
                }
                elements = temp;
            } else this.add(element);
        }
    }

    @Override
    public T remove(int index) {
        T deleted = elements[index];
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
//        System.arraycopy(elements, index + 1, elements, index + 1 - 1, size - (index + 1));
        size = (size > 0) ? size - 1 : 0;
        return deleted;
    }


    @Override
    public T get(int index) {
        return elements[index];
    }

    @Override
    public T set(int index, T element) {
        if (index >= 0 && index < size) {
            T deleted = elements[index];
            elements[index] = element;
            return deleted;
        }
        return null;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (!c.isEmpty()) {
            T[] arr = (T[])c.toArray();
//            System.out.println("Arr= "+Arrays.toString(arr)+"\n"+"Arr.length="+arr.length);
            this.size+=c.size();
            int oldLength=elements.length;
            elements=Arrays.copyOf(elements,elements.length+c.size());
            System.arraycopy(arr,0,elements,oldLength,arr.length);

           /* this.size+=c.size();
            T[] temp = (T[]) new Object[this.size];

            int i=0;
            while (i<this.elements.length){
                temp[i]=this.elements[i];
                i++;
            }
            while (i<temp.length){
                temp[i]=arr[i-this.elements.length];
                i++;
            }
            elements=temp;*/
            return  true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            if (i > 0) sb.append(", ");
            sb.append(elements[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    //fictiv

    @Override
    public boolean remove(Object o) {
        return false;
    }

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
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] arr=new Object[this.size];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=this.get(i);
        }
        return arr;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
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
