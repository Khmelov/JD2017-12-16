package by.it.ikiselev.jd01_09;

class Scalar extends Var {
    private double value;
    public Scalar (double value){
        this.value=value;
    }
    Scalar (Scalar other){
        this.value=other.value;
    }
    Scalar (String string){
        this.value=Double.parseDouble(string);
    }
    @Override
    public String toString() {
        return Double.toString(value);
    }
}
