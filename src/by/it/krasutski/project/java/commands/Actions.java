package by.it.krasutski.project.java.commands;

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
    },
    CREATEAD {
        {
            this.command = new CommandCreateAd();
            this.jsp = "/createad.jsp";
        }
    },
    LISTADS {
        {
            this.command = new CommandListAds();
            this.jsp = "/listads.jsp";
        }
    },
    HOME {
        {
            this.command = new CommandHome();
            this.jsp = "/home.jsp";
        }
    },
    MYADS {
        {
            this.command = new CommandMyAds();
            this.jsp = "/myads.jsp";
        }
    },
    INDEX {
        {
            this.command = new CommandIndex();
            this.jsp = "/index.jsp";
        }
    },
    SIGNUP {
        {
            this.command = new CommandSignUp();
            this.jsp = "/signup.jsp";
        }
    };


    public String jsp = "error.jsp";
    public ActionCommand command;

    public ActionCommand getCommand() {
        return command;
    }
}
