package by.it._tasks_.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String word;
        int pos = 0;
        while (!(word = scanner.next()).equals("end")) {
            int i = Integer.parseInt(word);
            if (i < 0)
                list.add(i);
            else if (i > 0)
                list.add(pos++, i);
            else
                list.add(pos, i);
        }
        System.out.println(list);

    }
}
