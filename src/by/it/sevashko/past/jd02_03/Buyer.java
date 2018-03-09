package by.it.sevashko.jd02_03;

import java.util.ArrayList;
import java.util.List;

public class Buyer extends Thread implements IBuyer, IUseBasket, Comparable<Buyer> {

    private ArrayList<String> basket = new ArrayList<>();
    private boolean pensioner = false;

    Buyer(int number) {
        super(String.format("Покупатель №%d", number));
        if (Helper.getRandom(4) == 3) pensioner = true;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        goToQueue();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        while (!Dispatcher.permitToEnterTradingHall()){   //В зале не может выбирать товар больше, чем 20 покупателей (семафор).
            //System.out.println(this + "Торговый зал заполнен, я подожду");
            Thread.yield();
        }
        System.out.println(this + "зашёл в магазин");
    }

    @Override
    public void chooseGoods() {
        List<String> listOfProducts = new ArrayList<>(Assortment.getProducts());
        for (int i = 0; i <= Helper.getRandom(4); i++) {
            Helper.sleep(500, 2000, pensioner);
            String product = listOfProducts.get(Helper.getRandom(Assortment.getSize()));
            System.out.println(this + "выбрал " + product);
            putGoodsToBasket(product);
        }
    }

    @Override
    public void goToOut() {
        Dispatcher.returnBasket(this);   // возвращает корзину
        Dispatcher.addServicedBuyer();
        System.out.println(this + "вышел из магазина");
    }

    @Override
    public String toString() {
        if (pensioner) return this.getName() + "(пенсионер) ";
        return this.getName() + " ";
    }

    @Override
    public void takeBasket() {
        while (!Dispatcher.getFreeBascket()){                       // ждет свободную корзину
            //System.out.println(this + "говорит: Все корзины разобраны. Ждем!");
            Thread.yield();
        }
        Helper.sleep(100, 200, pensioner);
        System.out.println(this + "взял корзину");
    }

    @Override
    public void putGoodsToBasket(String name) {
        Helper.sleep(100, 200, pensioner);
        basket.add(name);
        System.out.println(this + "положил " + name + " в корзину");
    }


    @Override
    public int compareTo(Buyer other) {
        if (this.pensioner){
            if (other.pensioner) return 0;
            else return -1;
        }
        else {
            if (other.pensioner) return 1;
            else return 0;
        }
    }

    @Override
    public void goToQueue() {
        synchronized (this){
            while (!Dispatcher.addToQueue(this)){
                this.chooseGoods();
            }
            try {
                Dispatcher.goFromTradingHall();   // ушел из торгового зала
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    String[] showBasket(){
        String[] content = new String[basket.size()];
        basket.toArray(content);
        return content;
    }
}
