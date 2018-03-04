package by.it.karpeichyk.Project.java;

/**
 * Created by user on 22.02.2018.
 */
public enum  Action {
    CreateAd {
        {
            this.command = new CommandCreateAd();
            this.jsp = "/createad.jsp";
        }
    },
    SIGNUP {
        {
            this.command = new CommandSignup();
            this.jsp = "/signup.jsp";
        }
    },
    RESETDB {
        {
            this.command = new CommandResetDB();
            this.jsp = "/resetdb.jsp";
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
            this.command = new CommandLogOut();
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


