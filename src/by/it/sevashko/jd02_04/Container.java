package by.it.sevashko.jd02_04;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Container {

    private static HashMap<String, Var> vars = new HashMap<>();

    static Var setVar(String key, Var value){
        return vars.put(key, value);
    }

    static Var getVar(String key){
        return vars.get(key);
    }

    public static String printVar() {
        StringBuilder sb = new StringBuilder();
        sb.append("Содержимое контейнера:\n");
        for (Map.Entry<String, Var> entry : vars.entrySet()){
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
            sb.append("\n");
        }
        return sb.toString();
    }

    public static String sortVar() {
        TreeMap<String, Var> map = new TreeMap<>(Container.vars);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Var> entry : map.entrySet()){
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
            sb.append("\n");
        }
        return sb.toString();
    }
}
