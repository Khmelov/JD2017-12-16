package by.it.sendetskaya.calcV2;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) throws CalcException {
         Scanner sc=new Scanner(System.in);
         String line;
        Parser parser;

        parser=new Parser();

        while (!(line = sc.nextLine()).equals("end")) {
            if (line.toLowerCase().contains("printvar"))
            {
                System.out.println(VarsMap.printvar());
                continue;
            }

            try {
                System.out.println(parser.calc(line.trim()));
            }
            catch (CalcException e) {

                System.out.println("ERROR: " + e.getMessage());
            }

        }

    }
}
