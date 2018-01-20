package by.it.pozdeev.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Scalar scalar1=new Scalar(3.12334545);
        System.out.println("scalar1="+scalar1);

        Scalar scalar2=new Scalar(scalar1);
        System.out.println("scalar2="+scalar2);

        Scalar scalar3=new Scalar("4.12545");
        System.out.println("scalar3="+scalar3);

        Vector vector1=new Vector(new double[]{1,2,3});
        System.out.println("vector1="+vector1);

        Vector vector2=new Vector(vector1);
        System.out.println("vector2="+vector2);

        Matrix matrix1=new Matrix("{{1.0,2.0},{3.0,4.0}}");
        System.out.println("matrix="+matrix1);
    }
}
