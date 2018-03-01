package by.it.sevashko.project.java;

public enum Actions {

    LOGIN{
        {
            this.command = new CommandLogin();
            this.jsp = "/login.jsp";
        }
    },
    LOGOUT{
        {
            this.command = new CommandLogin();
            this.jsp = "/logout.jsp";
        }
    },
    ERROR{
        {
            this.command = new CommandError();
            this.jsp = "/error.jsp";
        }
    },
    SIGNIN{
        {
            this.command = new CommandError();
            this.jsp = "/error.jsp";
        }
    };

    public String jsp;
    public ActionCommand command;
    public ActionCommand getCommand() {
        return command;
    }
}
