package by.it.vshelukhin.jd03_07.java.controller;

import by.it.vshelukhin.jd03_07.java.controller.*;
import by.it.vshelukhin.jd03_07.java.controller.Action;

public enum Actions {
    INDEX {
        {
            this.actionCommand = new CommandIndex();
            //this.jsp = "/index.jsp";
        }
    },

    PRICE {
        {
            this.actionCommand = new CommandPrice();
            //this.jsp = "/price.jsp";
        }
    },

    ORDER {
        {
            this.actionCommand = new CommandOrder();
            //this.jsp = "/order.jsp";
        }
    },

    ALLORDERS {
        {
            this.actionCommand = new CommandAllOrders();
            //this.jsp = "/allorders.jsp";
        }

    },

    REDPRICE {
        {
            this.actionCommand = new CommandRedPrice();
            //this.jsp = "/allorders.jsp";
        }

    },

    LOGIN {
        {
            this.actionCommand = new CommandLogin();
            //this.jsp = "/login.jsp";
        }
    },

    LOGOUT {
        {
            this.actionCommand = new CommandLogout();
            //this.jsp = "/logout.jsp";
        }
    },
    REGISTRATION {
        {
            this.actionCommand = new CommandRegistration();
            //this.jsp = "/registration.jsp";
        }
    },

    RESETDB {
        {
            this.actionCommand = new CommandResetDB();
            //this.jsp = "/resetdb.jsp";
        }
    },

    ERROR {
        {
            this.actionCommand = new CommandError();
            //this.jsp = "/error.jsp";
        }
    };


    String jsp = "/error.jsp";

    Action actionCommand;

    Action getAction() {
        return actionCommand;
    }


}
