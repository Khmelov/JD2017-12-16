package by.it.sendetskaya.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Action {

    abstract  Action execute(HttpServletRequest request, HttpServletResponse response) throws Exception;

    String getJsp(){
        return "/"+this.toString().toLowerCase()+".jsp";
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName().replaceFirst("Command","");

    }
}
