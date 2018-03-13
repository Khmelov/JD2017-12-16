package by.it.vshelukhin.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

public class CommandIndex implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return Action.INDEX.jsp;
    }
}
