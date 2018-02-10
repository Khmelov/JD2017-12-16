package by.it.vshelukhin.calc;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        Singleton loger = Singleton.getLoger();
        StatisticInfo statInf = new StatisticInfo();
        Scanner sc = new Scanner(System.in);
        String line;

        Parser parser = new Parser();
        Printer printer = new Printer();
        while (!(line = sc.nextLine()).equals("end")) {
            if (line.equals("printvar")) {
                printer.printvar();
                Data.writeMapInFile();
                statInf.setEvents(line,"Напечатан перечень сохранённых переменных",null);
                continue;
            }
            if (line.equals("sortvar")) {
                printer.sortvar();
                statInf.setEvents(line,"Напечатан перечень сохранённых переменных",null);
                continue;
            }
            try {
                Var result = parser.calc(line.trim());
                printer.print(result);
                statInf.setEvents(line,result.toString(),null);
            } catch (CalcException cEx) {
                System.out.println("ERROR: " + cEx.getMessage());
                loger.writeLog(cEx.getMessage());
                statInf.setEvents(line,cEx.getMessage(),cEx);
            }
        }
        statInf.setEndSession();
        ReportDirector reportDirector = new ReportDirector();
        reportDirector.setReportMaker(new ReportMakerShort());
        reportDirector.makeReport();
        reportDirector.setReportMaker(new ReportMakerFull());
        reportDirector.makeReport();
    }
}
