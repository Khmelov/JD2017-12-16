package by.it.krasutski.project.java;

import javax.servlet.http.HttpServletRequest;

public class CommandMyAds implements ActionCommand {

    @Override
    public String execute(HttpServletRequest req) {
        return Actions.MYADS.jsp;
    }
}
