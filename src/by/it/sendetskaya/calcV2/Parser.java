package by.it.sendetskaya.calcV2;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    /////
    //дебаггинг по умолчанию не нужен, включается только через конструктор
    private boolean debug = false;

    //оставим пустой конструктор
    public Parser() {
    }

    //конструктор с включением/выключением отладки
    public Parser(boolean debug) {
        this.debug = debug;
    }

    //карта приоритетов операций - карта лучше массива, быстрее будет поиск (за O(1))
    private static final HashMap<String, Integer> priopity = new HashMap<String, Integer>() {
        {
            this.put("=", 0);
            this.put("+", 1);
            this.put("-", 1);
            this.put("*", 2);
            this.put("/", 2);
            this.put("(",3);
            this.put(")",3);
        }
    };

    /////
    //операции (+-*.=) и операнды (числа и переменные). Создаются в calc
    private List<String>operations;
    private List<String>operands;
    /////
    //вычисление индекса самой приоритетной операции
    private int getPositionOperation() {
        int level=-1;
        int pos=-1;
        for (int i = 0; i < operations.size(); i++) {
            int currentLevel = priopity.get(operations.get(i));
            if (currentLevel > level) {
                level = currentLevel;
                pos = i;
            }
        }
        return pos;
    }
    /////

    //выполнение одной операции
    private String oneOperationCalc(String left, String operation, String right) throws CalcException  {
        Var two=Var.createVar(right);
        if (two == null)
            throw new CalcException(
                    String.format(" Ошибка %s%s%s:", left, operation, right));
        //если это присваивание, то первую переменную не получить, запишем в карту переменных и выйдем
        if (operation.equals("="))
        {
            VarsMap.set(left,two);
            return two.toString();
        }
        Var one=Var.createVar(left);
        if (one==null)
            throw new CalcException(
                    String.format("Ошибка %s%s%s",left,operation,right));

        //выполняем операцию
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
        throw new CalcException(" Неизвестная Ошибка ");
    }
    /////
    //метод для "ручного" поиска ошибок
    private String debug() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < operations.size(); i++) {
            sb.append(operands.get(i));
            sb.append(operations.get(i));
        }
        sb.append(operands.get(operands.size() - 1));
        return sb.toString();
    }

    //////
    //основной метод для расчета всего выражения
    String calc(String expression) throws CalcException {
        String result=null;
        expression=processExpr(expression);
        //get operand
        //////
        String[]part=expression.split(Patterns.OPERATION);
        operands=new ArrayList<>(Arrays.asList(part));
        Collections.addAll(operands, part);
        //если операций нет, попробуем вернуть переменную
        if (operands.size() < 2)
            return Var.createVar(expression).toString();

        //get operation
        operations = new ArrayList<>();
        Pattern p=Pattern.compile(Patterns.OPERATION);
        Matcher m=p.matcher(expression);
        while (m.find()) {
            operations.add(m.group());
        }
        while (operations.size()>0)
        {
            int position=getPositionOperation();//ищем самую приоритетную
            String left=operands.get(position);//готовим первый операнд
            String operation=operations.remove(position);//извлекаем операцию
            String right=operands.remove(position+1);//извлекаем второй операнд
            result=oneOperationCalc(left,operation,right);//расчет
            operands.set(position,result);//запись итога на место первого операнда
            if (debug)
                System.out.println(debug()); //это для отладки
        }
        return result;
    }

    private String processExpr(String expression) throws CalcException {
        StringBuilder sb=new StringBuilder(expression);
        Pattern pattern=Pattern.compile("\\(([^()]+)\\)");
        Matcher m = pattern.matcher(sb);
        while (m.find()){
            int start = m.start();
            int end = m.end();
            String res = calc(m.group(1));
            sb.replace(start, end, res);
            m.reset();
        }
        return sb.toString();
    }

}
