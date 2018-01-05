package by.it.kozlov.jd01_07;

public class Vector extends AbstractVar {

    private double[] value;

    Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    Vector(Vector vector) {
        this(vector.value);
    }

//    Vector(String string) {
//        String[] str = string.split(",");
//        double[] mas = new double[str.length];
//        for (int i = 0; i < str.length; i++) {
//            mas[i] = Double.valueOf(str[i]);
//        }
//        this.value = mas;
//    }

    @Override
    public String toString() {
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
