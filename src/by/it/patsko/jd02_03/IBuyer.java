package by.it.patsko.jd02_03;


interface IBuyer {
    void enterToMarket(); //вошел в магазин (мгновенно)

    void chooseGoods(); //выбрал товар (от 0,1 до 0,2 секунд)

    void goToQueue();

    void goToOut(); //отправился на выход(мгновенно)
}

