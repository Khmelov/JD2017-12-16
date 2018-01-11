package by.it.vshelukhin.jd01_08;

public class LaserPrinter extends Printer {
    String namePrinter;

    boolean ecoMode;

    public LaserPrinter(String namePrinter, int maxShits, int maxResurs ) {
        super(namePrinter, maxShits, maxResurs);
        this.namePrinter = namePrinter;
        ecoMode = false;
    }

    public LaserPrinter(String namePrinter) {
        super(namePrinter, 100, 200);
        this.namePrinter = namePrinter;
        ecoMode = false;
    }

    public LaserPrinter() {
        super();
        this.namePrinter = "";
        ecoMode = false;
    }

    public void ecoModeOn() {
        if (!ecoMode) ecoMode = true;
        System.out.printf("\nЭкономичный режим включён!\n");
    }

    public void ecoModeOff() {
        if (ecoMode) ecoMode = false;
        System.out.printf("\nЭкономичный режим выключён!\n");
    }

    public void printTask(String text, int countPages) {
        super.printTask(text, countPages);
        System.out.println("<<экономичный режим " + (ecoMode? "включён>>" : "выключен>>\n"));
        if (ecoMode) resurs = resurs + countPages;
    }

    public void lastPrint(){
       System.out.printf("\nПринтер: "+namePrinter);
        super.lastPrint();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n*********************************************************\n");
        sb.append("Принтер: "+namePrinter+"\n");
        sb.append(super.toString());
        if (powerOn){
        sb.append("Экономичный режим "+(ecoMode ? "включён" : "выключен")+".\n");
        sb.append("*********************************************************");
        }
        return sb.toString();
    }

}