package by.it.sevashko.jd02_06;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;

        Parser parser = new Parser();
        Printer printer = new Printer();
        while (!(line=sc.nextLine()).equals("end")){
            SingleLogger logger = SingleLogger.getInstance();
            logger.writeLog("Ввод строки: "+line);
            if (line.equals("printvar")){
                System.out.println(Container.printVar());
                continue;
            }
            if (line.equals("sortvar")){
                System.out.println(Container.sortVar());
                continue;
            }
            try {
                String result = parser.calc(line.trim());
                logger.writeLog("Получен результат: " + result);
                printer.print(result);
            } catch (CalcException exception){
                logger.writeLog("Возникла ошибка: " + exception.getMessage());
                System.out.println(exception.getMessage());
            }
        }
    }
}
