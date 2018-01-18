package by.it.sevashko.jd01_12;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC3 {

    public static void main(String[] args) {
        String exp = "(({[]})))";
        System.out.println(check(exp));
    }

    static boolean check(String line){
        LinkedList<String> list = new LinkedList<>();
        Pattern pattern = Pattern.compile("[\\[\\]{}()]");
        Matcher matcher = pattern.matcher(line);
        String requared = "";
        while (matcher.find()){
            String c = matcher.group();
            if ("[{(".contains(c)){
                list.addLast(c);
            } else {
                switch (c){
                    case "]": {
                        requared = "[";
                        break;
                    }
                    case "}": {
                        requared = "{";
                        break;
                    }
                    case ")": requared = "(";
                }
                if (requared.equals(list.getLast())){
                    list.removeLast();
                } else {
                    return false;
                }
            }
        }
        return list.size() == 0;
    }
}
