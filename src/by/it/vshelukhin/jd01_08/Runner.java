package by.it.vshelukhin.jd01_08;

public class Runner {
    public static void main(String[] args) {


        Printer l = new LaserPrinter("HP1", 10, 5);

        System.out.println(l.toString());

        l.powerOn();

        System.out.println(l.toString());

        l.lastPrint();

        l.loadPaper(3);

        System.out.println(l.toString());

        l.printTestPage();

        System.out.println(l.toString());

        l.loadResurs();

        l.powerOff();

        l.loadResurs();

        System.out.println(l.toString());

        l.powerOn();

        System.out.println(l.toString());

        ((LaserPrinter) l).ecoModeOn();

        l.printTask("Реферат на 2 страницы",2);

        System.out.println(l.toString());

        l.printTask("Документ на 3 страницы", 3);


    }
}