package by.it.sevashko.calc;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;

        Parser parser = new Parser();
        Printer printer = new Printer();
        while (!(line=sc.nextLine()).equals("end")){
            if (line.equals("printvar")){
                System.out.println(Container.printVar());
                continue;
            }
            if (line.equals("sortvar")){
                System.out.println(Container.sortVar());
                continue;
            }
            try {
                Var result = parser.calc(line.trim());
                printer.print(result);
            } catch (CalcException exception){
                System.out.println(exception.getMessage());
            }
        }
    }
}
