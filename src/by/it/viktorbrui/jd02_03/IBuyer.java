package by.it.viktorbrui.jd02_03;

interface IBuyer {

    void enterToMarket();    //вошел в магазин (мгновенно)

    void chooseGoods();      //выбрал товар (от 0,5 до 2 секунд)

    void goToQueue();        //

    void goToOut();          //отправился на выход(мгновенно)
}
