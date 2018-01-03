package by.it.kozlov.jd01_05;

import by.it.kozlov.jd01_05.math.*;

public class Main {

    public static void main(String[] args) {
        //Задача 1
        double x = 0.3;
        System.out.println(Task1.optionA(x));
        System.out.println(Task1.optionB(x));

        //Задача 2
        System.out.println(Task2.calculate(1.21, 0.371));

        //Задача 3
        Task3.printTable();

        //Задача 4
        Task4.calculate(0.2);

        //Задача 5
        Task5.calculate();
    }


}
