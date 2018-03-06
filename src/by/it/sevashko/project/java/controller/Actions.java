package by.it.sevashko.project.java.controller;

public enum Actions {

    INDEX{
        {
            this.command = new CommandIndex();
        }
    },
    LOGIN{
        {
            this.command = new CommandLogin();
        }
    },
    CREATEPUBLICATION{
        {
            this.command = new CommandCreatePublication();
        }
    },
    LOGOUT{
        {
            this.command = new CommandLogout();
        }
    },
    ERROR{
        {
            this.command = new CommandError();
        }
    },
    SIGNUP{
        {
            this.command = new CommandSignup();
        }
    },
    RESETDB{
        {
            this.command = new CommandResetDB();
        }
    };

    public String jsp;
    public Action command;
    public Action getCommand() {
        return this.command;
    }
}
