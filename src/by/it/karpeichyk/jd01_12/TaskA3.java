package by.it.karpeichyk.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by user on 16.01.2018.
 */
public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> list= new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        String str;
        int position=0;
        while (!(str=sc.next()).equals("end")) {
            Integer v = Integer.valueOf(str);
            if (v > 0)
                list.add(position++, v);
             else if (v == 0)
                list.add(position, v);
            else
                list.add(v);
        }
            System.out.println(list);
        }
    }

