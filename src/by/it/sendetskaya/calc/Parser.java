package by.it.sendetskaya.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Var calc(String expression) throws CalcException {
        //2.0 * 3.0
        String []operand=expression.split(Patterns.OPERATION);

        Var one= Var.createVar(operand[0]);  // 2.0

        Var two= Var.createVar(operand[1]);  //3.0
        if (one==null || two==null)
            throw new CalcException("Ошибка парсинга выражения: "+expression);

//        if (one.equals(Patterns.OPERATION) || two.equals(Patterns.OPERATION))
//            throw new CalcException("Ошибка парсинга выражения: "+expression);
        //static final String OPERATION="[-+*/]";
        Pattern operationPattern=Pattern.compile(Patterns.OPERATION);

        Matcher matcher=operationPattern.matcher(expression);
        if(matcher.find())
        {
            String operation=matcher.group(); //*
            if (operation.isEmpty())
                throw new CalcException("Ошибка парсинга выражения:(Вы не ввели операцию) "+operation);
            if (operation.length()>1)
                throw new CalcException("Ошибка парсинга выражения: (Вы ввели более одной операции)"+operation);

            switch (operation)
            {
                case "+": return one.add(two);
                case "-": return one.sub(two);
                case "*": return one.mul(two);
                case "/": return one.div(two);


            }
        }
        throw new CalcException("Операция должна иметь символы + или -, или *, или /"+operationPattern);
    }
}
