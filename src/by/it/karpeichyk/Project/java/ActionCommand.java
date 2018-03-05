package by.it.karpeichyk.Project.java;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by user on 22.02.2018.
 */
public interface ActionCommand {
    String execute(HttpServletRequest req) throws  Exception;
}
