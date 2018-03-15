package by.it.vshelukhin.jd03_06.java.controller;

import javax.servlet.http.HttpServletRequest;

public class CommandIndex extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
        return Actions.INDEX.actionCommand;
    }
}
