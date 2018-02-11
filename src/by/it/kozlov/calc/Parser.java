package by.it.kozlov.calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    private static final List<String> priopity = new ArrayList<>(Arrays.asList(
            "=", "+", "-", "*", "/"
    ));
    private List<String> operations;
    private List<String> operands;

    private int getPosOperation() {
        int level = -1;
        int pos = -1;
        int i = 0;
        for (String operation : operations) {
            int currentLevel = priopity.indexOf(operation);
            if (currentLevel > level) {
                level = currentLevel;
                pos = i;
            }
            i++;
        }
        return pos;
    }

    private String oneOperationCalc(String left, String operation, String right) throws CalcException {
        Var two = VarFactory.getVar(right.replace(" ", ""));
        if (operation.equals("=")) {
            VarsMap.set(left, two);
            return two.toString();
        }

        Var one = VarFactory.getVar(left.replace(" ", ""));
        if (one == null || two == null)
            throw new CalcException(
                    String.format(" Ошибка %s%s%s:", left, operation, right)
            );

        switch (operation) {
            case "+":
                return one.add(two).toString();
            case "-":
                return one.sub(two).toString();
            case "*":
                return one.mul(two).toString();
            case "/":
                return one.div(two).toString();
        }
        throw new CalcException(
                String.format(" Неизвестная Ошибка ")
        );
    }

    static String operations(String string) throws CalcException {
        Parser parser = new Parser();
        StringBuilder stringBuilder = new StringBuilder(string);
        String temp;
        Pattern pattern = Pattern.compile("\\([^(\\)]*\\)");
        Matcher matcher = pattern.matcher(stringBuilder);
        while (matcher.find(0)) {
            temp = stringBuilder.substring(matcher.start(), matcher.end());
            temp = temp.replace("(", "");
            temp = temp.replace(")", "");
            temp = parser.calc(temp);
            temp.replace(" ", "");
            try {
                stringBuilder.replace(matcher.start(), matcher.end(), temp);
            } catch (NullPointerException e) {
                throw new CalcException(String.format(" Ошибка парсинга %s\n", string));
            }

        }
        return stringBuilder.toString();
    }

    String calc(String expression) throws CalcException {
        expression = Parser.operations(expression);
        Logger logger = Logger.getLogger();
        String res = null;
        // get operands
        String[] part = expression.split(Patterns.OPERATION);

        operands = new ArrayList<>();
        for (String one : part) {
            operands.add(one);
        }
        // get operations
        operations = new ArrayList<>();
        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher m = p.matcher(expression);
        while (m.find()) operations.add(m.group());
        while (operations.size() > 0) {
            int pos = getPosOperation();
            String left = operands.get(pos);
            String operation = operations.remove(pos);
            String right = operands.remove(pos + 1);
            res = oneOperationCalc(left, operation, right);
            operands.set(pos, res);
        }
        logger.logger(res);
        if (res == null) throw new CalcException(String.format(" Введено некоректное выражение %s", expression));
        return res;
    }
}
