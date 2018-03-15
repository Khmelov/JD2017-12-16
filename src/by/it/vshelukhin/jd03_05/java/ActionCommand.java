package by.it.vshelukhin.jd03_05.java;

import javax.servlet.http.HttpServletRequest;

public interface ActionCommand {
    String execute(HttpServletRequest request) throws Exception;
}
