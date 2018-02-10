package by.it.vshelukhin.calc;

public class FactoryVars {
    static Var createVar (String operand) throws CalcException {
        if (Data.data.containsKey(operand)) return Data.data.get(operand);
        if (operand.matches(Patterns.SCALAR)) return new Scalar(operand);
        if (operand.matches(Patterns.VECTOR)) return new Vector(operand);
        if (operand.matches(Patterns.MATRIX)) return new Matrix(operand);
        throw new CalcException("Ошибка ввода операнда!"+operand);
    }
}
