package by.it.akhmelev.jd02_02.classwork2;

public class Runner {

    public static void main(String[] args) {
        for (int second = 0; second < 12; second++) {
            int count=Helper.getRandom(2);
            for (int i = 0; i <= count; i++) {
                Buyer b = new Buyer(Dispatcher.incCountBuyer());
                b.start();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 1; i <= 5; i++) {
            Cashier c=new Cashier(i);
            new Thread(c).start();
        }

        while (!Dispatcher.allBuyerComplete()){
            Buyer first=Dispatcher.readFirstQueue();
            if (first!=null)
                try {
                    first.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        System.out.println("\nRunner: Все вышли");
        //очереди кассиров нет, поэтому
        //тут просто подождем.
        Helper.sleep(100,200);
        System.out.println("\nRunner: Магазин закрыт");
    }
}
