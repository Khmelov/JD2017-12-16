package by.it.karpeichyk.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by user on 16.01.2018.
 */
public class TaskA2 {
    static Set<Integer> getUnit(Set<Integer>a,Set<Integer>b){
        Set<Integer> result=new HashSet<>(a);
        result.addAll(b);
        return result;

    }
    private  static Set<Integer>getCross(Set<Integer>a,Set<Integer>b){
        Set<Integer> result=new HashSet<>(a);
        result.retainAll(b);// метод все делает за нас

        return result;
    }

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(1,1,2,2,3,4,5,5));
        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(1,2,3,4,5,3,4,5,6));
        System.out.println(treeSet);
        System.out.println(hashSet);




    }
}
