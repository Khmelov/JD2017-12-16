package by.it.patsko.jd02_04;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        FileReaderWriterCalc frwc;

        try {
            frwc = new FileReaderWriterCalc(
                    System.getProperty("user.dir") + "/src/by/it/patsko/jd02_04/", "vars.txt", "rw");
            frwc.readFileCalc();
        } catch (CalcException | IOException e) {
            e.printStackTrace();

        }

        Scanner sc = new Scanner(System.in);
        String line;
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (!(line = sc.nextLine()).equals("end")) {
            if (line.equals("printvar")) {
                printer.printvar();
                continue;
            }
            if (line.equals("sortvar")) {
                printer.sortvar();
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

        try {
            frwc = new FileReaderWriterCalc(
                    System.getProperty("user.dir") + "/src/by/it/patsko/jd02_04/", "vars.txt", "rw");
            frwc.writeFileCalc();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
