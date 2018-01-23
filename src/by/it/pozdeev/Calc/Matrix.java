package by.it.pozdeev.Calc;

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

    Matrix(String strMatrix) {
        String[] str = strMatrix.substring(2, strMatrix.length() - 2).split(",");
        for (int i = 0; i < str.length; i++) {
            str[i] = str[i].replaceAll("}", " ");
            str[i] = str[i].replaceAll("\\{", " ");
            str[i] = str[i].trim();
        }
        int a = 0;
        this.value = new double[str.length / 2][str.length / 2];
        for (int i = 0; i < str.length / 2; i++) {
            for (int j = 0; j < str.length / 2; j++) {
                this.value[i][j] = Double.parseDouble(str[a++]);
            }

        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append('{');
        for (int i = 0; i < value.length; i++) {
            result.append("{");
            for (int j = 0; j < value[0].length; j++) {
                result.append(value[i][j]);
                if (j != value[0].length - 1 && i == value.length - 1) result.append(", ");
                if (j != value[0].length - 1 && i != value.length - 1) result.append(", ");
                if (j == value[0].length - 1 && i != value.length - 1) result.append("}, ");
                if (j == value[0].length - 1 && i == value.length - 1) result.append("}");
            }
        }
        result.append('}');
        return result.toString();
    }


    public Var add(Var other) {

        if (other instanceof Scalar) {
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = this.value[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        } else if (other instanceof Vector && this.value[0].length == ((Vector) other).getValue().length) {
            double[] result = new double[this.value.length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < ((Vector) other).getValue().length; j++) {
                    result[i] = result[i] + this.value[i][j] + ((Vector) other).getValue(j);
                }
            }
            return new Vector(result);

        } else if (other instanceof Matrix && this.value.length == ((Matrix) other).value.length && this.value[0].length == ((Matrix) other).value[0].length) {
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = this.value[i][j] + ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(result);
        } else return super.add(other);
    }

    @Override
    public Var sub(Var other) {

        if (other instanceof Scalar) {
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = this.value[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        } else if (other instanceof Vector && this.value[0].length == ((Vector) other).getValue().length) {
            double[] result = new double[this.value.length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < ((Vector) other).getValue().length; j++) {
                    result[i] = result[i] + this.value[i][j] - ((Vector) other).getValue(j);
                }
            }
            return new Vector(result);
        } else if (other instanceof Matrix && this.value.length == ((Matrix) other).value.length && this.value[0].length == ((Matrix) other).value[0].length) {
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = this.value[i][j] - ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(result);
        } else return super.sub(other);
    }

    @Override
    public Var mul(Var other) {

        if (other instanceof Scalar) {
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = this.value[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        } else if (other instanceof Vector && this.value[0].length == ((Vector) other).getValue().length) {
            double[] result = new double[this.value.length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < ((Vector) other).getValue().length; j++) {
                    result[i] = result[i] + this.value[i][j] * ((Vector) other).getValue(j);
                }
            }
            return new Vector(result);
        } else if (other instanceof Matrix && this.value[0].length == ((Matrix) other).value.length) {
            double[][] result = new double[this.value.length][((Matrix) other).value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    for (int l = 0; l < ((Matrix) other).value.length; l++) {
                        result[i][j] = result[i][j] + this.value[i][l] * ((Matrix) other).value[l][j];
                    }
                }
            }
            return new Matrix(result);
        } else return super.mul(other);
    }

    @Override
    public Var div(Var other) throws ArithmeticException {
        if (other instanceof Scalar) {
            if (((Scalar) other).getValue() == 0) throw new ArithmeticException("Division by zero");
            else return this.mul(new Scalar(1 / ((Scalar) other).getValue()));
        } else return super.div(other);
    }
}
