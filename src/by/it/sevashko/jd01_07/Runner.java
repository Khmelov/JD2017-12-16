package by.it.sevashko.jd01_07;

public class Runner {

    public static void main(String[] args) {
        double[] vectorArray = {1,2,3};
        Vector vector1 = new Vector(vectorArray);
        Vector vector2 = new Vector(vector1);
        System.out.println(vector2);

        double[][] matrixArray = {{1, 2, 3}, {4, 5, 6}};
        Matrix matrix1 = new Matrix(matrixArray);
        System.out.println(matrix1);
    }
}
