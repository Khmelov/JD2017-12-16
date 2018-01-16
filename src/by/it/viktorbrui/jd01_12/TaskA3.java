package by.it.viktorbrui.jd01_12;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {



    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        Scanner  sc= new Scanner(System.in);
        String str;
        while (!(str=sc.next()).equals("end")){
            list.add(Integer.parseInt(str));
        }
        System.out.println(list);
    }
}
