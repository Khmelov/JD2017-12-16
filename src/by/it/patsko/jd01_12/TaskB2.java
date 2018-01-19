package by.it.patsko.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/*
TaskB2.
В кругу стоят N человек, пронумерованных от 1 до N.
При ведении счета по кругу итератором вычеркивается каждый второй человек, пока не останется один.
Нужно составить два метода,моделирующие процесс и возвращающие имя оставшегося человека:
static String process(ArrayList<String> peoples)
static String process(LinkedList<String> peoples)
 */
class TaskB2 {
    static final int N = 9;

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
            System.out.println(peoples);
        }
        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples) {
        System.out.println(peoples);
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
            System.out.println(peoples);
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
        System.out.println(process(peoplesA));
        System.out.println(process(peoplesL));


    }
}
