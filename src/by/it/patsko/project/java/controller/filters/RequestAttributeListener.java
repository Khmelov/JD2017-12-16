package by.it.patsko.project.java.controller.filters;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class RequestAttributeListener implements ServletRequestAttributeListener {
    @Override
    public void attributeAdded(ServletRequestAttributeEvent event) {
        System.out.println(String.format("add %s : %s", event.getName(), event.getValue()));

    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent event) {
        System.out.println(String.format("remove %s : %s", event.getName(), event.getValue()));
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent event) {
        System.out.println(String.format("replace %s : %s", event.getName(), event.getValue()));
    }
}
