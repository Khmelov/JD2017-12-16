package by.it.sevashko.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB3 {

    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        LinkedList<String> b = new LinkedList<>();
        for (int i = 1; i <= 4096; i++ ){
            a.add(String.valueOf(i));
            b.add(String.valueOf(i));
        }
        long start = System.nanoTime();
        process(a);
        long workTime = System.nanoTime() - start;
        System.out.println(workTime);
        start = System.nanoTime();
        process(b);
        workTime = System.nanoTime() - start;
        System.out.println(workTime);
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
