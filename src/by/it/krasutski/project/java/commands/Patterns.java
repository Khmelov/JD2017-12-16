package by.it.krasutski.project.java.commands;

public interface Patterns {

    String LOGIN = "[a-zA-Z0-9]{6,20}";
    String EMAIL = "[a-zA-Z0-9.-_ ]+@[a-zA-Z0-9.-_ ]+\\.[a-zA-Z0-9.-_ ]+";
    String PASSWORD  = "[a-zA-Z0-9]{6,30}";
    String NICKNAME  = "[a-zA-Z0-9]{6,30}";
}
