package by.it.vshelukhin.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        List<Integer> l = new ArrayList<>();
        int ind_positive = 0;
        while (!str.equals("end")){
            Integer a = Integer.valueOf(str);
            if (a>0) l.add(ind_positive++,a);
            else if (a==0) l.add(ind_positive,a);
            else l.add(a);
            str = sc.nextLine();
        }
        System.out.println(l);
    }
}
