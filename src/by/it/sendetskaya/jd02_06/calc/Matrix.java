package by.it.sendetskaya.jd02_06.calc;

class Matrix extends Var {

    protected double [][] value;

    private Matrix(double[][]value)
    {
        this.value = new  double[value.length][value.length];
        System.arraycopy(value,0,this.value,0,value.length);

    }

    Matrix(Matrix matrix)
    {
        this(matrix.value);
    }


    Matrix(String strMatrix)
    {
        strMatrix=strMatrix.replaceAll("[,;}{]"," ");
        strMatrix=strMatrix.trim();
        String [] strMat=strMatrix.split(" {2,}");
        //String[] strMatReady=new String[strMat.length];
        value= new double[strMat.length][];
        for (int i = 0; i < strMat.length; i++) {
            strMat[i]=strMat[i].trim();
            String[] strMatReady= (strMat[i].split(" +"));
            this.value[i] = new double[strMatReady.length];
            for (int j = 0; j < strMatReady.length; j++) {
                value[i][j]=Double.parseDouble(strMatReady[j]);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result=new StringBuilder();
        result.append('{');
        for (int i = 0; i < value.length; i++){
            result.append('{');
            for (int j = 0; j < value[0].length; j++) {
                if (j > 0)
                    result.append(",");
                result.append(value[i][j]);
            }
            if(i<value.length-1)
                result.append("},");
            else result.append('}');
        }
        result.append('}');

        return result.toString();
    }


    @Override
    public Var add(Var other) throws CalcException {
        //сложение матриц
        if (other instanceof Matrix) {
            double [][] valueZ= new double[Matrix.this.value.length][((Matrix) other).value.length];
            if (Matrix.this.value.length!=((Matrix) other).value.length)
                throw new CalcException("Размер строки матрицы не совпадает с размером столбца другой матрицы");
            if (Matrix.this.value[0].length!=((Matrix) other).value[0].length)
                throw new CalcException("Размер столбца матрицы не совпадает с размером столбца другой матрицы");
            for (int i = 0; i < Matrix.this.value.length; i++)
                for (int j = 0; j < ((Matrix) other).value.length; j++)
                {
                valueZ[i][j] = this.value[i][j] + ((Matrix) other).value[i][j];
            }
            return new Matrix(valueZ);
        }
        //сложение числа и матрицы
        else if (other instanceof Scalar) {
            double [][] valueZ= new double[Matrix.this.value.length][Matrix.this.value.length];
            for (int i = 0; i < valueZ.length; i++)
                for (int j = 0; j < valueZ[0].length; j++)
                {
                    valueZ[i][j] = this.value[i][j] + ((Scalar) other).value;
                }
            return new Matrix(valueZ);
        }

        else {
            return other.add(this);
        }
    }


    @Override
    public Var sub(Var other) throws CalcException {
        //вычитание матриц
        if (other instanceof Matrix) {
            double [][] valueZ= new double[Matrix.this.value.length][((Matrix) other).value.length];
            if (this.value.length!=((Matrix) other).value.length)
                throw new CalcException("Размер строки матрицы не совпадает с размером столбца другой матрицы");
            if (Matrix.this.value[0].length!=((Matrix) other).value[0].length)
                throw new CalcException("Размер столбца матрицы не совпадает с размером столбца другой матрицы");

            for (int i = 0; i < Matrix.this.value.length; i++)
                for (int j = 0; j < ((Matrix) other).value.length; j++)
                {
                    valueZ[i][j] = this.value[i][j] - ((Matrix) other).value[i][j];
                }

            return new Matrix(valueZ);
        }
        //вычитание числа и матрицы
        else if (other instanceof Scalar) {
            double [][] valueZ= new double[Matrix.this.value.length][Matrix.this.value.length];
            for (int i = 0; i < Matrix.this.value.length; i++)
                for (int j = 0; j < Matrix.this.value[0].length; j++)
                {
                    valueZ[i][j] = this.value[i][j] - ((Scalar) other).value;
                }
            return new Matrix(valueZ);
        }

        else {
            Scalar minus=new Scalar(-1);
            return other.sub(this).mul(minus);   //перевызывается метод реализ в other
        }
    }


    @Override
    public Var mul(Var other) throws CalcException {

        //умножение матриц
        if (other instanceof Matrix) {
            double [][] valueZ= new double[Matrix.this.value.length][((Matrix) other).value[0].length];
            if (Matrix.this.value.length!=((Matrix) other).value[0].length)
                throw new CalcException("Размер строки матрицы не совпадает с размером столбца другой матрицы");
            if (Matrix.this.value[0].length!=((Matrix) other).value[0].length)
                throw new CalcException("Размер столбца матрицы не совпадает с размером столбца другой матрицы");

            for (int i = 0; i < Matrix.this.value.length; i++)
                for (int j = 0; j < ((Matrix) other).value[0].length; j++)
                    for (int k = 0; k < ((Matrix) other).value.length; k++)
                {
                    valueZ[i][j] += this.value[i][k] * ((Matrix) other).value[k][j];
                }
            return new Matrix(valueZ);
        }

        //умножение числа и матрицы
        else if (other instanceof Scalar) {
            double [][] valueZ= new double[Matrix.this.value.length][Matrix.this.value.length];
            for (int i = 0; i < valueZ.length; i++)
                for (int j = 0; j < valueZ[0].length; j++)
                {
                    valueZ[i][j] = this.value[i][j] * ((Scalar) other).value;
                }
            return new Matrix(valueZ);
        }

        else
            return other.mul(this);   //перевызывается метод реализ в other
    }



    //деление матрицы на число
    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double [][] valueZ= new double[Matrix.this.value.length][Matrix.this.value.length];
            double v = ((Scalar) other).value;
            if(v==0)
                throw new CalcException("Деление на ноль");
            for (int i = 0; i < valueZ.length; i++)
                for (int j = 0; j < valueZ[0].length; j++)
                {
                    valueZ[i][j] += this.value[i][j] * (1/v);
                }
            return new Matrix(valueZ);
        }
        else
            throw new CalcException(String.format("Деление %s/%s невозможно",other.toString(),this.value.toString()));
    }
}
