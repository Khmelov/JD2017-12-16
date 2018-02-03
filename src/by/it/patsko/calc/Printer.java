package by.it.patsko.calc;

import java.util.AbstractMap;
import java.util.TreeMap;

class Printer {
    void print(String var) {
        if (var != null) System.out.println(var);
    }

    void printvar() {
        /*System.out.println("----printvar----");
        Set<Map.Entry<String, Var>> setVariable = Variable.map.entrySet();
        for (Map.Entry<String, Var> kv : setVariable)
            System.out.println(kv);*/
        System.out.println(Variable.map);
    }
    void sortvar(){
        AbstractMap<String, Var> sortedMap=new TreeMap<>(Variable.map);
        /*System.out.println("----sortedvar----");
        Set<Map.Entry<String, Var>> setVariable = sortedMap.entrySet();
        for (Map.Entry<String, Var> kv : setVariable)
            System.out.println(kv);*/
        System.out.println(sortedMap);
    }
}
