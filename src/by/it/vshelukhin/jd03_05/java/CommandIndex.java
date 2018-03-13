package by.it.vshelukhin.jd03_05.java;

import javax.servlet.http.HttpServletRequest;

public class CommandIndex extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
        return Actions.INDEX.actionCommand;
    }
}
