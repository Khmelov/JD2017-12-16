package by.it.patsko.jd01_09;

/*
На уровень B разработайте для класса Var наследника Vector с тремя конструкторами:
1. Из массива {1.0, 2.0, 4.0} сигнатура конструктора Vector(double[ ] value)
2. Из такой же точно переменной сигнатура конструктора Vector(Vector vector)
3. Из строки вида {1.0, 2.0, 4.0} сигнатура конструктора Vector(String strVector)
   Переопределите метод String toString() так, чтобы он возвращал строку вида {1.0, 2.0, 4.0}
 */

class Vector extends Var {
    private double[] value;

    Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    Vector(Vector vector) {
        this(vector.value);
    }

    Vector(String strVector) {
        String[] str = strVector.substring(1, strVector.length() - 1).split(",");
        this.value = new double[str.length];
        for (int i = 0; i < this.value.length; i++) {
            this.value[i] = Double.parseDouble(str[i]);
        }
    }

    @Override
    public String toString() {
//        return Arrays.toString(value).replace('{','[').replace('}',']');
        StringBuilder result = new StringBuilder();
        result.append('{');
        for (int i = 0; i < value.length; i++) {
            if (i > 0) result.append(", ");
            result.append(value[i]);
        }
        result.append('}');
        return result.toString();
    }
}
