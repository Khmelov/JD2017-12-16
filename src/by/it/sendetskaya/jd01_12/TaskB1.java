package by.it.sendetskaya.jd01_12;

import java.util.*;

//TaskB1. Нужно ввести с консоли текст на англи ском языке до строки “end” (100 и более
// слов). Для каждого слова с помощью коллекци  подсчитать частоту его встречаемости.
// Вывести все различные слова формате слово=частота. Слова, отличающиеся регистром
// букв, считать различными. isn't или don’t – одно слово.
public class TaskB1 {

    public static void main(String[] args) {

        Scanner sc=new Scanner (System.in);
        String str;
        Map<String, Integer> map = new HashMap<>();

        while (!(str=sc.next()).equals("end")) {
            str = str.replaceAll("[^A-Za-z']", " ");

            for (String s : str.split(" ")) {
                if (map.containsKey(s)) {
                    map.put(s, map.get(s) + 1);
                } else {
                    map.put(s, 1);
                }
            }
        }
        map.remove("");
        System.out.println(map);
    }
}
