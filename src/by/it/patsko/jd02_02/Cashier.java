package by.it.patsko.jd02_02;

import java.util.Map;

public class Cashier implements Runnable {
    private static int numOfCashiers = 0;
    private int cashierNumber;
    private volatile static double totalSum = 0;
    private boolean isOpen = false;

    public Cashier(int cashierNumber) {
        this.cashierNumber = cashierNumber;
    }

    public static int getNumOfCashiers() {
        return numOfCashiers;
    }

    public void setIsOpen(boolean open) {
        isOpen = open;
    }

    @Override
    public void run() {
        numOfCashiers++;
        isOpen = true;
        System.out.println("\n"+this+" открыл кассу");
        while (!Queue.allBuyerComplete() && isOpen) {
            Buyer buyer = Queue.getPensionerQueueSize() == 0 ? Queue.extractBuyerFromQueue() : Queue.extractBuyerFromPensionerQueue();
            if (buyer != null) {
                System.out.println(this + " начал обслуживать " + buyer);
                Helper.sleep(200, 500);
                System.out.println(this + " печатает чек для " + buyer);
                printCheck(buyer);
                System.out.println(this + " закончил обслуживать " + buyer);
                synchronized (buyer) {
                    buyer.notify();
                }
            } else Thread.yield();
        }
        numOfCashiers--;
        System.out.println(this+" закрыл кассу");
    }

    @Override
    public String toString() {
        return "Cashier " + cashierNumber;
    }

    private void printCheck(Buyer buyer) {
        StringBuilder check = new StringBuilder();
        double sum = 0.0;

//        check.append("\nВ "+Cashier.getNumOfCashiers()+ " ОЧЕРЕДЯХ "+Queue.getQueueSize()+" ЧЕЛОВЕК\n");

        check.append(tableHead());
        check.append(wrapLine(String.format("|Чек %-26s", buyer)));
        for (Map.Entry<String, Double> good : buyer.getBasket().getGoodsInBasket().entrySet()) {
            check.append(wrapLine(String.format("| товар: %7s  --  цена: %.1f ", good.getKey(), good.getValue())));
            sum += good.getValue();
        }
        synchronized (Cashier.class) {
            totalSum += sum;
        }
        check.append(wrapLine(String.format("|итого:_____________________%2.1f ", sum), Queue.getQueueSize(), totalSum));
        for (int i = 0; i < 7; i++) {
            check.append("---------------------------------");
        }
        check.append("\n");
//        check.append(printTotalSum());
        System.out.println(check);
    }

    private StringBuilder wrapLine(String line) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < cashierNumber; i++)
            result.append("|                                ");
        result.append(line);
        for (int i = 1; i <= 7 - cashierNumber; i++)
            result.append("|                                ");
        result.append("|\n");

        return result;
    }

    private StringBuilder wrapLine(String line, int size, double total) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < cashierNumber; i++)
            result.append("|                                ");
        result.append(line);
        for (int i = 1; i <= 5 - cashierNumber; i++)
            result.append("|                                ");
        result.append(String.format("|                 %-15d", size));
        result.append(String.format("|                 %-15.1f", total));
        result.append("|\n");
        return result;
    }


    private StringBuilder tableHead() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            result.append("---------------------------------");
        }
        result.append("\n");
        for (int i = 1; i < 8; i++) {
            if (i < 6) result.append("|           Касса №").append(i).append("            ");
            else if (i == 6) result.append("|         Размер очереди         ");
            else result.append("|         ВСЕГО ВЫРУЧКА          ");
        }
        result.append("|\n");
        for (int i = 0; i < 7; i++) {
            result.append("---------------------------------");
        }
        result.append("\n");
        return result;
    }

    /*private StringBuilder printTotalSum() {
        StringBuilder result = new StringBuilder();
        result.append("|ВСЕГО:                         ");
        for (int i = 0; i < 3; i++) {
            result.append("                                 ");
        }
        synchronized (this) {
            result.append(String.format("% ,33.1f|\n", totalSum));
        }
        for (int i = 0; i < 5; i++) {
            result.append("---------------------------------");
        }
        result.append("\n");
        return result;
    }*/
}
