package by.it.viktorbrui.jd02_02;

public class RunnerL {

    public static void main(String[] args) {
        System.out.println("Магазин открыт");
        for (int i = 1; i <= 5; i++) {
            CashierL cashier = new CashierL(i);
            new Thread(cashier).start();
        }
        for (int second=0; second<120;second++ ){
            int count = HelperL.getRandom(3);
            for (int i = 0; i <=count ; i++) {
                BuyerL b = new BuyerL(DispatcherL.incCountBuyer());
                System.out.println("RunnerL: Новый " +b);
                DispatcherL.printCounts();
                b.start();
            }try{
                Thread.sleep(200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        while (!DispatcherL.allBuyersComplite()){
            BuyerL first = DispatcherL.readFirstQueue();
            if (first != null)
                try{
                first.join();
                }catch (InterruptedException e){
                e.printStackTrace();
                }
        }
        System.out.println("Все вышли ");
        HelperL.sleep(100, 300);
        System.out.println("RunnerL: Магаин закрыт!");
    }

}
