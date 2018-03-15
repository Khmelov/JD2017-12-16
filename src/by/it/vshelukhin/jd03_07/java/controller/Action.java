package by.it.vshelukhin.jd03_07.java.controller;

import javax.servlet.http.HttpServletRequest;

abstract class Action {
    abstract Action execute(HttpServletRequest request) throws Exception;

    String getJsp(){
      return "/"+this.toString().toLowerCase()+".jsp";
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName().replaceFirst("Command","");
    }
}
