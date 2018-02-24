package by.it.akhmelev.project5.java;

import by.it.akhmelev.project5.java.ActionCommand;
import by.it.akhmelev.project5.java.CommandError;
import by.it.akhmelev.project5.java.CommandLogin;
import by.it.akhmelev.project5.java.CommandLogout;

public enum Actions {
    SIGNUP {
        {
            this.command = new CommandSignup();
            this.jsp = "/signup.jsp";
        }
    },
    LOGIN {
        {
            this.command = new CommandLogin();
            this.jsp = "/login.jsp";
        }
    },
    LOGOUT {
        {
            this.command = new CommandLogout();
            this.jsp = "/logout.jsp";
        }
    },
    ERROR {
        {
            this.command = new CommandError();
            this.jsp = "/error.jsp";
        }
    };

    public String jsp = "error.jsp";
    public ActionCommand command;
    public ActionCommand getCommand() {
        return command;
    }
}
