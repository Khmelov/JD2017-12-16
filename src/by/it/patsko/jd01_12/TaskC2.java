package by.it.patsko.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/*
TaskC2.
Решить заново задачу TaskA2 для любого количества множеств на входе метода,
а также для различных типов данных в каждом из множеств (generics).
В main покажите работоспособность решения.
 */
class TaskC2<T> {
   /* Set<T> getUnion(Set<T>... a){
        Set<T> result=new HashSet<T>(a);
        for (Set<T> sets : a) {
            result.addAll(sets);
        }
//        result.addAll(b);
        return result;
    }
    *//*Set<T> getCross(Set<T> a,Set<T> b){
        Set<Integer> result=new HashSet<>(a);
        result.retainAll(b);
        *//**//*Iterator<Integer> it=result.iterator();
        while (it.hasNext())if(!b.contains(it.next()))it.remove();*//**//*
        return result;
    }*//*
    public static void main(String[] args) {
        Tas
        //Arrays.asList(1,2,3,4,5);//unmutable
        TreeSet<Integer> treeSet=new TreeSet<>(Arrays.asList(1,1,2,2,3,4,5,5));
        HashSet<Integer> hashSet=new HashSet<>(Arrays.asList(4,4,5,6,7));
//        list.add(1);error
        System.out.println(treeSet);
        System.out.println(hashSet);
        System.out.println(hashSet.getUnion(treeSet,hashSet));
//        System.out.println(getCross(treeSet,hashSet));
    }*/
}
