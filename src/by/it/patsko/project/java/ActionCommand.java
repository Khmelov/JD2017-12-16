package by.it.patsko.project.java;

import javax.servlet.http.HttpServletRequest;

interface ActionCommand {
    String execute(HttpServletRequest req);
}
