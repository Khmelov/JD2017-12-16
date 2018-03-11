package by.it.patsko.project.java.controller.filters;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SessionAttributeListener implements HttpSessionAttributeListener {
    public void attributeRemoved(HttpSessionBindingEvent ev) {
        System.out.println(String.format("remove %s : %s", ev.getName(), ev.getValue()));
    }

    public void attributeAdded(HttpSessionBindingEvent ev) {
        System.out.println(String.format("add %s : %s", ev.getName(), ev.getValue()));
    }

    public void attributeReplaced(HttpSessionBindingEvent ev) {
        System.out.println(String.format("replace %s : %s", ev.getName(), ev.getValue()));
    }
}
