package by.it.vshelukhin.jd01_13;

import java.util.*;

public class TaskC {

    static List<Double> list = new ArrayList<>();

    static String line = "";

    static int er_count = 0;

    static void readData() throws InterruptedException {
        try {
            list.add(0, Double.parseDouble(line));
        } catch (NumberFormatException e) {
            er_count++;
            if (er_count > 4) throw e;
            Thread.sleep(100);
            Iterator it = list.iterator();
            while (it.hasNext()){
                System.out.print(it.next()+" ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        line = sc.nextLine();
        while (!line.equals("END")) {
            readData();
            line = sc.nextLine();
        }
    }
}
