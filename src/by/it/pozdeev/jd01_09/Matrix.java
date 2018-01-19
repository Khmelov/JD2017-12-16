package by.it.pozdeev.jd01_09;

public class Matrix extends Var {
    private double[][] value;

    Matrix(double[][] value) {
        this.value = new double[value.length][value[0].length];
        for (int i = 0; i < this.value.length; i++) {
            System.arraycopy(value[i], 0, this.value[i], 0, value[i].length);
        }
    }

    Matrix(Matrix matrix) {
        this(matrix.value);
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append('{');
        for (int i = 0; i < value.length; i++) {
            result.append("{");
            for (int j = 0; j < value[0].length; j++) {
                result.append(value[i][j]);
                if (j != value[0].length-1 && i==value.length-1) result.append(", ");
                if (j != value[0].length-1 && i!=value.length-1) result.append(", ");
                if (j == value[0].length-1 && i!=value.length-1) result.append("}, ");
                if (j == value[0].length-1 && i==value.length-1) result.append("}");
            }
        }
        result.append('}');
        return result.toString();
    }

}
