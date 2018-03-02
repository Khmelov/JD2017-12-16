package by.it.kozlov.jd01_12;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("[(){}\\[\\]]");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            sb.append(str.charAt(matcher.start()));
        }
        System.out.println(find(sb));
    }

    public static boolean find(StringBuilder sb) {
        Deque<Character> deq = new ArrayDeque<>();
        int a = 0;
        for (int i = 0; i < sb.length(); i++) {
            deq.addLast(sb.charAt(i));
        }
        while (!(deq.peekLast() == null)) {
            char value = deq.pollLast();
            if (value == '(' || value == '{' || value == '[') {
                a++;
            }
            if (value == ')' || value == '}' || value == ']') {
                a--;
            }
        }
        if (a == 0) return true;
        return false;
    }
}
