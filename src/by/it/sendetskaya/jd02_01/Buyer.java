package by.it.sendetskaya.jd02_01;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Buyer extends Thread implements IBuyer, IUseBacket, Comparable<Buyer>{

    private boolean pensioneer;
    static double sumGeneral =0;

    static ConcurrentHashMap<String,Double> hashMap;


    public Buyer(int number, boolean pensioneer)
    {
        super("Покупатель №" + number);
        this.pensioneer=pensioneer;
    }


    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
        goToQueue();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        if(pensioneer) {
            Helper.sleep(150, 300);
            System.out.println(this+"зашел в магазин пенсионер");
        }
        else {
            Helper.sleep(100, 200);
            System.out.println(this + "зашел в магазин");
        }
    }

    @Override
    public void takeBacket() {
        //final AtomicBoolean flag=new AtomicBoolean(false);
        if(pensioneer) {
            Helper.sleep(150, 300);

                if (!Queue.addBacketToQueue(this))
                    System.out.println(this+"пенсионер все еще ждет корзину");
        }
        else {
            Helper.sleep(100, 200);
                if (!Queue.addBacketToQueue(this))
                    System.out.println(this + "все еще ждет корзину");
        }
    }

    @Override
    public synchronized void chooseGoods() {
        String goodName;
        hashMap=new ConcurrentHashMap<>();
        for (int i = 1; i < Helper.getRandom(2,5); i++) {
            if (pensioneer) {
                Helper.sleep(150, 300);

                synchronized (this){
                    goodName = Goods.getGoodName();
                    Double goodPrice = Goods.getPrice(goodName);

                    System.out.println(this + "пенсионер выбрал товар " + goodName + " цена: " + goodPrice);
                    sumGeneral += goodPrice;
                    hashMap.put(goodName, goodPrice);
                }
            }
            else {
                Helper.sleep(100, 200);

                synchronized (this){
                    goodName = Goods.getGoodName();
                    Double goodPrice = Goods.getPrice(goodName);

                    System.out.println(this + "выбрал товар " + goodName + " цена: " + goodPrice);
                    sumGeneral += goodPrice;
                    hashMap.put(goodName, goodPrice);
                }
            }
        }
        System.out.println(this+"закончил выбор");
//        if (goodName.isEmpty())
//            goToOut();
    }

    @Override
    public void goToOut() {

        System.out.println(this+"вышел из магазина");
        //в принципе уменьшать счетчик может и кассир,
        //но этот код позднее, поэтому уменьшаем тут
        Dispetcher.incCompleteBuyer();
        Dispetcher.printCounts();
        System.out.println("В очереди в кассу осталось "+Queue.getSizeQueue());
        System.out.println("Всего в магазине "+Dispetcher.allBuyerInShop()+" покупателей");
    }

    @Override
    public void goToQueue() {

        synchronized (this)
        {
            System.out.println(this+" встал в очередь в кассу");
            Queue.addLastToQueue(this);
            try {
                this.wait();
            } catch (InterruptedException e) {
                System.err.println(this+" неожиданная ошибка !!!");
            }
            System.out.println(this+" закончил оплату в кассе");
        }
    }

    @Override
    public String toString() {

        if (pensioneer) {
            return "Пенсионер-"+this.getName()+" ";
        }
        else
            return this.getName()+" ";  //покупатель №+number
    }


    @Override
    public void putGoodsToBacket() {

//        if(pensioneer)
//            Helper.sleep(150,300);
//        else
//        Helper.sleep(100,200);

        Iterator<Map.Entry<String,Double>> itr=hashMap.entrySet().iterator();
        System.out.println(this+" положил в корзину:");
        while (itr.hasNext()) {
            System.out.print(itr.next()+";");
        }
        System.out.println();
    }


    //доделать 0,-1,1(пенс)
    @Override
    public int compareTo(Buyer o) {
        int comp=0;
        if(!this.pensioneer&&o.pensioneer) comp=1;
        if(this.pensioneer&&o.pensioneer) comp=0;
        if(this.pensioneer&&!o.pensioneer) comp=-1;
        if(!this.pensioneer&&!o.pensioneer) comp=0;
        return comp;
    }
}
