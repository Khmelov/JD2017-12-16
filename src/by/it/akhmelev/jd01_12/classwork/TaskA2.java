package by.it.akhmelev.jd01_12.classwork;

import java.util.*;

public class TaskA2 {

    private static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b){
        Set<Integer> result=new HashSet<>(a);
        result.addAll(b);
        return result;
    }

    private static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result=new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    public static void main(String[] args) {
        TreeSet<Integer> treeSet=new TreeSet<>(Arrays.asList(1,1,2,2,3,4,5,5));
        HashSet<Integer> hashSet=new HashSet<>(Arrays.asList(4,4,5,6,7,8));
        System.out.println(treeSet);
        System.out.println(hashSet);
        System.out.println(getUnion(treeSet,hashSet));
        System.out.println(getCross(treeSet,hashSet));

    }

}
