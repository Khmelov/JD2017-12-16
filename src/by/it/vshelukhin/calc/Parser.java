package by.it.vshelukhin.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Var calc(String expression) throws CalcException {
        Var one;
        Var two;
        String name_var = "";
        String[] operand = expression.split(Patterns.OPERATION);
        if (expression.matches(".*=.*")) {
            name_var = operand[0];
            one = two = Var.createVar(operand[1]);
        }
        else {
            one = Var.createVar(operand[0]);
            two = Var.createVar(operand[1]);
        }
        if (one == null || two == null) throw new CalcException("Ошибка парсинга!");

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
                    one.assign(name_var);
                    System.out.println("добавлено");
                    return null;
            }
        }
        return null;
    }
}

