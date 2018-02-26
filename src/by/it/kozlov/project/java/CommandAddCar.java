package by.it.kozlov.project.java;

import javax.servlet.http.HttpServletRequest;

public class CommandAddCar implements ActionCommand {
    @Override
    public String execute(HttpServletRequest req) {
        return Actions.ADDCAR.jsp;
    }
}
