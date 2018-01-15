package by.it.sevashko.calc;

import java.util.HashMap;

public class Container {

    private HashMap<String, Var> variables = new HashMap<>();

    public void setVariable(String name, Var value) {
        this.variables.put(name, value);
    }

    public Var getVariable(String name) {
        return variables.get(name);
    }

    @Override
    public String toString() {
        return variables.toString();
    }
}
