package by.it.vshelukhin.jd01_12;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC3 {

    static boolean test1 (StringBuilder s) {
        Queue<String> stek = new ArrayDeque<>();
        Pattern pat = Pattern.compile("\\(|\\)");
        Matcher mat = pat.matcher(s);
        while (mat.find()) {
            if (mat.group().equals("(")) stek.add(mat.group());
            if (mat.group().equals(")")) {
                if (stek.size() != 0) stek.remove();
                else return false;
            }
        }
        if (stek.size() == 0) return true;
        else return false;
    }

    static boolean test2 (StringBuilder s) {
        Queue<String> stek = new ArrayDeque<>();
        Pattern pat = Pattern.compile("\\[|\\]");
        Matcher mat = pat.matcher(s);
        while (mat.find()) {
            if (mat.group().equals("[")) stek.add(mat.group());
            if (mat.group().equals("]")) {
                if (stek.size() != 0) stek.remove();
                else return false;
            }
        }
        if (stek.size() == 0) return true;
        else return false;
    }

    static boolean test3 (StringBuilder s) {
        Queue<String> stek = new ArrayDeque<>();
        Pattern pat = Pattern.compile("\\{|\\}");
        Matcher mat = pat.matcher(s);
        while (mat.find()) {
            if (mat.group().equals("{")) stek.add(mat.group());
            if (mat.group().equals("}")) {
                if (stek.size() != 0) stek.remove();
                else return false;
            }
        }
        if (stek.size() == 0) return true;
        else return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String line = sc.nextLine();
        while (!line.equals("end")) {
            sb.append(line);
            sb.append("\n");
            line = sc.nextLine();
        }
        System.out.println(test1(sb)&&test2(sb)&&test3(sb));

    }
}
