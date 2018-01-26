package by.it.vshelukhin.jd02_01;

import java.util.*;

public class Shop {
    static Set<Buyer> BuyersAll = new HashSet<>();
    static List<Integer> quantity = new ArrayList<>();

    static void addBuyer(Buyer buyer){
        BuyersAll.add(buyer);
    }

    static void deleteBuyer(Buyer buyer){
        BuyersAll.remove(buyer);
    }
}
