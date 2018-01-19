package by.it.patsko.jd01_11;

import java.util.HashSet;
import java.util.List;

class Runner {
    public static void main(String[] args) {
//        List<Integer> listA=new ArrayList<>();
        List<String> listA=new ListA<>();
        listA.add("one");
        listA.add("two");
        listA.add("three");
        listA.add("four");

        System.out.println("listA="+listA);
        System.out.println("size="+listA.size());
        listA.remove(2);
        System.out.println("listA="+listA);

        List<Integer> listB=new ListB<>();
        for (int i = 0; i < 10; i++) {
            listB.add(i*10);
        }
        System.out.println("listB="+listB);
        listB.set(3,33);
        System.out.println("listB="+listB);
        listB.add(9,88);
        System.out.println("listB="+listB);
        listB.add(11,111);
        System.out.println("listB="+listB);
        List<Integer> listC=new ListB<>();
        listC.add(0);
        listC.add(4);
        listC.add(6);
        listC.add(444);
        listC.add(8);
        System.out.println("listC="+listC);
        listC.addAll(listB);
        System.out.println("listC="+listC);

        System.out.println();
        HashSet<Short> setH=new HashSet<>();
        SetC<Short> setC=new SetC<>();

        for (int i = 0; i < 10; i++) {//[0, 16, null, 2, 18, 4, 6, 8, 10, 12, 14]
            setH.add((short) (i * 2));
            setC.add((short) (i * 2));
        }
        System.out.println("setH"+setH+"\nsetC"+setC);
        System.out.println();
        System.out.println("setC.contains(0)"+setC.contains((short)0));
        setH.add(null);
        setC.add(null);
        System.out.println("setC.contains(0)"+setC.contains((short)0));
        System.out.println("setC.contains(null)"+setC.contains(null));
        System.out.println("setH"+setH+"\nsetC"+setC);
        setC.remove((short)2);
        System.out.println("setC"+setC);
    }
}
