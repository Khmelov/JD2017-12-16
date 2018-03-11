package by.it._tasks_.jd01_09;

abstract class Var implements Operation{

    @Override
    public Var add(Var otherVar) {
        System.out.printf("Операция сложения %s-%s невозможна!\n",this,otherVar);
        return null;
    }

    @Override
    public Var sub(Var otherVar) {
        System.out.printf("Операция вычитания %s-%s невозможна!\n",this,otherVar);
        return null;
    }

    @Override
    public Var mul(Var otherVar) {
        System.out.printf("Операция умножения %s-%s невозможна!\n",this,otherVar);
        return null;
    }

    @Override
    public Var div(Var otherVar) {
        System.out.printf("Операция деления %s-%s невозможна!\n",this,otherVar);
        return null;
    }

    static Var createVar(String operand) {
        operand=operand.trim();
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        return null;
    }
}
