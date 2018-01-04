package by.it.krasutski.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Scalar scalar1=new Scalar(3.1234125);
        System.out.println("Scalar1="+scalar1);

        Scalar scalar2=new Scalar(scalar1);
        System.out.println("Scalar2="+scalar2);

        Scalar scalar3=new Scalar("5.123412");
        System.out.println("Scalar3="+scalar3);

        Vector vector1=new Vector(new double[]{1,2,3});
        System.out.println("Vector1="+vector1);

        Vector vector2=new Vector(vector1);
        System.out.println("Vector2="+vector2);
    }
}
