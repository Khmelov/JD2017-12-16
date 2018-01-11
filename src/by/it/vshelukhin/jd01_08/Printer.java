package by.it.vshelukhin.jd01_08;

public abstract class Printer implements PrintingDevices {
    protected boolean powerOn;

    private int maxShits;
    protected int countShits;

    private int maxResurs;
    protected int resurs;

    protected int countAllPrintPages;

    String testPage;

    String lastPrint = "";

    Printer(String name, int maxShits, int maxResurs) {
        powerOn = false;
        this.maxShits = maxShits;
        countShits = 0;
        this.maxResurs = maxResurs;
        resurs = maxResurs;
        testPage = "!!!Принтер "+name+" исправен и готов к работе!!!";
    }

    Printer() {
        powerOn = false;
        maxShits = 100;
        countShits = 0;
        maxResurs = 200;
        resurs = 200;
        testPage = "!!!Принтер исправен и готов к работе!!!";
    }

    @Override
    public void powerOn() {
        if (!powerOn) powerOn = true;
        System.out.printf("\nПринтер включён!\n");
    }

    @Override
    public void powerOff() {
        if (powerOn) powerOn = false;
        System.out.printf("\nПринтер выключён!\n");
    }

//------------------------------------------------------------------------------------

    public boolean isPaper() {
        return countShits > 0;
    }

    @Override
    public void loadPaper(int countShits) {
        int temp = this.countShits;
        this.countShits = this.countShits + countShits;
        if (this.countShits > maxShits) this.countShits = maxShits;
        System.out.printf("\nДобавлено %d чистых листа.\n", this.countShits - temp);
        System.out.printf("Принтер заправлен бумагой на %.2f процентовю.\n", (double) this.countShits / maxShits * 100);
    }

    public int getCountShits() {
        return countShits;
    }

    public int getMaxShits() {
        return maxShits;
    }

    //------------------------------------------------------------------------------------


    public boolean isResurs() {
        return resurs > 0;
    }

    @Override
    public void loadResurs() {
        if (!powerOn) {
            resurs = maxResurs;
            System.out.printf("\nПринтер заправлен тонером на 100.00 процентов.\n");
        }
        else System.out.printf("\nЧтобы заправить тонером выключите принтер!\n");
    }

    public int getResurs() {
        return resurs;
    }

    public int getMaxResurs() {
        return maxResurs;
    }

    //------------------------------------------------------------------------------------

    public void printTask(String text, int countPages) {
        if (powerOn) {
            if (isPaper() && isResurs()) {
                System.out.printf("\n<<начало процесса печати>>\n\n");
                System.out.println(text);
                System.out.printf("\n<<конец процесса печати>>\n");
                System.out.printf("<<напечатано "+countPages+" страниц>>\n");
                countAllPrintPages = countAllPrintPages + countPages;
                lastPrint = text;
                countShits = countShits-countPages;
                resurs = resurs - 2 * countPages;
            }
            else if (isPaper()) System.out.printf("\nЗакончился тонер!\n");
            else if (isResurs()) System.out.printf("\nЗакончилась бумага!\n");
            else System.out.printf("\nЗакончились бумага и тонер!\n");
        }
        else System.out.printf("\nЧтобы распечатать документ включите принтер!\n");
    }

    @Override
    public void printTask(String text) {
        printTask(text, 1);
    }

    @Override
    public void printTestPage() {
        printTask(testPage, 1);
    }

    //------------------------------------------------------------------------------------


    public int getCountAllPrintPages() {
        return countAllPrintPages;
    }

    @Override
    public void countAllPrintPages() {
        System.out.printf("\nНа принтере распечатано %d листов.\n", getCountAllPrintPages());
    }

    //------------------------------------------------------------------------------------

    public String getLastPrint() {
        return lastPrint;
    }

    public void lastPrint(){
        StringBuilder sb = new StringBuilder();
        if (powerOn) {
            sb.append("\nПоследний распечатанный документ: ");
            if (lastPrint.isEmpty()) sb.append("<<На этом принтере ничего не печаталось!>>\n");
            else sb.append("\"" + getLastPrint() + "\"\n");
        }
        else sb.append("\nЧтобы посмотреть последний распечатанный документ включите принтер!\n");
        System.out.printf(sb.toString());
    }


    //------------------------------------------------------------------------------------


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Принтер "+ (powerOn ? "включён" : "выключен") + "\n");
        sb.append("Заправлено бумаги: " + getCountShits() + " / " + getMaxShits()+"\n");
        if (!powerOn){
            sb.append("Для получения дополнительной информации включите принтер!\n");
            sb.append("*********************************************************");
            return sb.toString();
        }
        sb.append("Напечатано " + getCountAllPrintPages() + " страниц\n");
        sb.append("Оставшейся ресурс: "+ getResurs()+" / "+getMaxResurs()+"\n");
        return sb.toString();
    }
}
