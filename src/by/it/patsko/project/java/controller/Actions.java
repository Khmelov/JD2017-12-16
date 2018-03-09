package by.it.patsko.project.java.controller;

import by.it.patsko.project.java.controller.commands.*;
import by.it.patsko.project.java.controller.commands.crudCommands.*;

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
    },CATEGORY{
        {
            this.command = new CommandCategory();
        }
    },BASKET{
        {
            this.command = new CommandBasket();
        }
    }
    //-----------------------CRUD-------------------
    ,CRUDROLES{
        {
            this.command = new CommandCrudRoles();
        }
    },CRUDCATALOGS{
        {
            this.command = new CommandCrudCatalogs();
        }
    },CRUDUSERS{
        {
            this.command = new CommandCrudUsers();
        }
    },CRUDBOOKS{
        {
            this.command = new CommandCrudBooks();
        }
    },CRUDCATEGORIES{
        {
            this.command = new CommandCrudCategories();
        }
    },CRUDLISTOFPURCHASES{
        {
            this.command = new CommandCrudListOfPurchases();
        }
    };

    public ActionCommand command;

}
