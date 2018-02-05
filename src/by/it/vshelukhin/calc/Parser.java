package by.it.vshelukhin.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    static final Map<String, Integer> preorety = new HashMap<String, Integer>(){
        {
            this.put("=", 0);
            this.put("+", 1);
            this.put("-", 1);
            this.put("*", 2);
            this.put("/", 2);
        }
    };

    static ArrayList<String> operations;
    static ArrayList<String> operands;

    static int getPrioretyoperation(ArrayList<String> operations){
        int preoretyCurrent = -1;
        int resultOperationPosition = -1;
        int i = 0;
        for (String op : operations) {
            if (preorety.get(op)>preoretyCurrent){
                preoretyCurrent = preorety.get(op);
                resultOperationPosition = i;
            }
            i++;
        }
        return resultOperationPosition;
    }

    public static void main(String[] args) throws CalcException {
        Parser pr = new Parser();
        String a = "((2*(4-1)+3)*8)";
        System.out.println(pr.calc(a));
    }
    Var calc (String expressionAll) throws CalcException {

        if (!testSkobki(expressionAll)) throw new CalcException("Неверный баланс скобок!");
        StringBuilder sb = new StringBuilder(expressionAll);
        Matcher mat = Pattern.compile(Patterns.SKOBKI).matcher(sb);
        while (mat.find()){
            String skobki = mat.group().replace("(","").replace(")","");
            String rezSkob = calcExpression(skobki).toString().replace(" ","");
            sb.replace(mat.start(), mat.end(), rezSkob);
            mat.reset();
        }
        return calcExpression(sb.toString());
    }

    Var calcExpression (String expression) throws CalcException {

        operations = new ArrayList<>();
        operands = new ArrayList<>();
        Collections.addAll(operands, expression.split(Patterns.OPERATION));
        if (operands.size()<2) return Var.createVar(operands.get(0));
        Matcher mat = Pattern.compile(Patterns.OPERATION).matcher(expression);
        while (mat.find()){
            operations.add(mat.group());
        }
        String rez = "";
        while (operations.size()>0){
            int pos = getPrioretyoperation(operations);
            String left = operands.get(pos);
            String operation = operations.remove(pos);
            String right = operands.remove(pos+1);

            rez = oneOperation(left, operation, right);

            operands.set(pos, rez);
        }
        return Var.createVar(rez.replace(" ",""));

    }

    static String oneOperation (String left, String operation, String right) throws CalcException {
        Var two = Var.createVar(right.replace(" ", ""));
        if (operation.equals("=")){
            two.assign(left);
            System.out.print("добавлено в базу:\n"+left+"=");
            return right;
        }
        Var one = Var.createVar(left.replace(" ", ""));

        if (one == null || two == null) throw new CalcException("Ошибка выражения "+left+operation+right);

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
        return "";
    }


    static boolean testSkobki (String s) {
        Queue<String> stek = new ArrayDeque<>();
        Pattern pat = Pattern.compile("\\(|\\)");
        Matcher mat = pat.matcher(s);
        while (mat.find()) {
            if (mat.group().equals("(")) stek.add(mat.group());
            if (mat.group().equals(")")) {
                if (stek.size() != 0) stek.remove();
                else return false;
            }
        }
        if (stek.size() == 0) return true;
        else return false;
    }
}

