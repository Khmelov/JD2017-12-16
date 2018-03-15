package by.it.karpeichyk.Project.java;

/**
 * Created by user on 22.02.2018.
 */
public enum  Action {
    PROFILE {
        {
            this.command = new CommandCreateAd();

        }
    }, CREATEAD {
        {
            this.command = new CommandCreateAd();

        }
    }, INDEX {
        {
            this.command = new CommandIndex();

        }
    },
    SIGNUP {
        {
            this.command = new CommandSignup();

        }
    },
    RESETDB {
        {
            this.command = new CommandResetDB();

        }
    },
    LOGIN {
        {
            this.command = new CommandLogin();

        }
    },
    LOGOUT {
        {
            this.command = new CommandLogOut();
        }
    },
    ERROR {
        {
            this.command =  new CommandError();
        }
    };


    public AbstractAction command;
}


