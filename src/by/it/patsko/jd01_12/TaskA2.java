package by.it.patsko.jd01_12;


import java.util.*;

class TaskA2 {
    static Set<Integer> getUnion(Set<Integer> a,Set<Integer> b){
        Set<Integer> result=new HashSet<>(a);
        result.addAll(b);
        return result;
    }
    static Set<Integer> getCross(Set<Integer> a,Set<Integer> b){
        Set<Integer> result=new HashSet<>(a);
        result.retainAll(b);
        /*Iterator<Integer> it=result.iterator();
        while (it.hasNext())if(!b.contains(it.next()))it.remove();*/
        return result;
    }
    public static void main(String[] args) {
        //Arrays.asList(1,2,3,4,5);//unmutable
        TreeSet<Integer> treeSet=new TreeSet<>(Arrays.asList(1,1,2,2,3,4,5,5));
        HashSet<Integer> hashSet=new HashSet<>(Arrays.asList(4,4,5,6,7));
//        list.add(1);error
        System.out.println(treeSet);
        System.out.println(hashSet);
        System.out.println(getUnion(treeSet,hashSet));
        System.out.println(getCross(treeSet,hashSet));
    }
}
