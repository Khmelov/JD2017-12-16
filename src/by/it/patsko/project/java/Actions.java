package by.it.patsko.project.java;

enum Actions {
    LOGIN {
        {
            this.command = new CommandLogIn();
            this.jsp="/login.jsp";
        }
    },LOGOUT{
        {
            this.command = new CommandLogOut();
            this.jsp="/logout.jsp";        }
    },ERROR{
        {
            this.command = new CommandError();
            this.jsp="/error.jsp";
        }
    };

    public String jsp="error.jsp";
    public ActionCommand command;

    public ActionCommand getCommand() {
        return command;
    }
}
