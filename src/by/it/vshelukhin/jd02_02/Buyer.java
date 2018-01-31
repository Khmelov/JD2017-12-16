package by.it.vshelukhin.jd02_02;

import java.util.Iterator;

public class Buyer implements Runnable, IBuyer, IUseBacket {

    Boolean pensioneer = false;

    String name = "ananimus";

    Backet backet = null;

    private String goodInHands = null;

    double priceAll = 0.0;

    public Buyer(){
        super();
        if (HelpRnd.getRnd(0,100)>75) pensioneer = true;
    }

    public Buyer(String name){
        this();
        this.name = name+(pensioneer ? " пенсионер" : "");
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        goToQueue();
        toPayOf();
        leaveBacket();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        Shop.addBuyer(this);
        System.out.println(name + " зашёл в магазин");
    }

    @Override
    public void chooseGoods() {
        System.out.println(name + " начал выбор товаров");
        int gCount = HelpRnd.getRnd(1,4);
        for (int i = 0; i < gCount; i++) {
            try {
                Thread.sleep((int)((pensioneer ? 1.5 : 1.0)*HelpRnd.getRnd(500, 2000)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            goodInHands = Goods.getRndGood();
            putGoodsToBacket();
        }
        System.out.println(name + " завершил выбор товаров");
    }

    void  goToQueue(){
        Shop.addBuyerToQueue(this);
        synchronized (this){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void toPayOf(){
        Kassa.addHist(this,priceAll);
    }

    public void leaveBacket(){
        BacketRoom.acceptBacked(backet);
        System.out.println(name+" оставил корзинку номер "+backet.invNunb);
        backet = null;
    }


//    void cashProcess(){
//        Double sum = 0.0;
//        Iterator<String> it = backet.iterator();
//        while (it.hasNext()){
//            sum = sum + Goods.getPrice(it.next());
//        }
//        toPayOf(sum);
//        System.out.println(name + " расплатился на кассе");
//    }



    @Override
    public void goToOut() {
        Shop.deleteBuyer(this);
        System.out.println(name + " вышел из магазина");
    }

    @Override
    public void takeBacket() {
        try {
            Thread.sleep((int)((pensioneer ? 1.5 : 1.0)*HelpRnd.getRnd(100, 200)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        backet = BacketRoom.getBacked();

        if (backet == null){
            while (backet==null){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                backet = BacketRoom.getBacked();
            }
        }

        System.out.println(name+" взял корзинку номер "+backet.invNunb);
    }

    @Override
    public void putGoodsToBacket() {
        try {
            Thread.sleep((int)((pensioneer ? 1.5 : 1.0)*HelpRnd.getRnd(100, 200)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        backet.addGoods(goodInHands);
        System.out.println(name+" положил в корзину "+goodInHands);
        goodInHands = "";
    }

    @Override
    public String toString() {
        return name;
    }
}
