package by.it.kozlov.project.java;

import javax.servlet.http.HttpServletRequest;

public interface ActionComand {
    String execute(HttpServletRequest req);
}
