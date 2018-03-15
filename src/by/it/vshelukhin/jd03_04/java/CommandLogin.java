package by.it.vshelukhin.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

public class CommandLogin implements ActionCommand  {

    @Override
    public String execute(HttpServletRequest request) {
        return Action.LOGIN.jsp;
    }
}
