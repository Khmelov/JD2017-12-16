package by.it._tasks_.jd01_09;

public class Scalar extends Var {

    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar(String strValue) {
        this.value = Double.parseDouble(strValue);
    }

    Scalar(Scalar varScalar){
        this.value=varScalar.value;
    }

    @Override
    public Var add(Var otherVar) {
        if (otherVar instanceof Scalar){
            Scalar scalar2=(Scalar)otherVar;
            return new Scalar(this.value+scalar2.value);
        }
        else
            return otherVar.add(this);
    }

    @Override
    public Var sub(Var otherVar) {
        if (otherVar instanceof Scalar){
            Scalar scalar2=(Scalar)otherVar;
            return new Scalar(this.value-scalar2.value);
        }
        else {
            Scalar minus=new Scalar(-1);
            return otherVar.sub(this).mul(minus);
        }
    }

    @Override
    public Var mul(Var otherVar) {
        if (otherVar instanceof Scalar){
            Scalar scalar2=(Scalar)otherVar;
            return new Scalar(this.value*scalar2.value);
        }
        else
            return otherVar.mul(this);
    }

    @Override
    public Var div(Var otherVar) {
        if (otherVar instanceof Scalar){
            Scalar scalar2=(Scalar)otherVar;
            return new Scalar(this.value/scalar2.value);
        }
        else
            return super.div(otherVar);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
