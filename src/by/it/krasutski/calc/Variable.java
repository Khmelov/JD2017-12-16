package by.it.krasutski.calc;

import java.util.HashMap;
import java.util.Map;

public class Variable extends Var {

    private String key;
    private Var value;
    static Map<String, Var> map = new HashMap<>();

    Variable(String key) {
        this.key = key;
    }

    private Variable(String key, Var value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return this.key+"="+this.value;
    }

    @Override
    public Var assign(Var other) throws CalcException {
        if (other instanceof Scalar || other instanceof Vector || other instanceof Matrix) {
            map.put(key, other);
            return new Variable(key, map.get(key));
        } else return super.assign(other);
    }

}
