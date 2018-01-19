package by.it.patsko.jd01_12;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
TaskC3.
В консоль вводится строка, состоящая из выражений и символов «(», «)», «[», «]», «{», «}».
Выведите корректность расстановки скобокс помощью коллекций (true или false).
 */
public class TaskC3 {
    static boolean check(String str) {
        LinkedList<String> list = new LinkedList<>();
        Pattern pattern = Pattern.compile("[(){}\\[\\]]");
        Matcher matcher = pattern.matcher(str);
        boolean flag=true;
        String currentChar;
        while (matcher.find()) {
            currentChar = matcher.group();
                if (list.size() == 0 && (currentChar.equals(")") ||
                        currentChar.equals("]") ||
                        currentChar.equals("}"))) {
                    flag = false;
                    break;
                }else if ((currentChar.equals(")") && list.getLast().equals("(")) ||
                        (currentChar.equals("]") && list.getLast().equals("[")) ||
                        (currentChar.equals("}") && list.getLast().equals("{"))) list.removeLast();
                else list.addLast(currentChar);
        }
        if(list.size()!=0)flag=false;
        return flag;
    }

    public static void main(String[] args) {
        String[] expression = new String[]{
                "{]",//false
                ")",//false
                "",//true
                "(1+1)",//true
                "(1*(2-(14/2-1)*{1.1,2.0})/10)*a[i]",//true
                "{(1*110-11),(x[j]/0.5)",//false
                "((a[i]+b[j+4/5-1)/14+{1,1,2})",//false
                "(1/12",};//false
        for (String str : expression) {
            System.out.println(check(str));
        }
    }
}
