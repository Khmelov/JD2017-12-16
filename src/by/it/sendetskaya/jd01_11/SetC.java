package by.it.sendetskaya.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {

    private int size=0;
    private T[] elements=(T[])new Object[]{};

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SetC<?> setC = (SetC<?>) o;
        return size == setC.size &&
                Arrays.equals(elements, setC.elements);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(elements);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append('{');
        HashSet<T> hSet=new HashSet<>();

        for (int i = 0; i < size; i++) {
            hSet.add(elements[i]);
        }
        for (int i = 0; i < hSet.size(); i++) {
            if(i>0)
                sb.append(", ");
                sb.append(hSet);
        }
        sb.append('}');
        return hSet.toString();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(Object o) {

        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return true;
            }
        }
        else {
            for (T el : elements) {
                if (o.equals(el))
                    return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(T t) {
        for (T el:elements) {
            if (contains(t))
                return false;
        }
        if (size==elements.length)
            elements=Arrays.copyOf(elements,elements.length+1);
        elements[size++]=t;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int indexDel=0;
        boolean flag=false;
        if (size==elements.length) {
            for (int i = 0; i < size; i++) {
                if (((T) o)==(T)elements[i]) {
                    indexDel = i;
                    flag = true;
                }
            }
            if (flag) {
                for (int i = indexDel + 1; i < size; i++) {
                    elements[i - 1] = elements[i];
                }
                elements = Arrays.copyOf(elements, elements.length - 1);
                size = size > 0 ? size - 1 : 0;
                return true;
            }
        }
                return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        T [] elementsCont=(T[])c.toArray();
        boolean flag=false;
        int count=0;
        if (size==elements.length)
        {
            for (T el:elementsCont) {

                for (int i = 0; i < size; i++)
                 {
                    if ((T)el==elements[i])
                        flag=true;
                }
            }
//            if (count==elementsCont.length)
//                flag=true;
        }
        return flag;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        T[] elementsC= (T[]) c.toArray();
        boolean flag=false;

        if(size==elements.length) {
            for (T el: elementsC) {
                if(add(el))  flag=true;
            }
        }
        size=elements.length;
        return flag;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        T [] elementsDel=(T[])c.toArray();
        boolean flag=false;
        if (size==elements.length)
        {
            for (T el:elementsDel) {
               if(remove(el))
                   flag=true;
            }
        }
        return flag;
    }

    @Override
    public void clear() {
        for (int i = elements.length - 1; i >= 0; i--) {
            remove(elements[i]);
            size = size > 0 ? size - 1 : 0;
        }
    }



//not realised

    @Override
    public boolean retainAll(Collection<?> c) {
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

}
