package by.it.akhmelev.calc.calc_v2;

import java.util.HashMap;
import java.util.Map;

class VarsMap {

    private static Map<String,Var> map=new HashMap<>();

    static Var get(String key){
        return map.get(key);
    };

    static void set(String key, Var var){
        map.put(key, var);
    }

    static String printvar() {
        return map.toString();
    }
}
