package by.it.vshelukhin.calc;

public class Scalar extends Var {
    double value;

    Scalar(double value){
        this.value = value;
    }

    Scalar(Scalar other){
        this.value = other.value;
    }

    Scalar(String string){
        this.value = Double.parseDouble(string);
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar){
            return new Scalar(value + ((Scalar) other).value);
        }
        else return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar){
            return new Scalar(value - ((Scalar) other).value);
        }
        else {
            Scalar minus = new Scalar(-1);
            return other.sub(this).mul(minus);
        }
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar){
            return new Scalar(value * ((Scalar) other).value);
        }
        else return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar){
            if (((Scalar) other).value == 0) throw new CalcException("Деление на ноль!");
            return new Scalar(value / ((Scalar) other).value);
        }
        else return super.div(this);
    }

    @Override
    public void assign(String name) {
        Data.data.put(name,this);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
