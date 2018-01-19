package by.it.patsko.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Timer;

/*
TaskB3.
Для предыдущей задачи измерьте на размере задачи в 4096 элемент какой из двух методов работает быстрее.
Объясните итог.
 */
class TaskB3 {
    static final int N = 4096;

    static String process(ArrayList<String> peoples) {
//        System.out.println(peoples);
        Iterator<String> iterator;
        boolean f = true;//сдвигать или нет
        while (peoples.size() != 1) {
            iterator = peoples.iterator();
            if (f == false && iterator.hasNext()) {
                iterator.next();
                iterator.remove();
            }
            while (iterator.hasNext()) {
                iterator.next();
                if (iterator.hasNext()) {
                    iterator.next();
                    iterator.remove();

                    if (!iterator.hasNext()) f = true;
                    else f = false;
                }
            }
//            System.out.println(peoples);
        }
        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples) {
//        System.out.println(peoples);
        Iterator<String> iterator;
        boolean f = true;//сдвигать или нет
        while (peoples.size() != 1) {
            iterator = peoples.iterator();
            if (f == false && iterator.hasNext()) {
                iterator.next();
                iterator.remove();
            }
            while (iterator.hasNext()) {
                iterator.next();
                if (iterator.hasNext()) {
                    iterator.next();
                    iterator.remove();
                    if (!iterator.hasNext()) f = true;
                    else f = false;
                }
            }
//            System.out.println(peoples);
        }
        return peoples.get(0);
    }

    public static void main(String[] args) {
        ArrayList<String> peoplesA = new ArrayList<>();
        LinkedList<String> peoplesL = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            peoplesA.add("n" + i);
            peoplesL.add("n" + i);

        }
        long start=System.nanoTime();
        process(peoplesA);
        long end=System.nanoTime();
        System.out.println("Время работы для  ArrayList="+(end-start)/1000+" мкс.");
        start=System.nanoTime();
        process(peoplesL);
        end=System.nanoTime();
        System.out.println("Время работы для  LinkedList="+(end-start)/1000+" мкс.");


    }
}
