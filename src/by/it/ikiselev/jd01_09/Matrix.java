package by.it.ikiselev.jd01_09;

public class Matrix extends Var {

    private double[][] value;
    public Matrix(double[][] value){
        this.value=value;
    }
    public Matrix(Matrix matrix){
        this(matrix.value);
    }
    public Matrix(String matrix){
        String[] res1=matrix.split("},");
        String[] res11=res1[0].split(",");
        double[][] result = new double[res1.length][res11.length];
        for (int i = 0; i <res1.length ; i++) {
            res1[i]=res1[i].replace('{',' ').replace('}',' ').trim();
            String[] res2=res1[i].split(",");
            for (int j = 0; j < res11.length; j++) {
                result[i][j] =Double.parseDouble(res2[j]);
            }
        }
        this.value=result;
    }
    @Override
    public String toString() {
        //return  Arrays.toString(value).replace('[','{').replace(']','}');
        StringBuilder result=new StringBuilder();
        result.append("{{");
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                if (j>0) result.append(", ");
                result.append(value[i][j]);
            }
            if (i!=value.length-1)result.append("}, {");
        }
        result.append("}}");
        return result.toString();
    }
    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            Matrix res = new Matrix(this);
            for (int rowNumber = 0; rowNumber < this.value.length; rowNumber++) {
                for (int colNumber = 0; colNumber < this.value[rowNumber].length; colNumber++) {
                    res.value[rowNumber][colNumber] = res.value[rowNumber][colNumber] + ((Scalar) other).getValue();
                }
            }
            return  res;
        }
        if (other instanceof Matrix){
            Matrix res = new Matrix(this);
            for (int rowNumber = 0; rowNumber < this.value.length; rowNumber++) {
                for (int colNumber = 0; colNumber < this.value[rowNumber].length; colNumber++) {
                    res.value[rowNumber][colNumber] = res.value[rowNumber][colNumber] + ((Matrix) other).value[rowNumber][colNumber];
                }
            }
            return res;
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            Matrix res = new Matrix(this);
            for (int rowNumber = 0; rowNumber < this.value.length; rowNumber++) {
                for (int colNumber = 0; colNumber < this.value[rowNumber].length; colNumber++) {
                    res.value[rowNumber][colNumber] = res.value[rowNumber][colNumber] - ((Scalar) other).getValue();
                }
            }
            return  res;
        }
        if (other instanceof Matrix){
            Matrix res = new Matrix(this);
            for (int rowNumber = 0; rowNumber < this.value.length; rowNumber++) {
                for (int colNumber = 0; colNumber < this.value[rowNumber].length; colNumber++) {
                    res.value[rowNumber][colNumber] = res.value[rowNumber][colNumber] - ((Matrix) other).value[rowNumber][colNumber];
                }
            }
            return res;
        }
        return super.add(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            Matrix res = new Matrix(this);
            for (int rowNumber = 0; rowNumber < this.value.length; rowNumber++) {
                for (int colNumber = 0; colNumber < this.value[rowNumber].length; colNumber++) {
                    res.value[rowNumber][colNumber] = res.value[rowNumber][colNumber] * ((Scalar) other).getValue();
                }
            }
            return res;
        }
        if (other instanceof Vector){
            double[] res = new double[this.value.length];
            for (int rowNumber = 0; rowNumber < this.value.length; rowNumber++) {
                for (int colNumber = 0; colNumber < this.value[rowNumber].length; colNumber++) {
                    res[rowNumber] = res[rowNumber] + this.value[rowNumber][colNumber] * ((Vector) other).getValue()[colNumber];
                }
            }
            return new Vector(res);
        }
        if (other instanceof Matrix){
            double[][] res = new double[this.value.length][((Matrix) other).value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int m = 0; m < ((Matrix) other).value[0].length; m++) {
                    for (int j = 0; j < this.value[0].length; j++) {
                        res[i][m] = res[i][m] + this.value[i][j] * ((Matrix) other).value[j][m];
                    }
                }
            }
            return new Matrix(res);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            Matrix res = new Matrix(this);
            for (int rowNumber = 0; rowNumber < this.value.length; rowNumber++) {
                for (int colNumber = 0; colNumber < this.value[rowNumber].length; colNumber++) {
                    res.value[rowNumber][colNumber] = res.value[rowNumber][colNumber] / ((Scalar) other).getValue();
                }
            }
            return res;
        }
        return super.div(other);
    }
}
