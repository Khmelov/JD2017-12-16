package by.it.krasutski.project.java.commands;

public enum Actions {
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
    CREATECATEGORY {
        {
            this.command = new CommandCreateCategory();
        }
    },
    EDITCATEGORY {
        {
            this.command = new CommandEditCategory();
        }
    },
    EDITUSERS {
        {
            this.command = new CommandEditUsers();
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
    PROFILE {
        {
            this.command = new CommandProfile();
        }
    },
    SIGNUP {
        {
            this.command = new CommandSignUp();
        }
    };


    public Action command;
}
