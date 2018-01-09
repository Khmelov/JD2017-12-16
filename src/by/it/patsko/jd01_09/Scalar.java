package by.it.patsko.jd01_09;

/*
На уровень A разработайте для класса Var наследника Scalar с тремя конструкторами:
1. Из вещественного числа 3.1415 сигнатура конструктора Scalar(double value)
2. Из такой же точно переменной сигнатура конструктора Scalar(Scalar scalar)
3. Из строки вида 3.1415 сигнатура конструктора Scalar(String strScalar)
   Переопределите метод String toString() так, чтобы он возвращал строку вида 3.1415
 */

import java.util.Scanner;

class Scalar extends Var {
    private double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public Var add(Var other) {
        if(other instanceof Scalar)return new Scalar(this.value+((Scalar) other).value);
        else return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if(other instanceof Scalar)return new Scalar(this.value-((Scalar) other).value);
        else {
            Scalar minus=new Scalar(-1);
            return other.sub(this).mul(minus);
        }
    }

    @Override
    public Var mul(Var other) {
        if(other instanceof Scalar)return new Scalar(this.value*((Scalar) other).value);
        else return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if(other instanceof Scalar)return new Scalar(this.value/((Scalar) other).value);
        else return super.div(other);
    }
}
