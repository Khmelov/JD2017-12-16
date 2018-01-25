package by.it.patsko.jd02_01;


class Buyer extends Thread implements IBuyer{

    Buyer(int number) {
        super("Buyer #"+number);
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+" enterToMarket");
    }

    @Override
    public void chooseGoods() {
        for (int i = 1; i < Helper.getRandom(5); i++) {
            System.out.println(this+" chooseGoods");
            Helper.sleep(100,200);
            String goodName=Goods.rndGoodname();
            Double goodPrice=Goods.getPrice(goodName);
            System.out.println(this+" выбрал товар "+goodName);
        }
        System.out.println(this+" endChooseGoods");

    }

    @Override
    public void goToOut() {
        // TODO: synh
        Runner.queue.remove(this);
                System.out.println(this+" goToOut");
        System.out.println("В очереди осталось"+Runner.queue.size());
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
