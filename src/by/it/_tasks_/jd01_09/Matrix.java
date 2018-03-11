package by.it._tasks_.jd01_09;

import java.util.Arrays;

public class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value) {
        this.value = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            System.arraycopy(value[i], 0, this.value[i], 0, value.length);
        }
    }

    Matrix(String strValue) {
        String[] rows = strValue.split("},");
        String[][] cells = new String[rows.length][0];
        for (int i = 0; i < rows.length; i++) {
            cells[i] = rows[i]
                    .replace('{', ' ').replace('}', ' ')
                    .trim().split(",\\s*");
        }
        value = new double[cells.length][cells[0].length];
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                value[i][j] = Double.parseDouble(cells[i][j]);
            }
        }
    }

    Matrix(Matrix m) {
        this(m.value);
    }

    @Override
    public Var add(Var otherVar) {
        if (otherVar instanceof Matrix) {
            Matrix res = new Matrix(this);
            for (int i = 0; i < res.value.length; i++)
                for (int j = 0; j < res.value[i].length; j++)
                    res.value[i][j] += ((Matrix) otherVar).value[i][j];
            return res;
        } else if (otherVar instanceof Scalar) {
            Matrix res = new Matrix(this.value);
            for (int i = 0; i < res.value.length; i++)
                for (int j = 0; j < res.value.length; j++)
                    res.value[i][j] += ((Scalar) otherVar).getValue();
            return res;
        } else
            return super.add(otherVar);
    }

    @Override
    public Var sub(Var otherVar) {
        if (otherVar instanceof Matrix) {
            Matrix res = new Matrix(this);
            for (int i = 0; i < res.value.length; i++)
                for (int j = 0; j < res.value[i].length; j++)
                    res.value[i][j] -= ((Matrix) otherVar).value[i][j];
            return res;
        } else if (otherVar instanceof Scalar) {
            Matrix res = new Matrix(this.value);
            for (int i = 0; i < res.value.length; i++)
                for (int j = 0; j < res.value.length; j++)
                    res.value[i][j] -= ((Scalar) otherVar).getValue();
            return res;
        } else
            return super.sub(otherVar);
    }

    @Override
    public Var mul(Var otherVar) {
        if (otherVar instanceof Matrix) {
            double[][] l = this.value;
            double[][] r = ((Matrix) otherVar).value;
            double res[][] = new double[l.length][r[0].length];
            for (int i = 0; i < l.length; i++)
                for (int j = 0; j < r[0].length; j++)
                    for (int k = 0; k < r.length; k++) {
                        res[i][j] += l[i][k] * r[k][j];
                    }
            return new Matrix(res);
        } else if (otherVar instanceof Vector) {
            double[][] m = this.value;
            double[] v = ((Vector) otherVar).getValue();
            double res[] = new double[m.length];
            for (int i = 0; i < res.length; i++)
                for (int j = 0; j < v.length; j++)
                        res[i] += m[i][j] * v[j];
            return new Vector(res);

        } else if (otherVar instanceof Scalar) {
            Matrix res = new Matrix(this.value);
            for (int i = 0; i < res.value.length; i++)
                for (int j = 0; j < res.value.length; j++)
                    res.value[i][j] += ((Scalar) otherVar).getValue();
            return res;
        } else

            return super.add(otherVar);
    }

    @Override
    public Var div(Var otherVar) {
        if (otherVar instanceof Scalar) {
            Matrix res = new Matrix(this.value);
            for (int i = 0; i < res.value.length; i++)
                for (int j = 0; j < res.value.length; j++)
                    res.value[i][j] /= ((Scalar) otherVar).getValue();
            return res;
        } else
            return super.div(otherVar);
    }

    @Override
    public String toString() {
        String[] rows = new String[value.length];

        for (int i = 0; i < value.length; i++) {
            rows[i] = Arrays.toString(value[i]);
        }

        return Arrays.toString(rows)
                .replace('[', '{')
                .replace(']', '}');
    }
}
