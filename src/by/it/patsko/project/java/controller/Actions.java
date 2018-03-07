package by.it.patsko.project.java.controller;

import by.it.patsko.project.java.controller.commands.*;

public enum Actions {
    LOGIN {
        {
            this.command = new CommandLogIn();
        }
    },LOGOUT{
        {
            this.command = new CommandLogOut();
        }
    },ERROR{
        {
            this.command = new CommandError();
        }
    },SIGNUP{
        {
            this.command = new CommandSignUP();
        }
    },CATALOG{
        {
            this.command = new CommandCatalog();
        }
    },INITDB{
        {
            this.command = new CommandInitDB();
        }
    },RESETDB{
        {
            this.command = new CommandResetDB();
        }
    },PROFILE{
        {
            this.command = new CommandProfile();
        }
    },CATEGORY{
        {
            this.command = new CommandCategory();
        }
    },CATEGORYFICTION{
        {
            this.command = new CommandCategoryFiction();
        }
    },TOBASKET{
        {
            this.command = new CommandToBasket();
        }
    },BASKET{
        {
            this.command = new CommandBasket();
        }
    };

    public ActionCommand command;

}
