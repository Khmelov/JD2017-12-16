package by.it.sevashko.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    Var calc(String expression){
        Pattern operationPattern=Pattern.compile(Patterns.OPERATION);
        Matcher matcher=operationPattern.matcher(expression);
        String[] operand = expression.split(Patterns.OPERATION);
        Var one = Var.createVar(operand[0]);
        Var two = Var.createVar(operand[1]);

        if (one==null || two==null) {
            return null;
        }
        if (matcher.find()){
            String operation=matcher.group();
            switch (operation){
                case "+": return one.add(two);
                case "-": return one.sub(two);
                case "*": return one.mul(two);
                case "/": return one.div(two);
            }
        }
        return null;
    }
}
