package by.it.karpeichyk.Calc;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 05.02.2018.
 */
public class VarsMap {
    private  static Map<String,Var> map=new HashMap<>();
    static Var get(String key) {return map.get(key.trim().toUpperCase());}
    static Var set (String key , Var var) {return map.put(key.trim().toUpperCase(),var);}
    static String printvar(){ return  map.toString();}
}
