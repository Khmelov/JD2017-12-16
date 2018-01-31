package by.it.vshelukhin.jd02_02;

import java.util.*;

public class Cashier implements Runnable {

    static synchronized void printCheck(StringBuilder chek){
        System.out.println(chek);
    }

    static Deque<Integer> freeCashier = new ArrayDeque<>();
    static {
        for (int i = 1; i <= 5; i++) {
            freeCashier.addFirst(i);
        }
    }

    static synchronized int getNumberFreeCashier(){
        Integer temp = freeCashier.pollLast();
        if (temp == null) temp = 0;
        return temp;
    }

    static synchronized void addFreeCashier(Cashier cashier){
        freeCashier.addFirst(cashier.getNumberCashier());
    }

    int numberCashier;

    public int getNumberCashier() {
        return numberCashier;
    }

    Buyer currentBuyer;

    public Cashier(int numberCashier) {
        super();
        this.numberCashier = numberCashier;
    }

    @Override
    public void run() {
        openCashier();
        while (Shop.getNumberAllBuyers() != 0){

            if (((int) Math.ceil((double) Shop.getSizeQueue()/5))-Shop.getNumberAllCashier() < 0) break;

            getNextBuyer();
            if (currentBuyer == null){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }

            cashingProcess();
            try {
                Thread.sleep(HelpRnd.getRnd(4000,7000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        closeCashier();
    }

    void openCashier() {
        System.out.println(tabForPrint()+"Касса номер " + numberCashier + " открылась!");
    }

    void getNextBuyer() {
        currentBuyer = Shop.takeBuyerFromQueue();
    }

    void cashingProcess(){
        StringBuilder check = makeCheck(currentBuyer.backet);

        Cashier.printCheck(check);

        currentBuyer.priceAll = getSumBacket(currentBuyer.backet);

        synchronized (currentBuyer) {
            currentBuyer.notify();
        }
    }

    private StringBuilder makeCheck (Backet backet){
        StringBuilder check = new StringBuilder();
        check.append("\n");
        check.append(tabForPrint());
        check.append("Кассир номер ");
        check.append(numberCashier);
        check.append("\n");
        check.append(tabForPrint());
        check.append("начал обслуживать покупателя ");
        check.append(currentBuyer);
        check.append("\n");

        Iterator<String> it = backet.iterator();
        double sum = 0.0;
        while (it.hasNext()){
            String good = it.next();
            check.append(tabForPrint());
            check.append(good);
            check.append(" цена: ");
            check.append(Goods.getPrice(good));
            check.append("\n");
            sum = sum + Goods.getPrice(good);
            try {
                Thread.sleep(HelpRnd.getRnd(200,500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        check.append(tabForPrint());
        check.append("Сумма к оплате: ");
        check.append(sum);
        check.append(" руб.");
        check.append("\n");
        check.append(tabForPrint());
        check.append("Кассир номер ");
        check.append(numberCashier);
        check.append("\n");
        check.append(tabForPrint());
        check.append("закончил обслуживать покупателя ");
        check.append(currentBuyer);
        check.append("\n");

        return check;

    }

    private double getSumBacket (Backet backet){
        Iterator<String> it = backet.iterator();
        double sum = 0.0;
        while (it.hasNext()){
            sum = sum + Goods.getPrice(it.next());
        }
        return sum;
    }

    private StringBuilder tabForPrint(){
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < this.numberCashier; i++) {
            for (int j = 0; j < 35; j++) {
                sb.append(" ");
            }
        }
        return sb;
    }

    void closeCashier(){
        Shop.deleteCasher(this);
        Cashier.addFreeCashier(this);
        System.out.println(tabForPrint()+"Касса номер " + numberCashier + " закрылась!");
    }
}
