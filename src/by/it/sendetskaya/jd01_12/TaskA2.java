package by.it.sendetskaya.jd01_12;

import java.util.*;

public class TaskA2 {

    //объединение множеств
    private static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b)
    {
        Set<Integer> result=new HashSet<>(a);

        result.addAll(b);
        return result;
    }

    //пересечение множеств
    private static Set<Integer>getCross(Set<Integer> a, Set<Integer> b)
    {
        Set<Integer>result=new HashSet<>(a);
        result.retainAll(b);
//        Iterator<Integer>iterator=result.iterator();
//        while (iterator.hasNext())
//        {
//            if (!b.contains(iterator.next()))
//                iterator.remove();
//        }
        return result;
    }


    public static void main(String[] args) {

        TreeSet<Integer> treeSet=new TreeSet<>(Arrays.asList(1,2,3,4,5, 1,2,2,3,4,8));
        HashSet<Integer> hashSet=new HashSet<>(Arrays.asList(1,2,3,4,5, 4,5,6));
        System.out.println(treeSet);
        System.out.println(hashSet);
        System.out.println(getUnion(treeSet,hashSet));
        System.out.println(getCross(treeSet,hashSet));
    }
}
