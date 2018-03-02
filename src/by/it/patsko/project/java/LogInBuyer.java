package by.it.patsko.project.java;

import by.it.patsko.project.java.dao.beens.Buyer;

public class LogInBuyer {
    public static Buyer currentBuyer;

    private static LogInBuyer instance;
    private LogInBuyer(Buyer buyer){currentBuyer=buyer;}

    public static LogInBuyer getInstance(Buyer buyer) {
        if(instance==null) instance=new LogInBuyer(buyer);
        return instance;
    }
    public static void resetInstance() {
         instance=null;
        currentBuyer=null;
    }

}
