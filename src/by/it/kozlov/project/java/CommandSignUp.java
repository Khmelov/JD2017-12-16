package by.it.kozlov.project.java;

import javax.servlet.http.HttpServletRequest;

public class CommandSignUp implements ActionCommand {
    @Override
    public String execute(HttpServletRequest req) {
        return Actions.SIGNUP.jsp;
    }
}
