package by.it.sevashko.jd01_03;

public class Runner {

    public static void main(String[] args) {
        String line = "12 48 5 4 76 244 4 8 9 105 34 48 -15";
        double[] mas = InOut.getArray(line);
        InOut.printArray(mas);

        System.out.println("\nМассив Mas");
        String name = "Mas";
        InOut.printArray(mas, name, 5);

        System.out.println();
        double max = Helper.findMax(mas);
        double min = Helper.findMin(mas);
        System.out.println("Максимум max=" + max);
        System.out.println("Минимум min=" + min);

        System.out.println("\nОтсортированный массив");
        Helper.sort(mas);
        InOut.printArray(mas);

        System.out.println();
        double[][] matrix = {{1, 2, 3}, {4, 5, 6}, {1, 2, 3}};
        double[] vector = {7, 8, 9};
        double[] multipl1 = Helper.mul(matrix, vector);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%3.0f ", matrix[i][j]);
            }
            if (i ==  matrix.length/2) System.out.printf("  *  %3.0f  =  %3.0f", vector[i], multipl1[i]);
            else System.out.printf("     %3.0f     %3.0f", vector[i], multipl1[i]);
            System.out.println();

        }
//        InOut.printArray(multipl1);

        System.out.println();
        double[][] matrixleft = {{1, 2, 3}, {4, 5, 6}, {1, 2, 3}};
        double[][] matrixright = {{7, 9}, {5, 6}, {1, 2}};
        double[][] multipl2 = Helper.mul(matrixleft, matrixright);
        InOut.printArray2D(multipl2);
        System.out.println();
        InOut.printArray2D(multipl2, "Mas");
    }

}
