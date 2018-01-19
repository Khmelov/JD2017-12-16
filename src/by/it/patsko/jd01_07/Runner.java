package by.it.patsko.jd01_07;


class Runner {
    public static void main(String[] args) {
        Scalar scalar1=new Scalar(Math.PI);
        System.out.println("scalar1="+scalar1);

        Scalar scalar2=new Scalar(scalar1);
        System.out.println("scalar2="+scalar2);

        Scalar scalar3=new Scalar("4.12345");
        System.out.println("scalar3="+scalar3);

        Vector vector1=new Vector(new double[]{1,2,3});
        System.out.println("vector1="+vector1);

        Vector vector2=new Vector(vector1);
        System.out.println("vector2="+vector2);

        Vector vector3=new Vector("{1, 2, 3}");
        System.out.println("vector3="+vector3);

        Matrix matrix1=new Matrix(new double[][]{ { 1.0, 2.0 }, { 3.0, 4.0 } });
        System.out.println("matrix1="+matrix1);

        Matrix matrix2=new Matrix(matrix1);
        System.out.println("matrix2="+matrix2);

        Matrix matrix3=new Matrix("{ { 1.0, 2.0 }, { 3.0, 4.0 },{5.0,6} }");
        System.out.println("matrix3="+matrix3);

    }
}
