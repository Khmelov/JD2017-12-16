package by.it.sevashko.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Buyer extends Thread implements IBuyer, IUseBacket{

    private ArrayList<String> basket = new ArrayList<>();
    private boolean pensioner = false;

    Buyer(int number) {
        super(String.format("Покупатель №%d", number));
        if (Helper.getRandom(4) == 3) pensioner = true;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        getInLine();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "зашёл в магазин");
    }

    @Override
    public void chooseGoods() {
        List<String> listOfProducts = new ArrayList<>(Assortment.getProducts());
        for (int i = 0; i < Helper.getRandom(5); i++) {
            Helper.sleep(500, 2000, pensioner);
            String product = listOfProducts.get(Helper.getRandom(Assortment.getSize()));
            System.out.println(this + "выбрал " + product);
            putGoodsToBacket(product);
        }
    }

    @Override
    public void goToOut() {
        Dispatcher.addServedBuyer();
        System.out.println(this + "вышел из магазина");
    }

    @Override
    public String toString() {
        if (pensioner) return this.getName() + "(пенсионер) ";
        return this.getName() + " ";
    }

    @Override
    public void takeBacket() {
        Helper.sleep(100, 200, pensioner);
        System.out.println(this + "взял корзину");
    }

    @Override
    public void putGoodsToBacket(String name) {
        Helper.sleep(100, 200, pensioner);
        basket.add(name);
        System.out.println(this + "положил " + name + " в корзину");
    }

    @Override
    public void getInLine() {
        synchronized (this){
            try {
                Dispatcher.addToQue(this);
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String[] showChosenProducts() {
        String[] array = new String[basket.size()];
        return basket.toArray(array);
    }

    boolean isPensioner(){
        return pensioner;
    }
}
