package by.it.akhmelev.classwork.calc_v1;

class Scalar extends Var {
    private double value;

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            return new Scalar(this.value+((Scalar) other).value);
        }
        else
            return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            return new Scalar(this.value-((Scalar) other).value);
        }
        else
        {
            Scalar minus=new Scalar(-1);
            return other.sub(this).mul(minus);
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            return new Scalar(this.value*((Scalar) other).value);
        }
        else
            return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar)
            return new Scalar(this.value / ((Scalar) other).value);
        else
            return super.div(other);
    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar other){
        this.value=other.value;
    }

    Scalar(String string){
        //"8.9765"
        this.value=Double.parseDouble(string);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
