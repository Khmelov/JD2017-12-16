package by.it.kozlov.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskC2 {
    private static Set<Integer> getUnion(Set<Integer>... nums) {
        Set<Integer> result = new HashSet<>();
        for (Set<Integer> i : nums) {
            result.addAll(i);
        }
        return result;
    }

    private static Set<Integer> getCross(Set<Integer>... nums) {
        Set<Integer> result = new HashSet<>();
        result.addAll(nums[0]);
        for (Set<Integer> i : nums) {
            result.retainAll(i);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeSet<Integer> one = new TreeSet<>(Arrays.asList(1, 1, 2, 2, 3, 4, 5, 5));
        HashSet<Integer> two = new HashSet<>(Arrays.asList(4, 4, 5, 6, 7, 8));
        HashSet<Integer> three = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8, 9, 12, 25, 18, 35));
        System.out.println(getUnion(one, two, three));
        System.out.println(getCross(one, two, three));
    }
}
