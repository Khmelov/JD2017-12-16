package by.it.vshelukhin.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskC2 {

    public <T> Set<T> getUnion (Set<T>[] arr){
        if (arr.length == 0) return null;
        Set<T> result = new HashSet<>(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            result.addAll(arr[i]);
        }
        return result;
    }

    public <T> Set<T> getCross (Set<T>[] arr){
        if (arr.length == 0) return null;
        Set<T> result = new HashSet<>(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            result.retainAll(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {

        Set<Integer> hs1 = new HashSet<>(Arrays.asList(1,1,2,3,5,8,8,9));
        Set<Integer> hs2 = new HashSet<>(Arrays.asList(0,1,8,3,5,15,8,4));
        Set<Integer> hs3 = new HashSet<>(Arrays.asList(-54,30));
        Set<Double> ts1 = new TreeSet<>(Arrays.asList(2.0,7.1,4.4));
        Set<Double> ts2 = new TreeSet<>(Arrays.asList(2.0,7.1,4.4));
        Set<Double> ts3 = new TreeSet<>(Arrays.asList(5.0,6.1,4.4));
        Set<Double> ts4 = new TreeSet<>(Arrays.asList(2.0,8.6,4.4));
        TaskC2 taskC2 = new TaskC2();
        System.out.println(taskC2.getUnion(new Set[]{hs1, hs2, hs3}));
        System.out.println(taskC2.getCross(new Set[]{ts1, ts2, ts3, ts4}));
    }
}
