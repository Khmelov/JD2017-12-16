package by.it._tasks_.jd01_06;

import java.util.Arrays;
import java.util.Comparator;

class TaskB2 {

    public static void main(String[] args) {
        String[] pr=Poem.text.split("[.]\n");
        for (int i = 0; i < pr.length; i++)
            pr[i]=pr[i].replaceAll("[^А-Яа-яёЁ]+"," ");
        Arrays.sort(pr,Comparator.comparingInt(String::length));
        for (String s : pr) {
            System.out.println(s);
        }
    }
}
