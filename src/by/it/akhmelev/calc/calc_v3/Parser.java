package by.it.akhmelev.calc.calc_v3;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class Parser {


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
        }
    };


    //операции (+-*.=) и операнды (числа и переменные). Создаются в calc
    private List<String> operations;
    private List<String> operands;

    //вычисление индекса самой приоритетной операции
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

    //выполнение одной операции
    private String oneOperationCalc(String left, String operation, String right) throws CalcException {
        //получаем вторую переменную (в методе createVar нужно предусмотреть чтение значения из карты)
        Var two = Var.createVar(right);
        if (two == null)
            throw new CalcException(String.format(" Ошибка %s%s%s:", left, operation, right));
        //если это присваивание, то первую переменную не получить, запишем в карту переменных и выйдем
        if (operation.equals("=")) {
            VarsMap.set(left, two);
            return two.toString();
        }
        //получаем первую переменную (в методе createVar нужно предусмотреть чтение значения из карты)
        Var one = Var.createVar(left);
        if (one == null)
            throw new CalcException(String.format(" Ошибка %s%s%s:", left, operation, right));

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

    //основной метод для расчета всего выражения
    String calc(String expression) throws CalcException {
        String res = null;
        // создадим список операндов
        operands = new ArrayList<>();
        Collections.addAll(operands, expression.split(Patterns.OPERATION));
        //если операций нет, попробуем вернуть переменную
        if (operands.size() < 2)
            return Var.createVar(expression).toString();
        // создадим список операций
        operations = new ArrayList<>();
        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher m = p.matcher(expression);
        while (m.find()) operations.add(m.group());
        //пока есть операции
        while (operations.size() > 0) {
            int pos = getPosOperation(); //ищем самую приоритетную
            String left = operands.get(pos); //готовим первый операнд
            String operation = operations.remove(pos); //извлекаем операцию
            String right = operands.remove(pos + 1); //извлекаем второй операнд
            res = oneOperationCalc(left, operation, right); //расчет
            operands.set(pos, res); //запись итога на место первого операнда
            if (debug)
                System.out.println(debug()); //это для отладки
        }
        return res;
    }

}
