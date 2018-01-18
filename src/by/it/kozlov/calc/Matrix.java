package by.it.kozlov.calc;

public class Matrix extends Var {

    private double[][] value;

    @Override
    public Var add(Var other) throws CalcException {
        double[][] add = new double[value.length][value[0].length];
        if (other instanceof Scalar) {
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    add[i][j] = value[i][j] + ((Scalar) other).value;
                }
            }
            return new Matrix(add);
        }
        if (other instanceof Matrix) {
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    add[i][j] = value[i][j] + ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(add);
        } else
            return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        double[][] sub = new double[value.length][value[0].length];
        if (other instanceof Scalar) {
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    sub[i][j] = value[i][j] - ((Scalar) other).value;
                }
            }
            return new Matrix(sub);
        }
        if (other instanceof Matrix) {
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    sub[i][j] = value[i][j] - ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(sub);
        } else
            return other.sub(this);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] mul = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    mul[i][j] = value[i][j] * ((Scalar) other).value;
                }
            }
            return new Matrix(mul);
        }
        if (other instanceof Vector) {
            double[] mul = new double[value.length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    mul[i] = mul[i] + value[i][j] * ((Vector) other).value[j];
                }
            }
            return new Vector(mul);
        }
        if (other instanceof Matrix) {
            double[][] mul = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < ((Matrix) other).value[0].length; j++) {
                    double sum = 0;
                    for (int k = 0; k < ((Matrix) other).value.length; k++) {
                        sum = sum + value[i][k] * ((Matrix) other).value[k][j];
                    }
                    mul[i][j] = sum;
                }
            }
            return new Matrix(mul);
        } else
            return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] div = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    div[i][j] = value[i][j] / ((Scalar) other).value;
                }
            }
            return new Matrix(div);
        } else {
            return other.add(this);
        }
    }

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this(matrix.value);
    }

    Matrix(String strMatrix) {
        strMatrix = strMatrix.replace('{', ' ').replace('}', ' ').trim();
        String[] el = strMatrix.split(",");
        value = new double[el.length / 2][el.length / 2];
        int i = 0, j = 0, k = 0;
        while (i < value.length) {
            value[i][j++] = Double.parseDouble(el[k++]);
            if (j == value.length) {
                i++;
                j = 0;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append('{');
        for (int i = 0; i < value.length; i++) {
            result.append('{');
            for (int j = 0; j < value[i].length; j++) {
                if (j > 0) result.append(", ");
                result.append(value[i][j]);
            }
            result.append('}');
            if (i < value.length - 1) {
                result.append(", ");
            }
        }
        result.append('}');
        return result.toString();
    }
}
