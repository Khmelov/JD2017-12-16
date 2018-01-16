package by.it.akhmelev.jd01_12.classwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        String str;
        int negpos=0;
        while (!(str=sc.next()).equals("end")){
            Integer value=Integer.valueOf(str);
                if (value>0)
                    list.add(negpos++,value);
                else if (value==0)
                    list.add(negpos,value);
                else
                    list.add(value);
        }
        System.out.println(list);

    }
}
