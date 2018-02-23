package by.it.krasutski.project.java;

import javax.servlet.http.HttpServletRequest;

public class CommandCreateAd implements ActionCommand {

    @Override
    public String execute(HttpServletRequest req) {
        return Actions.CREATEAD.jsp;
    }
}
