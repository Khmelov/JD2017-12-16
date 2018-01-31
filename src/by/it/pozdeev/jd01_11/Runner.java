package by.it.pozdeev.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        ListA <Integer> a=new ListA<>();
        a.add(5);
        a.add(6);
        System.out.println(a);
        ListB<String> b=new ListB<>();
        b.add("one");
        b.add("two");
        System.out.println(b);
        b.set(1,"three");
        System.out.println(b);
        b.add("four");
        System.out.println(b);
        b.add(2,"nol");
        System.out.println(b);
        SetC<String>c=new SetC<>();
        c.add("five");
        ArrayList<String> l=new ArrayList<String>();
        l.add("one");
        l.add("two");
        l.addAll(l);
        c.addAll(l);
        System.out.println(c.size());
        c.removeAll(l);
        System.out.println(c);





    }
}
