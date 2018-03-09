package by.it.sevashko.jd02_06;

public class VarFactory {

    private VarFactory(){}

    static Var createVar(String operand){
        operand = operand.trim();
        if (operand.matches(Patterns.SCALAR)){
            return new Scalar(operand);
        }
        if (operand.matches(Patterns.VECTOR)){
            return new Vector(operand);
        }
        if (operand.matches(Patterns.MATRIX)){
            return new Matrix(operand);
        }
        return Container.getVar(operand);
    }
}
