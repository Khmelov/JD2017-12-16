package by.it.sendetskaya.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TaskC3. В консоль вводится строка, состоящая из выражени  и символов «(»,
// «)», «[», «]», «{», «}». Выведите корректность расстановки скобок с помощью
// коллекци  (true или false).
public class TaskC3 {

    public static void main(String[] args) {

        Scanner sc=new Scanner (System.in);
        StringBuilder sb=new StringBuilder();
        boolean flag=false;
        String str;

        while (!((str=sc.next()).equals("end"))) {
            sb.append(str);
        }
        flag=workPattern("[{}]+",sb.toString());
        System.out.println("Соответствие скобок{}: "+flag);
        flag=workPattern1("[()]+",sb.toString());
        System.out.println("Соответствие скобок(): "+flag);
        flag=workPattern2("[\\[\\]]+",sb.toString());
        System.out.println("Соответствие скобок[]: "+flag);

    }

    private static boolean workPattern (String regexString, String text) {
        boolean flagCorrect=false;
        //LinkedList<String> list=new LinkedList<>();
        Queue<String> linkList=new ArrayDeque<>();
        Pattern pattern = Pattern.compile(regexString);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String str = matcher.group();
            str = str.trim();
            if(str.equals("{")) {
                linkList.add(str);
                //list.add("{");
            }
            if (str.equals("}"))
            {
                if (linkList.size()!=0) {
                    linkList.remove();
                    //list.removeLast();
                    }
                else return false;
            }
        }
        if (linkList.size()==0)
            flagCorrect=true;

        return flagCorrect;
    }

    private static boolean workPattern1 (String regexString, String text) {
        boolean flagCorrect=false;
        Queue<String> linkList=new ArrayDeque<>();
        Pattern pattern = Pattern.compile(regexString);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String str = matcher.group();
            str = str.trim();
            if(str.equals("(")) {
                linkList.add(str);
            }
            if (str.equals(")"))
            {
                if (linkList.size()!=0) {
                    linkList.remove();
                }
                else return false;
            }
        }
        if (linkList.size()==0)
            flagCorrect=true;

        return flagCorrect;
    }

    private static boolean workPattern2 (String regexString, String text) {
        boolean flagCorrect=false;
        Queue<String> linkList=new ArrayDeque<>();
        Pattern pattern = Pattern.compile(regexString);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String str = matcher.group();
            str = str.trim();
            if(str.equals("[")) {
                linkList.add(str);
            }
            if (str.equals("]"))
            {
                if (linkList.size()!=0) {
                    linkList.remove();
                }
                else return false;
            }
        }
        if (linkList.size()==0)
            flagCorrect=true;

        return flagCorrect;
    }
}
