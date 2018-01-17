package by.it.vshelukhin.jd01_12;

import java.util.*;

public class TaskA2 {

    public static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b){
        Set<Integer> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }

    public static Set<Integer> getCross (Set<Integer> a, Set<Integer> b){
        Set<Integer> result = new HashSet<>(a);
        result.retainAll(b);
        return  result;
    }

    public static void main(String[] args) {

        Set<Integer> hs = new HashSet<>(Arrays.asList(1,1,2,3,5,8,8,9));
        Set<Integer> ts = new TreeSet<>(Arrays.asList(2,7,4,8,6,5,9,9));
        System.out.println(hs);
        System.out.println(ts);
        System.out.println();
        System.out.println(getUnion(hs, ts));
        System.out.println(getCross(ts, hs));
        System.out.println();
        System.out.println(hs);
        System.out.println(ts);
    }
}
