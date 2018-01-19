package by.it.sendetskaya.jd01_12;

import java.util.*;


//TaskC2.РешитьзановозадачуTaskA2длялюбогоколичествамножествнавходеметода,
// атакжедля различных типов данных в каждом из множеств (generics). В main
// покажите работоспособность решения.
public class TaskC2{

    //объединение множеств
    private <T> Set<T> getUnion(List<T> var)
    {
        return new HashSet<>(var);
    }

    //пересечение множеств
    private <T> Set<T>getCross(List<T> t,int firstLength)
    {
        Set<T>b=new HashSet<>(t.subList(0,firstLength));
        Set<T>result=new HashSet<>(t.subList(firstLength,t.size()));

            b.retainAll(result);

        return b;
    }


    public static void main(String[] args) {
        TaskC2 taskC2=new TaskC2();

        TreeSet<Integer> treeSet=new TreeSet<>(Arrays.asList(1,2,3,4,5, 1,2,2,3,4,8));
        HashSet<Integer> hashSet=new HashSet<>(Arrays.asList(1,2,3,4,5, 4,5,6));
        System.out.println(treeSet);
        System.out.println(hashSet);
        List<Integer> list=new ArrayList<>();
        int length;
        list.addAll(treeSet);
        length=list.size();
        list.addAll(hashSet);
        System.out.println(taskC2.getUnion(list));
        System.out.println(taskC2.getCross(list,length));
    }

}
