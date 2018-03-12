package by.it.vshelukhin.jd03_04.java;

public enum Action {
    INDEX {
        {
            this.actionCommand = new CommandIndex();
            this.jsp = "/index.jsp";
        }
    },

    PRICE {
        {
            this.actionCommand = new CommandPrice();
            this.jsp = "/price.jsp";
        }
    },

    ORDER {
        {
            this.actionCommand = new CommandOrder();
            this.jsp = "/order.jsp";
        }
    },

    ALLORDERS {
        {
            this.actionCommand = new CommandAllOrders();
            this.jsp = "/allorders.jsp";
        }
    },

    LOGIN {
        {
            this.actionCommand = new CommandLogin();
            this.jsp = "/login.jsp";
        }
    },

    LOGOUT {
        {
            this.actionCommand = new CommandLogout();
            this.jsp = "/logout.jsp";
        }
    },
    REGISTRATION {
        {
            this.actionCommand = new CommandRegistration();
            this.jsp = "/registration.jsp";
        }
    };


    String jsp = "/error.jsp";

    ActionCommand actionCommand;

    ActionCommand getAction() {
        return actionCommand;
    }


}
