package by.it.krasutski.project.java;

import javax.servlet.http.HttpServletRequest;

public interface ActionCommand {

    String execute(HttpServletRequest req);
}
