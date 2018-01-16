package by.it.viktorbrui.jd01_12;

import java.util.*;

public class TaskA2 {
    static Set<Integer> getUnion (Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<>(a);
        result.addAll(b);
        return a;
    }
    private static Set<Integer> getCross (Set<Integer>a,Set<Integer>b){
        Set<Integer> result=new HashSet<>(a);
        result.retainAll(b);
       // Iterator<Integer> it = result.iterator();
        //while (it.hasNext()){
          //  if (b.contains(it.next()));
            //it.remove();

       // }
                return result;
    }
    public static void main(String[] args) {

        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(1,2,3,4,5));
        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(3,6,4,2,6,7));
        System.out.println(getUnion(treeSet,hashSet));
        System.out.println(getCross(treeSet,hashSet));
    }
}
