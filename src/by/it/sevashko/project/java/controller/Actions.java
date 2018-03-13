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
    SHOWSUBSCRIPTIONS{
        {
            this.command = new CommandShowSubscriptions();
        }
    },
    CREATESUBSCRIPTION{
        {
            this.command = new CommandCreateSubscription();
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
    EDITSUBSCRIPTIONS{
        {
            this.command = new CommandEditSubscriptions();
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

    public Action command;
    public Action getCommand() {
        return this.command;
    }
}
