package by.it.kozlov.calc;

public class VarFactory {
    public static Var getVar(String operand) throws CalcException {
        Var var = null;
        operand = operand.trim();
        if (operand.matches(Patterns.SCALAR))
            return var = new Scalar(operand);
        if (operand.matches(Patterns.VECTOR))
            return var = new Vector(operand);
        if (operand.matches(Patterns.MATRIX))
            return var = new Matrix(operand);
        return VarsMap.get(operand);
    }
}
