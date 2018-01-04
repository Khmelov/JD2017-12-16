package by.it.fyodorov.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Scalar scalar1= new Scalar(3.12123);
        System.out.println("Scalar1="+scalar1);

        Scalar scalar2= new Scalar(scalar1);
        System.out.println("Scalar2="+scalar2);

        Scalar scalar3= new Scalar("3.134");


        Vector vector1=new Vector(new double[]{1,2,3});
        System.out.println("vector1="+vector1);

        Vector vector2=new Vector(vector1);
        System.out.println("vector2="+vector2);
    }
}
