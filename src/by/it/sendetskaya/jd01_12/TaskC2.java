package by.it.sendetskaya.jd01_12;

import java.util.*;


//TaskC2.РешитьзановозадачуTaskA2длялюбогоколичествамножествнавходеметода,
// атакжедля различных типов данных в каждом из множеств (generics). В main
// покажите работоспособность решения.
public class TaskC2{

    //объединение множеств
    private <T> Set<T> getUnion(Set<T>... var)
    {
        Set<T> result=new HashSet<>();

        for (Set<T> args:var) {
            result.addAll(args);
        }
        return result;
    }

    //пересечение множеств
    private <T> Set<T>getCross(Set<T>... var)
    {
        Set<T> result=new HashSet<>((Set<T>)var[0]);

        for (Set<T> args:var) {
            result.retainAll(args);
        }
        return result;
    }


    public static void main(String[] args) {
        TaskC2 taskC2=new TaskC2();

        TreeSet<Integer> treeSet=new TreeSet<>(Arrays.asList(1,2,3,4,5, 1,2,2,3,4,8));
        HashSet<Integer> hashSet=new HashSet<>(Arrays.asList(1,2,3,4,5, 4,5,6));
        HashSet<Integer> linkSet=new LinkedHashSet<>(Arrays.asList(0,8,9,1,2,3,4,5, 4,5,6));
        System.out.println(treeSet);
        System.out.println(hashSet);
        System.out.println(linkSet);

        System.out.println(taskC2.getUnion(treeSet,hashSet,linkSet));
       System.out.println(taskC2.getCross(treeSet,hashSet,linkSet));
    }

}
