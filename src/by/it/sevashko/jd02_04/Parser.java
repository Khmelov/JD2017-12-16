package by.it.sevashko.jd02_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static final List<String> priority = new ArrayList<>(Arrays.asList("=", "+", "-", "*", "/"));
    private List<String> operations;

    String calc(String expression) throws CalcException {
        expression = withoutBrackets(expression);
        operations = new ArrayList<>();
        List<String> operands = new ArrayList<>();
        String[] part = expression.split(Patterns.OPERATION);
        Collections.addAll(operands, part);
        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher m = p.matcher(expression);
        while (m.find()) operations.add(m.group());
        while (operations.size() > 0){
            int pos = getPositionOperation();
            String left = operands.get(pos);
            String operation = operations.remove(pos);
            String right = operands.remove(pos+1);
            String res = oneOperationCalc(left, operation, right);
            operands.set(pos, res);
        }
        return operands.get(0);
    }

    private String oneOperationCalc(String left, String operation, String right) throws CalcException {
        Var rightVar = Var.createVar(right);
        if (operation.equals("=")){
            Container.setVar(left, rightVar);
            return rightVar.toString();
        }
        Var leftVar = Var.createVar(left);
        if (leftVar == null || rightVar == null) {
            throw new CalcException(String.format(" Ошибка %s%s%s:", left, operation, right));
        }
        switch (operation){
            case "+": return leftVar.add(rightVar).toString();
            case "-": return leftVar.sub(rightVar).toString();
            case "*": return leftVar.mul(rightVar).toString();
            case "/": return leftVar.div(rightVar).toString();
        }
        throw new CalcException(
                String.format("Неизвестная операция: %s", operation)
        );
    }

    private int getPositionOperation() {
        int level = -1;
        int pos = -1;
        int i = 0;
        for (String operation : operations) {
            int currentLevel = priority.indexOf(operation);
            if (currentLevel > level){
                level = currentLevel;
                pos = i;
            }
            i++;
        }
        return pos;
    }

    private String withoutBrackets(String expression) throws CalcException {
        StringBuilder newExpression = new StringBuilder(expression);
        Pattern p = Pattern.compile("\\(([^()]+)\\)");
        Matcher m = p.matcher(newExpression);
        while (m.find()){
            int start = m.start();
            int end = m.end();
            String res = calc(m.group(1));
            newExpression.replace(start, end, res);
            m.reset();
        }
        return newExpression.toString();
    }
}
