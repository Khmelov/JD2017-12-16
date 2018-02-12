package by.it.viktorbrui.jd02_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    private static final List<String> priopity =
            new ArrayList<String>(
                    Arrays.asList(
                            "=", "+", "-", "*", "/"
                    )
            );
    private List<String> operations;
    private List<String> operands;

    private int getPosOperation() {
        int level = -1;
        int pos = -1;
        int i=0;
        for (String operation : operations) {
            int currentLevel=priopity.indexOf(operation);
            if (currentLevel>level){
                level=currentLevel;
                pos=i;
            }
            i++;
        }
        return pos;
    }

    private String oneOperationCalc(String left, String operation, String right) throws CalcException {
        Var two = Var.createVar(right);
        if (operation.equals("=")) {
            VarsMap.set(left, two);
            return two.toString();
        }

        Var one = Var.createVar(left);
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

    String debug(){
        StringBuilder sb=new StringBuilder();
        for (int i=0; i<operations.size(); i++){
            sb.append(operands.get(i));
            sb.append(operations.get(i));
        }
        sb.append(operands.get(operands.size()-1));
        return sb.toString();
    }


    String calc(String expression) throws CalcException {
        String res = null;
        // get operands
        String[] part = expression.split(Patterns.OPERATION);
        operands = new ArrayList<>();
        for (String one : part) operands.add(one);
        // get operations
        operations = new ArrayList<>();
        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher m = p.matcher(expression);
        while (m.find()) operations.add(m.group());
        while (operations.size() > 0) {
            int pos = getPosOperation();
            String left = operands.get(pos);
            String operation = operations.remove(pos);
            String right = operands.remove(pos+1);
            res = oneOperationCalc(left, operation, right);
            operands.set(pos, res);
            System.out.println(debug());
        }
        return res;
    }

}
