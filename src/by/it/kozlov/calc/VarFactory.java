package by.it.kozlov.calc;

public class VarFactory {
    public static Var getVar(String operand) throws CalcException {
        Var var = null;
        operand = operand.trim();
        if (operand.matches(Patterns.SCALAR))
            var = new Scalar(operand);
        if (operand.matches(Patterns.VECTOR))
            var = new Vector(operand);
        if (operand.matches(Patterns.MATRIX))
            var = new Matrix(operand);
        return var;
    }
}
