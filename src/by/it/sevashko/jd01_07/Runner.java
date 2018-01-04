package by.it.sevashko.jd01_07;

public class Runner {

    public static void main(String[] args) {
        double[] array = {1,2,3};
        Vector vector1 = new Vector(array);
        Vector vector2 = new Vector(vector1);
        System.out.print(vector2);
    }
}
