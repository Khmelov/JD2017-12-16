package by.it.akhmelev.jd02_06.matlab_classwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    //приоритет операция определяется индексом в массиве (вообще, конечно правильнее будет сделать Map<String,Integer>)
    private static final List<String> priority = new ArrayList<>(Arrays.asList("=,+,-,*,/".split(",")));
    //операции в выражении. Для A=2+3/4 тут будут = + /
    private List<String> operation = new ArrayList<>();
    //операнды в выражении. Для A=2+3/4 тут будут A 2 3 4
    private List<String> operand;

    private int getPosOperation() {
        int level = -1;
        int pos = -1;
        int i = 0;
        for (String op : operation) {
            int currentLevel = priority.indexOf(op);
            if (level < currentLevel) {
                level = currentLevel;
                pos = i;
            }
            i++;
        }
        return pos;
    }

    private Var oneOperationCalc(String v1, String op, String v2) throws MathExcepton {
        //выполним одну операцию
        Var res = null;

        Var one = VarCreator.getInstance().createVar(v1);
        Var two = VarCreator.getInstance().createVar(v2);

        //если это было присваивание, то сохраним переменную
        if (op.equals("=") && two!=null) {
            two.save(v1);
            return two;
        }
        //иначе проверим переменные на существование
        if (one == null)
            throw new MathExcepton("Неизвеcтное значение " + v1);
        if (two == null)
            throw new MathExcepton("Неизвеcтное значение " + v2);
        //и выполним арифметическую операцию
        switch (op) {
            case "+":
                res = one.add(two);
                break;
            case "-":
                res = one.sub(two);
                break;
            case "*":
                res = one.mul(two);
                break;
            case "/":
                res = one.div(two);
                break;
        }
        return res;
    }


    Var calc(String expression) {
        Var res = null;
        try {
            //получим операнды
            String[] part = expression.split(Patterns.exOper);
            operand = new ArrayList<>(Arrays.asList(part));
            //получим операции
            Pattern p = Pattern.compile(Patterns.exOper);
            Matcher m = p.matcher(expression);
            while (m.find()) operation.add(m.group());
            if (debugOn) System.out.printf("\tDEBUG: %s operand=%s operation=%s\n",expression,operand,operation);
            //пока есть операции найдем позицию приоритетной и выполним её
            while (operation.size() > 0) {
                if (debugOn) debug();
                int pos = getPosOperation();
                String v1 = operand.get(pos);           //прочитаем первый операд (не удаляя, т.к. сюда запишем результат)
                String op = operation.remove(pos);      //прочитаем операцию удаляя ее
                String v2 = operand.remove(pos + 1);    //прочитаем второй операнд удаляя его
                res = oneOperationCalc(v1, op, v2);
                operand.set(pos, res.toString());       //сохраним результат
            }
        SingleLogger.getInstance().log(expression+"="+res);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        return res;
    }

    //отладка формирует и выводит в консоль оставшееся выражение
    private void debug() {
        StringBuilder sb = new StringBuilder("\t\tdebug: "+operand.get(0));
        for (int i = 0; i < operation.size(); i++) {
            sb.append(operation.get(i)).append(operand.get(i + 1));
        }
        System.out.println(sb.toString());
    }

    //внешнее управление отладкой парсера выполняется через конструктор
    enum Debug{
        ON,OFF
    }
    //флаг вывода отладочной информации
    private boolean debugOn;

    //конструктор с управляемой отладкой
    public Parser(Debug debugStatus) {
        this.debugOn = debugStatus== Debug.ON;
    }

    //конструктор по умолчанию (отладка не выводится)
    public Parser() {
        this(Debug.OFF);
    }

}
