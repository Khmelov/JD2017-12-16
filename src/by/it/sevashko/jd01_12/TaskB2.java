package by.it.sevashko.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {

    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        a.add("Ivanov");
        a.add("Sidorov");
        a.add("Petrov");
        a.add("Kotov");
        System.out.println(process(a));

        LinkedList<String> b = new LinkedList<>();
        b.add("Ivanov");
        b.add("Sidorov");
        b.add("Petrov");
        b.add("Kotov");
        System.out.println(process(b));
    }

    static String process(LinkedList<String> peoples){
        int index = 1;
        while (peoples.size() > 1){
            if (index == 1){
                peoples.addLast(peoples.removeFirst());
                index++;
            } else{
                peoples.removeFirst();
                index--;
            }
        }
        return peoples.getFirst();
    }

    static String process(ArrayList<String> peoples){
        int index = 1;
        while (peoples.size() > 1){
            Iterator<String> iter = peoples.iterator();
            while (iter.hasNext()){
                iter.next();
                if (index == 1){
                    index++;
                } else {
                    iter.remove();
                    index--;
                }
            }
        }
        return peoples.get(0);
    }
}
