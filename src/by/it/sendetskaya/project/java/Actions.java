package by.it.sendetskaya.project.java;

public enum Actions {
    //в одном экземпляре сущ enum
    LOGIN{
        {
            this.command=new CommandLogin();
            this.jsp="/login.jsp";
        }
    },
    LOGOUT{
        {
            this.command=new CommandLogout();
            this.jsp="/logout.jsp";
        }
    },
    ERROR{
        {
            this.command=new CommandError();
            this.jsp="/error.jsp";
        }
    },
    INDEX{
        {
            this.command=new CommandIndex();
            this.jsp="/index.jsp";
        }
    },
    MAIN{
        {
            this.command=new CommandMain();
            this.jsp="/main.jsp";
        }
    },
    SIGNUP{
        {
            this.command=new CommandSignup();
            this.jsp="/signup.jsp";
        }
    };

    public String jsp="/error.jsp";
    public ActionCommand command;

    public ActionCommand getCommand() {
        return command;
    }
}
