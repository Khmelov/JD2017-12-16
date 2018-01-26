package by.it.sendetskaya.jd02_01;

public class Buyer extends Thread implements IBuyer, IUseBacket{

    private boolean pensioneer;

    public Buyer(int number, boolean pensioneer)
    {
        super("Покупатель №" + number);
        this.pensioneer=pensioneer;
        if (pensioneer) {
            System.out.println("Покупатель - пенсионер");
        }

    }


    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
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
        if(pensioneer) {
            Helper.sleep(150, 300);
            System.out.println(this+"взял корзину пенсионер");
        }
        else {
            Helper.sleep(100, 200);
            System.out.println(this + "взял корзину");
        }
    }

    @Override
    public void chooseGoods() {
        for (int i = 1; i < Helper.getRandom(5); i++) {
            if(pensioneer) {
                Helper.sleep(150, 300);
                String goodName = Goods.getGoodName();
                Double goodPrice = Goods.getPrice(goodName);
                System.out.println(this + "пенсионер выбрал товар " + goodName + " цена: " + goodPrice);
            }
            else {
                Helper.sleep(100, 200);
                String goodName = Goods.getGoodName();
                Double goodPrice = Goods.getPrice(goodName);
                System.out.println(this + "выбрал товар " + goodName + " цена: " + goodPrice);
            }
            putGoodsToBacket();
        }

        System.out.println(this+"закончил выбор");

    }

    @Override
    public void goToOut() {
        Runner.queue.remove(this);
        System.out.println(this+"вышел из магазина");
        System.out.println("В очереди осталось "+Runner.queue.size());

    }

    @Override
    public String toString() {

        return this.getName()+" ";  //покупатель №+number
    }


    @Override
    public void putGoodsToBacket() {

        if(pensioneer)
            Helper.sleep(150,300);
        else
        Helper.sleep(100,200);
        System.out.println("и положил в корзину");

    }
}
