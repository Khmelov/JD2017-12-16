package by.it.kozlov.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class CommandIndex extends Action {
    @Override
    public Action execute(HttpServletRequest req) {
        return Actions.INDEX.command;
    }
}
