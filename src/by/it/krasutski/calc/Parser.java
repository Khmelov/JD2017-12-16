package by.it.krasutski.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Var calc(String expression) {
        String[] operand = expression.split(Patterns.OPERATION);
        Var one = Var.createVar(operand[0]);
        Var two = Var.createVar(operand[1]);
        if (one == null || two == null)
            return null;//TODO: 09.01.2018 create error
        Pattern operationPattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = operationPattern.matcher(expression);
        if (matcher.find()) {
            String operation = matcher.group();
            switch (operation) {
                case "+":
                    return one.add(two);
                case "-":
                    return one.sub(two);
                case "*":
                    return one.mul(two);
                case "/":
                    return one.div(two);
                case "=":
                    return one.assign(two);
            }
        }
        return null;
    }
}
