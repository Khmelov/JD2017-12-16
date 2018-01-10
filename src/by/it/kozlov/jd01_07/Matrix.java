package by.it.kozlov.jd01_07;

public class Matrix extends AbstractVar {

    private double[][] value;

    Matrix(double[][] value) {
        this.value = new double[value.length][value[0].length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    Matrix(Matrix matrix) {
        this(matrix.value);
    }

    Matrix(String strMatrix) {
        if (strMatrix.charAt(0) == ('{')) strMatrix = strMatrix.substring(1, strMatrix.length() - 1);
        int count = 0;
        for (int i = 0; i < strMatrix.length(); i++) {
            if (strMatrix.charAt(i) == ('}')) {
                count++;
            }
        }
        double[][] mas = new double[count][count];
        for (int i = 0; i < count; i++) {
            String[] str = strMatrix.split(",");
            int countStr = 0;
            for (int j = 0; j < count; j++) {
                for (int k = 0; k < count; k++) {
                    str[countStr] = test(str[countStr]);
                    mas[j][k] = Double.valueOf(str[countStr]);
                    countStr++;
                }
            }
        }
        this.value = mas;
    }

    static String test(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ('}')) {
                str = str.substring(0, str.length() - 1);
                return str;
            }
            if (str.charAt(i) == ('{')) {
                str = str.substring(1, str.length());
                return str;
            }
        }
        return str;
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
