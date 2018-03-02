package by.it.sevashko.project.java;

import javax.servlet.http.HttpServletRequest;

public class CommandSignup implements ActionCommand {

    @Override
    public String execute(HttpServletRequest req) {
        return Actions.SIGNUP.jsp;
    }
}
