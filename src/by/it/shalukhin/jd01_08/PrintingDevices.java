package by.it.shalukhin.jd01_08;

public interface PrintingDevices {
    void powerOn();
    void powerOff();
    void loadPaper(int countShits);
    void loadResurs();
    void printTestPage();
    void printTask(String text);
    void countAllPrintPages();


}
