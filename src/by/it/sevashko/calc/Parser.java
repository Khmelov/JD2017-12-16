package by.it.sevashko.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    Var calc(String expression) throws CalcException{
        String[] operand = expression.split(Patterns.OPERATION);
        Var one = Var.createVar(operand[0]);
        Var two = Var.createVar(operand[1]);
        if (expression.contains("=")){
            Container.set(operand[0], two);
            return null;
        }
        if (one==null || two==null) {
            throw new CalcException("ERROR: Ошибка парсинга выражения " + expression);
        }
        Pattern operationPattern=Pattern.compile(Patterns.OPERATION);
        Matcher matcher=operationPattern.matcher(expression);
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
