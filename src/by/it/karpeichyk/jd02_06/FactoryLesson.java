package by.it.karpeichyk.jd02_06;

/**
 * Created by user on 12.02.2018.
 */
public class FactoryLesson {
    public static void main(String[] args) {
        Factory factory= new Factory();
        Car Toyota=factory.create("Toyota");
        Car Audi=factory.create("Audi");
        Toyota.drive();
        Toyota.stop();
        Audi.stop();
        Audi.drive();

    }

}
interface Car{
    void  drive();
    void  stop();

}
class  Toyota implements Car{
    @Override
    public void drive() {
        System.out.println("Drive Toyota");

    }

    @Override
    public void stop() {
        System.out.println("Stop Toyota");

    }
}
class  Audi implements  Car{
    @Override
    public void drive() {
        System.out.println("Drive Audi");

    }

    @Override
    public void stop() {
        System.out.println("Stop Audi");

    }
}
class Factory{
    public Car create(String TypeOfCar){
        switch (TypeOfCar){
            case "Tyota": return new Toyota();
            case "Audi" : return new Audi();
            default:return null;

        }


    }
}
