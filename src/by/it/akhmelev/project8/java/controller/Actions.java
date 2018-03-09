package by.it.akhmelev.project8.java.controller;

import by.it.akhmelev.project8.java.controller.*;
import by.it.akhmelev.project8.java.controller.Action;

public enum Actions {
    INDEX {
        {
            this.command = new CommandIndex();
        }
    },
    CREATEAD {
        {
            this.command = new CommandCreateAD();
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
    PROFILE {
        {
            this.command = new CommandProfile();
        }
    },
    EDITUSERS {
        {
            this.command = new CommandEditUsers();
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
    };

    public Action command;

}
