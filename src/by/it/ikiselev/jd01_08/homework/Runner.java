package by.it.ikiselev.jd01_08.homework;

public class Runner {
    public static void main(String[] args) {
        Engineer firstEngineer=new Manager("Новая криптовалюта", 201801, 4);
        firstEngineer.doWork();
        Engineer secondEngineer=new Manager();
        secondEngineer.checkAlcohol();

    }
}
