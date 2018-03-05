package by.it.krasutski.project.java.commands;

public enum Actions {
    LOGIN {
        {
            this.command = new CommandLogin();
        }
    },
    LOGOUT {
        {
            this.command = new CommandLogout();
        }
    },
    ERROR {
        {
            this.command = new CommandError();
        }
    },
    CREATEAD {
        {
            this.command = new CommandCreateAd();
        }
    },
    HOME {
        {
            this.command = new CommandHome();
        }
    },
    MYADS {
        {
            this.command = new CommandMyAds();
        }
    },
    SIGNUP {
        {
            this.command = new CommandSignUp();
        }
    };


    public Action command;
}
