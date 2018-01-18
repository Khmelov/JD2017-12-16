package by.it.patsko.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws CalcException {
        Scanner sc = new Scanner(System.in);
        String line;
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (!(line = sc.nextLine()).equals("end")) {
            Var result = parser.calc(line.trim());
            printer.print(result);
            printer.printvar();
            printer.sortvar();
        }
    }
}
