package by.it.vshelukhin.calc;

import java.text.DateFormat;
import java.util.*;

public class StatisticInfo {
    public class CurrentEvent{
        Date date;
        String expresson;
        String result;
        Exception exception;
        CurrentEvent(Date date, String expresson, String result, Exception exception){
            this.date = date;
            this.expresson = expresson;
            this.result = result;
            this.exception = exception;
        }

        @Override
        public String toString() {
            return date + " выражение: " + expresson + " результат: " + result;
        }
    }

    static String startSession;
    StatisticInfo(){
        super();
        startSession = new Date().toString();
    }

    static String endSession = "";

    public void setEndSession() {
        this.endSession = new Date().toString();
    }

    static List<CurrentEvent> events = new ArrayList<CurrentEvent>(){
        @Override
        public String toString() {
            return super.toString().replace(",", "\n");
        }
    };

    public void setEvents(String expression, String result, Exception e) {
        //String date = new Date().toString();
        CurrentEvent currEvent = new CurrentEvent(new Date(), expression, result, e);
        events.add(currEvent);
    }
}
