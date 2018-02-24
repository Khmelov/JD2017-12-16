package by.it.akhmelev.project5.java;

import javax.servlet.http.HttpServletRequest;

public class CommandSignup implements ActionCommand {
    @Override
    public String execute(HttpServletRequest req) {
        return Actions.SIGNUP.jsp;
    }
}
