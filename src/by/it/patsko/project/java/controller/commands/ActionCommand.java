package by.it.patsko.project.java.controller.commands;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

public abstract class ActionCommand {
    public abstract ActionCommand execute(HttpServletRequest req) throws ParseException, SQLException;

    public String getJSP(){
        return  "/".concat(this.toString().toLowerCase()).concat(".jsp");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName().replace("Command","");
    }
}
