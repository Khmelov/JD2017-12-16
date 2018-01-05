package by.it.pozdeev.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Scalar scalar1=new Scalar(3.123345554);
        System.out.println("scalar1="+scalar1);

        Scalar scalar2=new Scalar(scalar1);
        System.out.println("scalar2="+scalar2);

        Vector vector1=new Vector(new double[]{1,2,3});
    }
}
