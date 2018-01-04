package by.it.Shalukhin.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Scalar scal1 = new Scalar(3.1215);
        System.out.println("scal1 = "+scal1);
        Scalar scal2 = new Scalar(scal1);
        Scalar scal3 = new Scalar("1.364");

        Vector vector = new Vector(new double[]{1.32,2.56,3.64});
        System.out.println(vector.toString());
    }
}
