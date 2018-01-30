package by.it.akhmelev.jd02_03.classwork2;

interface IBuyer {

    void enterToMarket();    //вошел в магазин (мгновенно)

    void chooseGoods();      //выбрал товар (от 0,5 до 2 секунд)

    void goToQueue();        //

    void goToOut();          //отправился на выход(мгновенно)
}
