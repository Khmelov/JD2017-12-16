package by.it.sendetskaya.jd01_12;

import java.util.*;

//TaskC1. Ввести с консоли текст до строки end. Во входном тексте хранятся
// наименования некоторых объектов, по одному в строке. Строки повторяются. Построить
// список C1, элементы которого содержат наименования и уникальные шифры данных
// объектов, причем элементы списка должны быть упорядочены по возрастанию шифров
// (шифр – некоторое случа ное, но гарантированно уникальное число). Затем нужно
// «сжать» список C1, удаляя дублирующи ся наименования объектов.
public class TaskC1 {

    public static void main(String[] args) {

        Scanner sc=new Scanner (System.in);
        String str;
        Integer iKey=0;
        Map<Integer,String> map = new HashMap<>();

        while (!(str=sc.next()).equals("end")) {

            for (String s : str.split("\n")) {
                 {
                     iKey++;
                    map.put(iKey,s);
                }
            }
        }
       // map.remove("");
        System.out.println(map);
        ProcessText(map);
    }

    private static void ProcessText(Map<Integer, String> map) {

        Set<String> textProcess=new HashSet<>();
        Iterator<Map.Entry<Integer, String>> itr = map.entrySet().iterator();
        while (itr.hasNext()) {
            if(!textProcess.add(itr.next().getValue()))
            itr.remove();
        }
        System.out.println("Сжатый список: \n"+map);

    }
}
