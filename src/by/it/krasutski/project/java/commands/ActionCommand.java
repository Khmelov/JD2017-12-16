package by.it.krasutski.project.java.commands;

import javax.servlet.http.HttpServletRequest;

public interface ActionCommand {

    String execute(HttpServletRequest req) throws Exception;
}
