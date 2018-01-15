package by.it.kozlov.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        String line;
        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (!(line = sc.nextLine()).equals("end")) {
            Var result = parser.calc(line.trim());
            printer.print(result);
        }
    }
}
