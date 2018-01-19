package by.it.patsko.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws CalcException {
        Scanner sc = new Scanner(System.in);
        String line;
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (!(line = sc.nextLine()).equals("end")) {
            if(line.equals("printvar")){
                printer.printvar();
                continue;
            }
            if(line.equals("sortvar")){
                printer.sortvar();
                continue;
            }
            Var result;
            try{
                result = parser.calc(line.trim());
                printer.print(result);
            }catch (CalcException e){
                System.out.println("ERROR: "+e.getMessage());
            }
        }
    }
}
