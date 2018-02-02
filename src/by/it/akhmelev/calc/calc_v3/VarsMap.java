package by.it.akhmelev.calc.calc_v3;

import java.util.HashMap;
import java.util.Map;

class VarsMap {

    private static Map<String,Var> map=new HashMap<>();

    static Var get(String key){
        return map.get(key.trim().toUpperCase());
    };

    static void set(String key, Var var){
        map.put(key.trim().toUpperCase(), var);
    }

    static String printvar() {
        return map.toString();
    }
}
