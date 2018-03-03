package by.it.akhmelev.project6.java.controller;

import javax.servlet.http.HttpServletRequest;

public abstract class Action {
    abstract Action execute(HttpServletRequest req) throws Exception;

    String getJsp(){
      return "/"+this.toString().toLowerCase()+".jsp";
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName().replaceFirst("Command","");
    }
}
