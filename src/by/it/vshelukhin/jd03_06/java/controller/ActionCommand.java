package by.it.vshelukhin.jd03_06.java.controller;

import javax.servlet.http.HttpServletRequest;

public interface ActionCommand {
    String execute(HttpServletRequest request) throws Exception;
}
