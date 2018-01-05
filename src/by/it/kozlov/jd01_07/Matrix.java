package by.it.kozlov.jd01_07;

import java.util.Arrays;

public class Matrix extends AbstractVar {

    private double[][] value;

    Matrix(double[][] value) {
        this.value = new double[value.length][value[0].length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append('{');
        for (int i = 0; i < value.length; i++) {
            if (i > 0) result.append(", ");
            result.append('{');
            for (int j = 0; j < value[i].length; j++) {
                if (j > 0) result.append(", ");
                result.append(value[i][j]);
            }
            result.append('}');
        }
        result.append('}');
        return result.toString();
    }
}
