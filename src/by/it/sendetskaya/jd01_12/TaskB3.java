package by.it.sendetskaya.jd01_12;

import java.util.*;

//TaskB2. В кругу стоят N человек, пронумерованных от 1 до N. При ведении счета по кругу
// итератором вычеркивается кажды  второ  человек, пока не останется один. Нужно составить
// два метода, моделирующие процесс и возвращающие имя оставшегося человека:
//static String process(ArrayList<String> peoples)
//static String prоcess(LinkedList<String> peoples)
public class TaskB3 {

    public static void main(String[] args) {

        List<String> peopleArr=new ArrayList<>();
        List<String> peopleLink=new LinkedList<>();
        String strArr,strLink;
        long timer, timer0;

        timer=System.nanoTime();
        for (int i = 1; i <= 4096; i++) {
            peopleArr.add("n"+i);
        }
        strArr=process((ArrayList<String>) peopleArr);
        //timer1=(System.nanoTime()-timer)/1000;
        System.out.println("Последний в живых: (array) "+strArr+"\nВремя обработки 4096 имен в Array: "+(System.nanoTime()-timer)/1000);

        timer0=System.nanoTime();
        for (int i = 1; i <= 4096; i++) {
            peopleLink.add("n"+i);
        }

        strLink=process((LinkedList<String>) peopleLink);
//        timer2=(System.nanoTime()-timer0)/1000;
        System.out.println("Последний в живых: (linked) "+strLink+"\nВремя обработки 4096 имен в Linked: "+(System.nanoTime()-timer0)/1000);
    }

    static String process(ArrayList<String> peoples) {

        boolean flag=true;
        Iterator it;

            while ((peoples.size()!=1)) {
                {
                    it=peoples.iterator();
                    while (it.hasNext()) {
                        if (it.hasNext()&&flag) {
                            it.next();
                            flag = false;
                            if (it.hasNext()) {
                                it.next();
                                it.remove();
                                flag = true;
                            }
                        }
                        if (it.hasNext() && !flag) {
                            it.next();
                            it.remove();
                            flag = true;
                        }
                    }
                }
        }

        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples) {

        boolean flag=true;
        Iterator it;

        while ((peoples.size()!=1)) {
            {
                it=peoples.iterator();
                while (it.hasNext()) {
                    if (it.hasNext()&&flag) {
                        it.next();
                        flag = false;
                        if (it.hasNext()) {
                            it.next();
                            it.remove();
                            flag = true;
                        }
                    }
                    if (it.hasNext() && !flag) {
                        it.next();
                        it.remove();
                        flag = true;
                    }
                }
            }
        }

        return peoples.get(0);
    }

}
