package by.it.sendetskaya.jd02_06.calc;

public class FabricVar {

    public static Var createVar(String operand) throws CalcException {
        operand=operand.trim();
        //если переменная уже есть, то читаем ее
        if (VarsMap.get(operand)!=null)
            return VarsMap.get(operand);
        if(operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        if(operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        if(operand.matches(Patterns.MATRIX))
            return new Matrix(operand);

        else throw new CalcException("Ошибка парсинга выражения: (Вы ввели не числа, не скобки)"+operand);
    }
}
