package by.it.fyodorov.jd01_05;

import by.it.fyodorov.jd01_05.math.*;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        double x = 0.3;
        System.out.println(Task1.optionA(x));
        System.out.println(Task1.optionB(x));

        double a = 1.21;
        double b = 0.371;
        System.out.println(Task2.calculate(a,b));

        Task3.printTable();

        double c = 0.2;
        Task4.calculate(c);

        Task5.calculate();

        double[] aa = Task6.getArray();
        Task6 obj1 = new Task6();
        obj1.printArray(aa, "A");
        System.out.println();
        double[] bb = obj1.getEveryThridElement(aa);
        obj1.printArray(bb, "B");
        System.out.println();
        System.out.println(Task6.geometric(bb));

        //System.out.println((char)0x2550);


    }


}
