package by.it.krasutski.jd02_04;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (!(line = sc.nextLine()).equals("end")) {
            if (line.equals("print")) {
                printer.printVariable();
                continue;
            }
            if (line.equals("sort")) {
                printer.sortVariable();
                continue;
            }
            String result;
            try {
                result = parser.calc(line.trim());
                printer.print(result);
            } catch (CalcException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }

    }
}
