package by.it.sendetskaya.jd02_06.calc;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) throws CalcException {
         Scanner sc=new Scanner(System.in);
         String line;
        Parser parser;
        Printer printer=new Printer();

        parser=new Parser();

        while (!(line = sc.nextLine()).equals("end")) {

            if (line.toLowerCase().contains("printvar"))
            {
                System.out.println(parser.calc(line.trim()));
                printer.printVar();
                continue;
            }

            try {
                System.out.println(parser.calc(line.trim()));
                printer.print(parser.calc(line.trim()));
            }
            catch (CalcException e) {

                System.out.println("ERROR: " + e.getMessage());
            }

        }

    }
}
