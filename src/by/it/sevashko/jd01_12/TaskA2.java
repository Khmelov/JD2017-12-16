package by.it.sevashko.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {

    public static void main(String[] args) {
        HashSet<Integer> a = new HashSet<>(Arrays.asList(1,1,2,2,3,4,5,5));
        System.out.println(a);
        TreeSet<Integer> b = new TreeSet<>(Arrays.asList(1,14,8,2,5,1));
        System.out.println(b);
        Set<Integer> result = getCross(a, b);
        System.out.println(result);
        result = getUnion(a, b);
        System.out.println(result);
    }

    static Set<Integer> getCross(Set<Integer> a, Set<Integer> b){
        Set<Integer> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b){
        Set<Integer> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }
}
