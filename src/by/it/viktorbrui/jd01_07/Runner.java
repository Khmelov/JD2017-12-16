package by.it.viktorbrui.jd01_07;

public class Runner {

    public static void main(String[] args) {
        Scalar scalar1 = new Scalar(5.28);
        Scalar scalar2 = new Scalar(scalar1);
        Scalar scalar3 = new Scalar("58.64");
        System.out.println(scalar1);
        System.out.println(scalar2);
        System.out.println(scalar3);

        double[] vectorArray = {1,2,3};
        Vector vector1 = new Vector(vectorArray);
        Vector vector2 = new Vector(vector1);
        Vector vector3 = new Vector("[15.23, 58.49, 0.98]");
        System.out.println(vector1);
        System.out.println(vector2);
        System.out.println(vector3);

        double[][] matrixArray = {{1, 2, 3}, {4, 5, 6}};
        Matrix matrix1 = new Matrix(matrixArray);
        Matrix matrix2 = new Matrix(matrix1);
        Matrix matrix3 = new Matrix("{{12.2, 948.01}, {84.4, 11.0}}");
        System.out.println(matrix1);
        System.out.println(matrix2);
        System.out.println(matrix3);
    }
}
