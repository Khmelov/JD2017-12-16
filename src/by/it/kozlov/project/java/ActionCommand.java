package by.it.kozlov.project.java;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

public interface ActionCommand {
    String execute(HttpServletRequest req) throws ParseException, SQLException;
}
