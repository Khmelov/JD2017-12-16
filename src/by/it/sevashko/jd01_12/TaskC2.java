package by.it.sevashko.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskC2 {

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

    static Set<Integer> getCross(Set<Integer> a, Set<Integer>... args){
        Set<Integer> result = new HashSet<>(a);
        for (Set<Integer> set : args) {
            result.retainAll(set);
        }
        return result;
    }

    static <T> Set<T> getUnion(Set<T> a, Set<? extends T>... args){
        Set<T> result = new HashSet<>(a);
        for (Set<? extends T> set : args) {
            result.addAll(set);
        }
        return result;
    }
}
