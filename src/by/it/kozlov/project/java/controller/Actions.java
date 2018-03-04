package by.it.kozlov.project.java.controller;

public enum Actions {
    LOGIN {
        {
            this.command = new CommandLogin();
        }
    }, LOGOUT {
        {
            this.command = new CommandLogout();
        }
    }, ERROR {
        {
            this.command = new CommandError();
        }
    }, SIGNUP {
        {
            this.command = new CommandSignUp();
        }
    }, INDEX {
        {
            this.command = new CommandIndex();
        }
    }, ADDCAR {
        {
            this.command = new CommandAddCar();
        }
    };

    public Action command;
}
