package by.it.viktorbrui.project.java.sample_controller;

import javax.servlet.http.HttpServletRequest;

class ActionFactory {
    ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand current = new CommandError();
        String action = request.getParameter("command");
        if (action != null && !action.isEmpty()) {
            try {
                Actions currentEnum = Actions.valueOf(action.toUpperCase());
                current = currentEnum.getCurrentCommand();
            } catch (IllegalArgumentException e) {
                request.setAttribute(Messages.msgError, "<b>Unknown command: "+action+"</b>");
                request.setAttribute(Messages.msgMessage, "<b>Unknown command: "+action+"</b>");
            }
        }
        return current;
    }
}