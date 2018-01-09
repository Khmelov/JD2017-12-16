package by.it.patsko.jd01_09;

/*
На уровень C разработайте для класса Var наследника Matrix с тремя конструкторами:
1. Из массива { { 1.0, 2.0 }, { 3.0, 4.0 } } сигнатура Matrix(double[ ][ ] value)
2. Из такой же точно переменной сигнатура Matrix(Matrix matrix)
3. Из строки вида { { 1.0, 2.0 }, { 3.0, 4.0 } } сигнатура Matrix(String strMatrix)
   Переопределите метод String toString() так, чтобы он возвращал строку вида { { 1.0, 2.0 }, { 3.0, 4.0 } }
 */


class Matrix extends Var {
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

    Matrix(String strMatrix) {
        strMatrix = strMatrix.substring(1, strMatrix.length() - 1).trim();
        String[] strRow = strMatrix.split(",\\s*(?=\\{.+\\})");
        this.value = new double[strRow.length][];
        String[] strCols;
        for (int i = 0; i < strRow.length; i++) {
            strRow[i] = strRow[i].substring(1, strRow[i].length() - 1).trim();
            strCols = strRow[i].split(",\\s*");
            this.value[i] = new double[strCols.length];
            for (int j = 0; j < strCols.length; j++) {
                this.value[i][j] = Double.parseDouble(strCols[j]);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append('{');
        for (int i = 0; i < this.value.length; i++) {
            result.append('{');
            for (int j = 0; j < this.value[i].length; j++) {
                result.append(this.value[i][j]);
                if (j != this.value[i].length - 1) result.append(", ");
            }
            result.append('}');
            if (i != this.value.length - 1) result.append(", ");
        }
        result.append('}');
        return result.toString();
    }
}
