package by.it.akhmelev.project.java;

public enum Actions {
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
