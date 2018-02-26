package by.it.kozlov.project.java;

public enum Actions {
    LOGIN {
        {
            this.command = new CommandLogin();
            this.jsp = "/login.jsp";
        }
    }, LOGOUT {
        {
            this.command = new CommandLogout();
            this.jsp = "/logout.jsp";
        }
    }, ERROR {
        {
            this.command = new CommandError();
            this.jsp = "/error.jsp";
        }
    },
    SIGNUP {
        {
            this.command = new CommandSignUp();
            this.jsp = "/signup.jsp";
        }
    }, INDEX{
        {
            this.command = new CommandIndex();
            this.jsp = "/index.jsp";
        }
    };
    public String jsp = "error.jsp";
    public ActionCommand command;

    public ActionCommand getCommand() {
        return command;
    }
}
