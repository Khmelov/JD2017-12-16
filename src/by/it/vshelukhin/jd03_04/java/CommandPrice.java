package by.it.vshelukhin.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

public class CommandPrice implements ActionCommand  {
    @Override
    public String execute(HttpServletRequest request) {
        return Action.PRICE.jsp;
    }
}
