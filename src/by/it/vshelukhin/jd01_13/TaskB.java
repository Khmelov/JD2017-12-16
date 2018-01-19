package by.it.vshelukhin.jd01_13;

import java.util.*;

public class TaskB {
    public static void main(String[] args) {
        List<Double> data = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        while (!line.equals("END")) {
            try {
                double temp = Double.valueOf(line);
                if (temp < 0) throw new ArithmeticException();
                data.add(temp);
                Iterator itData = data.iterator();
                double sumSquare = 0;
                while (itData.hasNext()) {
                    sumSquare = sumSquare + Math.sqrt((double) itData.next());
                }
                Formatter f = new Formatter();
                f.format("Введённое число: %5.2f\tСумма корней: %5.2f", data.get(data.size() - 1), sumSquare);
                System.out.println(f.toString().replace(",",".").replace(",","."));
            }
            catch (NumberFormatException | ArithmeticException e) {
                System.out.println("name: " + e.getClass().getName());
                for (StackTraceElement stt : e.getStackTrace()) {
                    if (stt.getClassName().equals(TaskB.class.getName()))
                        System.out.println("class: " + stt.getClassName() + "\nline: " + stt.getLineNumber());
                }
            }
            line = sc.nextLine();
        }
    }
}
