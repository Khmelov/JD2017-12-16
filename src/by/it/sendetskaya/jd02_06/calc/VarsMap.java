package by.it.sendetskaya.jd02_06.calc;

import java.util.HashMap;
import java.util.Map;

class VarsMap extends Var{

    static Map<String, Var> map=new HashMap<>();

    public VarsMap() {
    }

    static Var get(String key){
        return map.get(key.trim().toUpperCase());
    };

    static void set(String key, Var var){
        map.put(key.trim().toUpperCase(), var);
    }

//    //static String printvar() {
//        return map.toString();
//    }

}
