package by.it.sendetskaya.jd01_09;

class Scalar extends Var {

    protected double value;

   Scalar(double value)
    {
        this.value=value;
    }

//    Scalar (Scalar other)
//    {
//        this.value=other.value;
//    }

    Scalar (String string)
    {
        this.value=Double.parseDouble(string);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar)
            return new Scalar(this.value+((Scalar) other).value);  //когда скалар+скалар
            else {
            return other.add(this);   //перевызывается метод реализ в other
        }
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar)
            return new Scalar(this.value-((Scalar) other).value);  //когда скалар+скалар
        else {
            Scalar minus=new Scalar(-1);
            return other.sub(this).mul(minus);   //перевызывается метод реализ в other
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar)
            return new Scalar(this.value*((Scalar) other).value);  //когда скалар+скалар
        else
            return other.mul(this);   //перевызывается метод реализ в other
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar)
            return new Scalar(this.value/((Scalar) other).value);  //когда скалар+скалар
        else
            return super.div(other);   //перевызывается метод реализ в other
    }
}
