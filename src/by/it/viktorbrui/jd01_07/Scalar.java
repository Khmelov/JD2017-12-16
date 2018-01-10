package by.it.viktorbrui.jd01_07;

/*
На уровень A разработайте для класса AbstractVar наследника Scalar с тремя конструкторами:
1. Из вещественного числа 3.1415 сигнатура конструктора Scalar(double value)
2. Из такой же точно переменной сигнатура конструктора Scalar(Scalar scalar)
3. Из строки вида 3.1415 сигнатура конструктора Scalar(String strScalar)
   Переопределите метод String toString() так, чтобы он возвращал строку вида 3.1415
 */

class Scalar extends AbstractVar {
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
}
