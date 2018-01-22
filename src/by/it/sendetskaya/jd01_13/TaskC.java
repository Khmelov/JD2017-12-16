package by.it.sendetskaya.jd01_13;

import java.util.*;

//TaskC. Нужно написать в TaskC программу, которая будет вводить вещественные числа с консоли,
// после каждо  ошибки программа делает паузу в 100 мс и выводит накопленные числа в обратном
// порядке.
// Использу те Scanner, но он должен создаваться только один раз и обязательно в методе main.
// Код по чтению чисел с клавиатуры должен быть в методе static void readData().
// Еслипользовательввёлкако -тотекст,вместовводачисла,тометодreadData()долженперехватить
// исключение, сделать паузу Thread.sleep(100) и вывести на экран все ранее введенные числа.
// Числа нужно выводить без форматирования, через пробел, в порядке обратном вводу.
// После 5 допущенных ошибок программа должна завершиться, пробрасывая ошибку в JVM.
public class TaskC {
    Scanner sc;
    public static void main(String[] args) throws Exception {

        TaskC task=new TaskC();
           task.readData();
    }

    void readData() throws Exception {
        sc=new Scanner(System.in);;
        String line;
        int count=0;
        LinkedList<Double>list=new LinkedList<>();

        while (!(line = sc.nextLine()).equals("END")) {

            double data;

            try {
                data = Double.parseDouble(line.trim());
                list.add(data);


            } catch (NullPointerException|NumberFormatException e) {

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                if (count>=5)
                {
                    break;
                    //throw new Exception("Превышен лимит ошибок");
                }
                count++;

                Iterator it=list.descendingIterator();
                System.out.print("\n");
                        while (it.hasNext()) {
                                System.out.print(it.next());
                                System.out.print(" ");
                            }
                System.out.println();

            }


        }


    }
}
