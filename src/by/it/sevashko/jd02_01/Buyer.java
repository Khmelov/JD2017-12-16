package by.it.sevashko.jd02_01;

public class Buyer extends Thread implements IBuyer, IUseBacket{

    public Buyer(int number) {
        super(String.format("Покупатель №%d", number));
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "зашёл в магазин");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "выбирает товар");
        Helper.sleep(500, 2000);
        System.out.println(this + "выбрал товар");
    }

    @Override
    public void goToOut() {
        System.out.println(this + "вышел из магазина");
    }

    @Override
    public String toString() {
        return this.getName() + " ";
    }

    @Override
    public void takeBacket() {
        Helper.sleep(100, 200);
        System.out.println(this + "взял корзину");
    }

    @Override
    public void putGoodsToBaccket() {

    }
}
