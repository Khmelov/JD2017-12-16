package by.it.viktorbrui.jd02_02;

public class BuyerL extends Thread implements IBuyerI,IUseBacket {

    BuyerL(int number) {
        super("Покупатель №"+number);
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
        System.out.println(this+"зашел в магазин");
    }

    @Override
    public void takeBacket() {
        System.out.println(BuyerL.this+"взял корзину");
    }

    @Override
    public void chooseGoods() {
        for (int i = 1; i <= HelperL.getRandom(8)+1; i++) {
            HelperL.sleep(100,400);
            String goodNames = GoodsL.randomGoodName();
            Double goodPrise = GoodsL.getPrice(goodNames);
            System.out.println(this+" выбрал товар "+goodNames+" цена: "+goodPrise);
        }
        System.out.println(this+" завершил выбор товара");
    }

    @Override
    public void putGoodsToBacket() {
        System.out.println(this+"положил выбранный товар в корзину");
    }

    @Override
    public void goToQueue() {
        DispatcherL.addToQueue(this);
        synchronized (this){
            try{
                this.wait();
        }catch (InterruptedException e){
                System.err.println(this+" неожиданная ошибка !!!");
            }
        }
    }

    @Override
    public void goToOut() {
        System.out.println(this+" Вышел и маазина!");
        DispatcherL.inCompliteBuyers();
        DispatcherL.printCounts();
    }

    @Override
    public String toString() {
        return this.getName()+" ";
    }
}
