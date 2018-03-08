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
    },INDEX{
        {
            this.command = new CommandIndex();
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
    },CATEGORYCS{
        {
            this.command = new CommandCategoryCS();
        }
    },CATEGORYFICTION{
        {
            this.command = new CommandCategoryFiction();
        }
    },BASKET{
        {
            this.command = new CommandBasket();
        }
    };

    public ActionCommand command;

}
