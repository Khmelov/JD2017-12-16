package by.it.krasutski.jd01_12;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String str;
        int negPos = 0;
        while (!(str = sc.next()).equals("end")) {
            Integer value = Integer.parseInt(str);
            if (value > 0)
                list.add(negPos++, value);
            else if (value == 0)
                list.add(negPos, value);
            else
                list.add(value);
        }
        System.out.println(list);
    }
}

