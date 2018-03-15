package by.it.vshelukhin.jd03_07.java.controller;

import javax.servlet.http.HttpServletRequest;

public interface ActionCommand {
    String execute(HttpServletRequest request) throws Exception;
}
