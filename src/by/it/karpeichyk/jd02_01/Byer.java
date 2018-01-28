package by.it.karpeichyk.jd02_01;

import by.it.akhmelev.jd01_03.Runner;

/**
 * Created by user on 25.01.2018.
 */
 class Byer extends Thread implements  iByer,Backet {

    public  Byer (int number){
        super("покупатель N"+ number);
    }
   @Override
   public  void run(){
        enterToMarket();
        chooseGoods();
        TakeBasket();
        PutGoodsToBacket();
        goToOut();
   }
   @Override
   public void enterToMarket(){
       System.out.println(this+"зашёл в магазин");
   }

    @Override
    public void chooseGoods() {
        for (int i = 1; i <Helper.getRandom(5) ; i++) {
            Helper.slep(100,200);
            String goodName=Goods.rndGoodName();
            Double goodPrice = Goods.getPrice(goodName);
            System.out.println(this+"выбрал товар "+goodName+" цена:"+goodPrice);
        }
        TakeBasket();
        System.out.println("Завершил выбор товаров");

    }
    @Override
    public void TakeBasket(){
       Helper.slep(100,200);
        System.out.println(this+"взял корзину");
    }
    @Override
    public  void   PutGoodsToBacket(){
        for (int i = 1; i <Helper.getRandom(4) ; i++) {
            Helper.slep(100,200);
            String goodName=Goods.rndGoodName();
            //Double goodPrice = Goods.getPrice(goodName);
            System.out.println(this+"товар "+goodName+" положил в корзину");
        }
       // System.out.println("полным полна корзина");
    }

    @Override
    public  void goToOut(){
        by.it.karpeichyk.jd02_01.Runner.queue.remove(this);
        System.out.println(this+"вышел из магазина");
        System.out.println("В очереди осталось"+ by.it.karpeichyk.jd02_01.Runner.queue.size());
    }
    @Override
    public String toString() {
        return this.getName()+" ";
    }
}
