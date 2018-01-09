package by.it.patsko.jd01_09;


abstract class Var implements Operation {

    @Override
    public Var add(Var other) {
        System.out.printf("Сложение %s + %s невозможно\n", this, other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Вычитание %s - %s невозможно\n", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Умножение %s * %s невозможно\n", this, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Деление %s / %s невозможно\n", this, other);
        return null;
    }
    static Var creatVar(String operand){
        operand=operand.trim();
        if(operand.matches(Patterns.SCALAR))return new Scalar(operand);
        if(operand.matches(Patterns.VECTOR))return new Vector(operand);
        if(operand.matches(Patterns.MATRIX))return new Matrix(operand);

        return null;
    }
}
