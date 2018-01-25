package by.it.sendetskaya.jd02_01;

public class Buyer extends Thread implements iBuyer{

    public Buyer(int number)
    {
        super("Покупатель №"+number);
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        Helper.sleep(100,200);
        System.out.println(this+"зашел в магазин");
    }

    @Override
    public void chooseGoods() {
        for (int i = 1; i < Helper.getRandom(5); i++) {
            Helper.sleep(100,200);
            String goodName=Goods.getGoodName();
            Double goodPrice=Goods.getPrice(goodName);
            System.out.println(this+ "выбрал товар "+goodName+" цена: "+goodPrice);
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
}
