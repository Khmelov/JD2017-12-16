package by.it.sendetskaya.calc;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) throws CalcException {
         Scanner sc=new Scanner(System.in);
         String line;
        Parser parser;

        parser=new Parser();

        Printer printer=new Printer();

        while (!(line = sc.nextLine()).equals("end")) {
            Var result = null;
            try {
                result = parser.calc(line.trim());
                printer.print(result);
            } catch (CalcException e) {

                System.out.println("ERROR: " + e.getMessage());
               // System.out.println("ERROR: " + e.getCause());
            }

        }

    }
}
