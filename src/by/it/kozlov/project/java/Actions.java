package by.it.kozlov.project.java;

public enum Actions {
    LOGIN{{
        this.comand=new ComandLogin();
        this.jsp="";
    }}, LOGOUT {

    }, ERROR {



    };
    public String jsp = "error.jsp";
    public ActionComand comand;

    public ActionComand getComand() {
        return comand;
    }
}
