package by.it.akhmelev.project8.java.controller;

import javax.servlet.http.HttpServletRequest;

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

    public Command command;

    static Command defineCommand(HttpServletRequest request) {
        Command command;
        String action = request.getParameter("command");
        if (action==null)
            action="Index";
        try {
            Actions currentEnum = Actions.valueOf(action.toUpperCase());
            command = currentEnum.command;
        } catch (IllegalArgumentException e) {
            command = Actions.ERROR.command;
        }
        return command;
    }


}
