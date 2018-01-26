package by.it.kozlov.jd02_01;

public class Buyer extends Thread implements IBuyer {


    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToOut();
    }

    @Override
    public void enterToMarket() {

    }

    @Override
    public void chooseGoods() {

    }

    @Override
    public void goToOut() {

    }
}
