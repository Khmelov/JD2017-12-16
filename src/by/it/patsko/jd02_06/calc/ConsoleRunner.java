package by.it.patsko.jd02_06.calc;

import java.io.IOException;
import java.util.Scanner;

class ConsoleRunner {
    static ReportBuilder[] reports = {new FullReport(), new ShortReport()};

    public static void main(String[] args) {
        reports[0].writeHeader();
        reports[0].writeStartSession();
        reports[1].writeHeader();
        reports[1].writeStartSession();

        FileReaderWriterCalc frwc;

        try {
            frwc = new FileReaderWriterCalc(
                    System.getProperty("user.dir") + "/src/by/it/patsko/jd02_06/calc/", "vars.txt", "rw");
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

                reports[0].writeOperation(line + " ==> "+result + "\n");
                reports[1].writeOperation(line + " ==> "+result + "\n");
            } catch (CalcException | NullPointerException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
        reports[0].writeEndSession();
        reports[1].writeEndSession();
        reports[0].printReport();
        reports[1].printReport();
        try {
            frwc = new FileReaderWriterCalc(
                    System.getProperty("user.dir") + "/src/by/it/patsko/jd02_06/calc/", "vars.txt", "rw");
            frwc.writeFileCalc();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
