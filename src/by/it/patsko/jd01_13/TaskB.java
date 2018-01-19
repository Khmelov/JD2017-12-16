package by.it.patsko.jd01_13;

import java.util.Scanner;

/*
TaskB.
В классе TaskB напишите цикл, который:
считывает данные из консоли построчно и закрывается при вводе в консоль слова END;
переводит каждую строку в вещественное число и выводит в консоль данное число
и сумму корней всех ранее введенных чисел, включая введенное;
если перевести ввод в число невозможно,
то программа перехватывает полученную ошибку и показывает сообщение в консоли сообщение,
такого же вида и формата, как в предыдущем задании
если невозможно извлечь корень, то обработка аналогична, но тип ошибки -ArithmeticException
 */
class TaskB {
    public static void main(String[] args) {
        String str;
        double num, sum = 0;
        Scanner sc = new Scanner(System.in);
        try {
            while (!(str = sc.nextLine()).equals("END")) {
                if ((num = Double.parseDouble(str)) < 0) throw new ArithmeticException();
                sum += num;
                System.out.println("num=" + num + "\n" + "sum=" + Math.sqrt(sum));
            }
        } catch (NullPointerException | NumberFormatException | ArithmeticException e) {
            System.out.println("name:" + e.getClass().getName());
            String ourName = TaskB.class.getName();
            StackTraceElement[] stackTraceElements = e.getStackTrace();
            for (StackTraceElement element : stackTraceElements) {
                String classname = element.getClassName();
                int linenumber = element.getLineNumber();
                if (ourName.equals(classname)) {
                    System.out.println("class:" + classname);
                    System.out.println("line:" + linenumber);
                    break;
                }
            }
        }

    }
}
