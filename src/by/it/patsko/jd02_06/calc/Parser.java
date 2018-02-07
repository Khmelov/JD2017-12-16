package by.it.patsko.jd02_06.calc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    private List<String> operations;
    private List<String> operands;
    private static final HashMap<String, Integer> priopity = new HashMap<String, Integer>() {
        {
            this.put("=", 0);
            this.put("+", 1);
            this.put("-", 1);
            this.put("*", 2);
            this.put("/", 2);
        }
    };

    private String oneOperation(String left, String operation, String right) throws CalcException {
        Var two = VarFabric.fabricCreateVar(right);
        if (operation.equals("=")) {
            Variable.set(left, two);
            return two.toString();
        }
        Var one = VarFabric.fabricCreateVar(left);

        if (one == null || two == null)
            throw new CalcException(String.format("Error: %s%s%s:", left, operation, right));

        switch (operation) {
            case "+":
                return one.add(two).toString();
            case "-":
                return one.sub(two).toString();
            case "*":
                return one.mul(two).toString();
            case "/":
                return one.div(two).toString();
            default:
                throw new CalcException("Unknown error");
        }
    }

    private int getPosOperation() {
        int level = -1;
        int pos = -1;
        for (int i = 0; i < operations.size(); i++) {
            int currentLevel = priopity.get(operations.get(i));
            if (currentLevel > level) {
                level = currentLevel;
                pos = i;
            }
        }
        return pos;
    }

    String calc(String expression) throws CalcException {
        Pattern pattern = Pattern.compile("(?<=\\()[\\w-+/*\\.\\{,\\}]+(?=\\))");
        //(?<=\()[\w-+/*\.\{,\}]+(?=\)) - без скобок
        //\([\w-+/*\.\{,\}]+\) - со скобками
        Matcher matcher1 = pattern.matcher(expression);
        String line;
        while (matcher1.find()) {
            line=matcher1.group();
            expression=expression.replace("("+line+")",calc(line));
            matcher1.reset(expression);
        }

        String result = null;
        operations = new ArrayList<>();
        operands = new ArrayList<>();
        Collections.addAll(operands, expression.split(Patterns.OPERATION));
        if (operands.size() < 2) return VarFabric.fabricCreateVar(expression).toString();

        Pattern operationPattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = operationPattern.matcher(expression);
        while (matcher.find()) operations.add(matcher.group());

        while (operations.size() > 0) {
            int pos = getPosOperation();
            String left = operands.get(pos);
            String operation = operations.remove(pos);
            String right = operands.remove(pos + 1);
            result = oneOperation(left, operation, right);
            operands.set(pos, result);
        }
        return result;

    }
}
