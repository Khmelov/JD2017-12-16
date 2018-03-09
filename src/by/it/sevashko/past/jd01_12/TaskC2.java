package by.it.sevashko.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskC2 {

    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>(Arrays.asList(1,1,2,2,3,4,5,5));
        System.out.println(a);
        Set<Integer> b = new HashSet<>(Arrays.asList(7,7,1,2,9,5));
        System.out.println(b);
        Set<Integer> result = getCross(a, b);
        System.out.println(result);
        result = getUnion(a, b);
        System.out.println(result);
    }

    @SafeVarargs
    private static <T> Set<T> getCross(Set<? extends T> a, Set<? extends T>... args){
        Set<T> result = new HashSet<>(a);
        for (Set<? extends T> set : args) {
            result.retainAll(set);
        }
        return result;
    }

    @SafeVarargs
    private static <T> Set<T> getUnion(Set<? extends T> a, Set<? extends T>... args){
        Set<T> result = new HashSet<>(a);
        for (Set<? extends T> set : args) {
            result.addAll(set);
        }
        return result;
    }
}
