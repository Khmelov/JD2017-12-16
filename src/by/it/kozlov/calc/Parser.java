package by.it.kozlov.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc(String expression) throws CalcException {
        // 2.0 * 2.0
        String[] operand = expression.split(Patterns.OPERATION);
        Var two = Var.createVar(operand[1]);
        if (expression.contains("=")) {
            VarsMap.set(operand[0], two);
            return two;
        }

        Var one = Var.createVar(operand[0]);
        if (one == null || two == null)
            throw new CalcException(String.format("Ошибка парсинга выражения: " + expression));
        //find "[-+*/]"
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
            }
        }
        return null;
    }
}
