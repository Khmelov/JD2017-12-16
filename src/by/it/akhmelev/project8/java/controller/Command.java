package by.it.akhmelev.project8.java.controller;

import javax.servlet.http.HttpServletRequest;

abstract class Command {
    abstract Command execute(HttpServletRequest req) throws Exception;

    String getJsp(){
      return "/"+this.toString().toLowerCase()+".jsp";
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName().replaceFirst("Command","");
    }
}
