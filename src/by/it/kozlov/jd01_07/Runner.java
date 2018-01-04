package by.it.kozlov.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Scalar scalar1=new Scalar(3.2154);
        System.out.println("scalar1="+scalar1);

        Scalar scalar2=new Scalar(scalar1);
        System.out.println("scalar2="+scalar2);

        Scalar scalar3=new Scalar(4.2154);
        System.out.println("scalar3="+scalar3);
    }
}
