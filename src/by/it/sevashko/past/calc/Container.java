package by.it.sevashko.calc;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Container {

    private static HashMap<String, Var> map = new HashMap<>();

    static Var set(String key, Var value){
        return map.put(key, value);
    }

    static Var get(String key, Var value){
        return map.get(key);
    }

    public static String printVar() {
        StringBuilder sb = new StringBuilder();
        sb.append("Содержимое контейнера:\n");
        for (Map.Entry<String, Var> entry : map.entrySet()){
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
            sb.append("\n");
        }
        return sb.toString();
    }

    public static String sortVar() {
        TreeMap<String, Var> map = new TreeMap<>(Container.map);
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
