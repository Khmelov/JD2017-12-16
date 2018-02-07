package by.it.patsko.jd02_06.calc;

class VarFabric {
    public static Var fabricCreateVar(String varString){
        Var var=null;
        if(varString.matches(Patterns.SCALAR))return new Scalar(varString);
        if(varString.matches(Patterns.VECTOR))return new Vector(varString);
        if(varString.matches(Patterns.MATRIX))return new Matrix(varString);
        if(varString.matches(Patterns.KEY)) return Variable.getValue(varString);

        return var;
    }
}
