package by.it.sevashko.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public abstract class Action {

    abstract Action execute(HttpServletRequest req) throws Exception;

    String getJsp(){
        return String.format("/%s.jsp", this);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName().replace("Command", "").toLowerCase();
    }
}
