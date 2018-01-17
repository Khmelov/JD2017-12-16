package by.it.fyodorov.jd01_09;

public abstract class Var implements Operation {
    static Var createVar(String operand) {
        if (operand.matches(Patterns.SCALAR)) return new Scalar(operand);
        if (operand.matches(Patterns.VECTOR)) return new Vector(operand);
        if (operand.matches(Patterns.MATRIX)) return new Matrix(operand);
        return null;
    }

    @Override
    public Var add(Var other) {
        System.out.println("Данная операция не возможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Данная операция не возможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Данная операция не возможна");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Данная операция не возможна");
        return null;
    }
}
