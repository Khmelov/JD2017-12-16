package by.it.karpeichyk.jd01_07;

/**
 * Created by user on 04.01.2018.
 */
public class Runner {
    public static void main(String[] args) {
        Scalar scalar1= new Scalar(3.12334545);
        System.out.println("scalar1="+scalar1);

        Scalar scalar2= new Scalar(scalar1);
        System.out.println("scalar2="+scalar2);

        Scalar scalar3= new Scalar("4.12545");
        System.out.println("scalar3="+scalar3);


        Vector vector1= new Vector(new double[]{1,2,4});
        System.out.println("vector1="+vector1);

        Vector vector2= new Vector(vector1);
        System.out.println("vector2="+vector2);

        Vector vector3=new Vector("{1,2,4}");
        System.out.println("vector3="+vector2);
    }
}
