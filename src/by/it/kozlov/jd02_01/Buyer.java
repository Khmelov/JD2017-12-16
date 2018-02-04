package by.it.kozlov.jd02_01;

import java.util.*;
import java.util.concurrent.Semaphore;

class Buyer extends Thread implements IBuyer, IUseBasket, Comparable<Buyer> {
    private boolean pensioner = false;
    private static Semaphore semaphore=new Semaphore(20);

    volatile Map<String, Double> buy = new HashMap<>();

    Buyer(int number) {
        super("Покупатель №" + number);
    }

    private void getPensioner() {
        if (Helper.getRandom(4) == 0) pensioner = true;
    }

    Map<String, Double> getGoods() {
        return buy;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToQueue();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        try {
            semaphore.acquire();
            Dispetcher.holeBuyer.incrementAndGet();
            System.out.println("В зале "+Dispetcher.holeBuyer.get()+"человек");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getPensioner();
        System.out.println(this + (pensioner ? "пенсионер" : "") + "зашел в магазин");
    }

    @Override
    public void chooseGoods() {
        for (int i = 1; i <= Helper.getRandom(5); i++) {
            Helper.sleep(500, 2000, pensioner);
            String goodName = Goods.rndGoodName();
            Double goodPrice = Goods.getPrice(goodName);
            buy.put(goodName, goodPrice);
            System.out.println(this + "выбрал товар " + goodName + " цена:" + goodPrice);
        }
        System.out.println(this + "завершил выбор товаров");
    }

    @Override
    public void goToOut() {
        System.out.println(this + "вышел из магазина");
        Dispetcher.incCompleteBuyer();
        Dispetcher.printCounts();
    }

    @Override
    public String toString() {
        return this.getName() + " ";
    }

    @Override
    public void takeBasket() {
        Helper.sleep(100, 200, pensioner);
        //System.out.println(this + "взял корзину");
    }

    @Override
    public void putGoodsToBasket() {
        Helper.sleep(100, 200, pensioner);
        //System.out.println(this + "положил выбранный товар в корзину");
    }

    @Override
    public void goToQueue() {
        System.out.println(this + "стал в очередь");
        Dispetcher.addToQueue(this);
        Dispetcher.holeBuyer.getAndDecrement();
        semaphore.release();
    }

    @Override
    public int compareTo(Buyer o) {
        return 0;
    }
}
