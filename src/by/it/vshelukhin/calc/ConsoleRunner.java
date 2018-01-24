package by.it.vshelukhin.calc;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ConsoleRunner {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line;

        Parser parser = new Parser();
        Printer printer = new Printer();
        while (!(line = sc.nextLine()).equals("end")) {
            if (line.equals("printvar")) {
                printer.printvar();
                Data.writeMapInFile();
                continue;
            }
            if (line.equals("sortvar")) {
                printer.sortvar();
                continue;
            }
            try {
                Var result = parser.calc(line.trim());
                printer.print(result);
            } catch (CalcException cEx) {
                System.out.println("ERROR: " + cEx.getMessage());
            }
        }
    }
}
