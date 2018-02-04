package by.it.krasutski.calc;

class Matrix extends Var {
    private double[][] value;

    private Matrix(double[][] value) {
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
                if (j != this.value[i].length - 1) result.append(",");
            }
            result.append('}');
            if (i != this.value.length - 1) result.append(",");
        }
        result.append('}');
        return result.toString();
    }

    @Override
    public Var add(Var other) throws CalcException {
        double[][] result = new double[this.value.length][this.value[0].length];
        if (other instanceof Scalar) {
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = this.value[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        } else if (other instanceof Matrix &&
                this.value.length == ((Matrix) other).value.length &&
                this.value[0].length == ((Matrix) other).value[0].length) {
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = this.value[i][j] + ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(result);
        } else throw new CalcException(" Операция невозможна ");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        double[][] result = new double[this.value.length][this.value[0].length];
        if (other instanceof Scalar) {
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = this.value[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        } else if (other instanceof Matrix &&
                this.value.length == ((Matrix) other).value.length &&
                this.value[0].length == ((Matrix) other).value[0].length) {
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = this.value[i][j] - ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(result);
        } else throw new CalcException(" Операция невозможна ");
    }

    @Override
    public Var mul(Var other) throws CalcException {

        if (other instanceof Scalar) {
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = this.value[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        } else if (other instanceof Vector &&
                this.value[0].length == ((Vector) other).getValue().length) {
            double[] result = new double[this.value.length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < ((Vector) other).getValue().length; j++) {
                    result[i] += this.value[i][j] * ((Vector) other).getValue(j);
                }
            }
            return new Vector(result);
        } else if (other instanceof Matrix &&
                this.value[0].length == ((Matrix) other).value.length) {
            double[][] result = new double[this.value.length][((Matrix) other).value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    for (int k = 0; k < ((Matrix) other).value.length; k++) {
                        result[i][j] += this.value[i][k] * ((Matrix) other).value[k][j];
                    }
                }
            }
            return new Matrix(result);
        } else throw new CalcException(" Операция невозможна ");
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            if (((Scalar) other).getValue() == 0) throw new CalcException(" Деление на 0 ");
            else return this.mul(new Scalar(1 / ((Scalar) other).getValue()));
        } else throw new CalcException(" Операция невозможна ");
    }
}