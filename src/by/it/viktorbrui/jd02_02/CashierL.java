package by.it.viktorbrui.jd02_02;

public class CashierL implements Runnable {

    private int number;
    public CashierL (int number){
        this.number=number;
    }
    @Override
    public void run() {
        System.out.println(this+"открыл кассу.");
        while (!DispatcherL.allBuyersComplite()){
            BuyerL b = DispatcherL.extractFromQueue();
            if (b!=null){
                System.out.println(this+"начало обслуживания" + b);
                HelperL.sleep(300,600);
                System.out.println(this+"печатает чек для "+ b);
                System.out.println(this+"закончил обслуживание "+b);
                synchronized (b){
                    b.notify();
                }
            }else
                Thread.yield();
        }
        System.out.println(this+"закрыл кассу.");
    }

    @Override
    public String toString() {
        return "Cashier: Кассир №" + number + " ";
    }
}
