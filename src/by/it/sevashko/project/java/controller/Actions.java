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
    PROFILE{
        {
            this.command = new CommandProfile();
        }
    },
    EDITUSERS{
        {
            this.command = new CommandEditUsers();
        }
    },
    EDITPUBLICATIONS{
        {
            this.command = new CommandEditPublications();
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
