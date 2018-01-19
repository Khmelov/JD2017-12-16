package by.it.sendetskaya.jd01_12;

import java.util.*;

//TaskB2. В кругу стоят N человек, пронумерованных от 1 до N. При ведении счета по кругу
// итератором вычеркивается кажды  второ  человек, пока не останется один. Нужно составить
// два метода, моделирующие процесс и возвращающие имя оставшегося человека:
//static String process(ArrayList<String> peoples)
//static String prоcess(LinkedList<String> peoples)
public class TaskB2 {

    public static void main(String[] args) {

        List<String> peopleArr=new ArrayList<>();
        List<String> peopleLink=new LinkedList<>();
        String str,strArr,strLink;

        Scanner sc=new Scanner (System.in);

        while (!(str=sc.next()).equals(".")) {
            peopleArr.add(str);
            peopleLink.add(str);
        }
        strArr=process((ArrayList<String>) peopleArr);
        System.out.println("Последний в живых: (array) "+strArr);

        strLink=process((LinkedList<String>) peopleLink);
        System.out.println("Последний в живых: (linked) "+strLink);
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
