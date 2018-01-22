package by.it.sendetskaya.calc;


public class Vector  extends Var {

    protected double [] value;

   private Vector(double[] value) {
        this.value = new  double[value.length];
        System.arraycopy(value,0,this.value,0,value.length);
    }

//    Vector(Vector vector)
//    {
//        this(vector.value);
//    }

    Vector (String strVector)
    {
        strVector=strVector.replaceAll("[,;}{]"," ");
        strVector=strVector.trim();
        String [] stringVector=strVector.split(" ");
        value= new double[stringVector.length];
        for (int i = 0; i < stringVector.length; i++) {
            value[i]=Double.parseDouble(stringVector[i]);
        }
    }


    @Override
    public String toString() {
        StringBuilder result=new StringBuilder();
        result.append('{');
        for (int i = 0; i < value.length; i++) {
            if (i>0)
                result.append(", ");
            result.append(value[i]);
        }
        result.append('}');

        return result.toString();
    }




    @Override
    public Var add(Var other) throws CalcException {
       //сложение векторов
        if (other instanceof Vector) {
            double [] valueZ= new double[Vector.this.value.length];
            if (Vector.this.value.length!=((Vector) other).value.length)
                throw new CalcException("Размеры векторов не совпадают");
            for (int i = 0; i < Vector.this.value.length; i++) {
                valueZ[i] = this.value[i] + ((Vector) other).value[i];
            }
            return new Vector(valueZ);  //когда скалар+скалар
        }
        //сложение вектора и числа
        else if (other instanceof Scalar) {
            double [] valueZ= new double[Vector.this.value.length];
            for (int i = 0; i < Vector.this.value.length; i++) {
                valueZ[i] = this.value[i] + ((Scalar) other).value;
            }
            return new Vector(valueZ);  //когда скалар+скалар
        }
        else {
            return other.add(this);   //перевызывается метод реализ в other
        }
    }


    @Override
    public Var sub(Var other) throws CalcException {
        double [] valueZ= new double[Vector.this.value.length];
        //вычитание векторов
        if (other instanceof Vector) {
            if (Vector.this.value.length!=((Vector) other).value.length)
                throw new CalcException("Размеры векторов не совпадают");
            for (int i = 0; i < Vector.this.value.length; i++) {
                valueZ[i] = this.value[i] - ((Vector) other).value[i];
            }
            return new Vector(valueZ);
        }

        //вычитание вектора и числа
        else if (other instanceof Scalar) {

            for (int j = 0; j < Vector.this.value.length; j++) {
                valueZ[j] = this.value[j] - ((Scalar) other).value;
            }
            return new Vector(valueZ);  //когда скалар+скалар
        }
        else {
            Scalar minus=new Scalar(-1);
            return other.sub(this).mul(minus);   //перевызывается метод реализ в other
        }
    }


    @Override
    public Var mul(Var other) throws CalcException {
        //умножение векторов
        if (other instanceof Vector) {
            double [] valueZ= new double[Vector.this.value.length];
            if (Vector.this.value.length!=((Vector) other).value.length)
                throw new CalcException("Размеры векторов не совпадают");
            for (int i = 0; i < Vector.this.value.length; i++) {
                valueZ[i] += this.value[i] * ((Vector) other).value[i];
            }
            return new Vector(valueZ);
        }
        //умножение вектора на число
        else if (other instanceof Scalar) {
            double [] valueZ= new double[Vector.this.value.length];
            for (int i = 0; i < Vector.this.value.length; i++) {
                valueZ[i] = this.value[i] * ((Scalar) other).value;
            }
            return new Vector(valueZ);
        }
        //умножение матрицы и вектора
        if (other instanceof Matrix) {
            double [] valueZ= new double[this.value.length];
            if (Vector.this.value.length!=((Matrix) other).value.length)
                throw new CalcException("Размер строки матрицы не совпадает с размеров вектора");
            for (int i = 0; i < ((Matrix)other).value.length; i++)
                for (int j = 0; j < this.value.length; j++)
                {
                    valueZ[i] += ((Matrix) other).value[i][j] * this.value[j];
                }
            return new Vector(valueZ);
        }

        else
            return other.mul(this);   //перевызывается метод реализ в other
    }



    //деление вектора на число
    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] valueZ = new double[Vector.this.value.length];
            double v = ((Scalar) other).value;
            if(v==0)
                throw new CalcException("Деление на ноль");
            for (int i = 0; i < Vector.this.value.length; i++) {
                valueZ[i] += this.value[i] * (1/v);
            }
            return new Vector(valueZ);
        }
        else
            throw new CalcException("Деление может быть только на скалярное число!");
    }
}
