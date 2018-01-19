package by.it.patsko.jd01_13;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/*
TaskC
Нужно написать в TaskC программу, которая будет вводить вещественные числа с консоли,
после каждой ошибки программа делает паузу в 100 мси выводит накопленные числа в обратном порядке.
Используйте Scanner, но он должен создаваться только один рази обязательно в методе main.
Код по чтению чисел с клавиатуры должен быть в методе static void readData().
Если пользователь ввёл какой-то текст, вместо ввода числа, то метод readData() должен перехватить исключение,
сделать паузу Thread.sleep(100)и вывести на экран все ранее введенные числа.
Числа нужно выводить без форматирования,через пробел, в порядке обратном вводу.
После 5 допущенных ошибок программа должна завершиться, пробрасывая ошибку в JVM.
 */
class TaskC {
    private static int counter = 0;
    private static Deque<Double> stack = new LinkedList<>();
    private static Scanner scanner;

    static void readData() {
        try {
            while (true) {
                stack.add(Double.parseDouble(scanner.nextLine()));
            }
        } catch (NumberFormatException e) {
            counter++;
            if (counter < 5) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e1) {
                }
                double num;
                for (int i = 0; i < stack.size(); i++) {
                    num = stack.removeLast();
                    System.out.print(num + " ");
                    stack.addFirst(num);
                }
            } else throw e;
        }
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        while (true) {
            TaskC.readData();
        }
    }
}