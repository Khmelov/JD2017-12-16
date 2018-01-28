package by.it.sevashko.jd02_01;

public class Dispatcher {

    private static int buyerCount = 0;
    private static int currentBuyerNumber = 0;

    static int getBuyerNumber(){
        changeCurrentBuyerNumber(1);
        return ++buyerCount;
    }

    static void changeCurrentBuyerNumber(int number){
        currentBuyerNumber = currentBuyerNumber + number;
    }

    static int getCurrentBuyerNumber(){
        return currentBuyerNumber;
    }
}
