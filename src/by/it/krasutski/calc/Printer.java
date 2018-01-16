package by.it.krasutski.calc;

import java.util.*;

public class Printer {
    void print(Var var) {
        if (var != null)
            System.out.println(var);
    }

    void printVariable() {
        System.out.println("Print variables:");
        Set<Map.Entry<String, Var>> setVariable = Variable.map.entrySet();
        for (Map.Entry<String, Var> keyValue : setVariable)
            System.out.println(keyValue);
    }

    void sortVariable() {
        AbstractMap<String, Var> sortedMap = new TreeMap<>(Variable.map);
        System.out.println("Sorted variables:");
        Set<Map.Entry<String, Var>> setVariable = sortedMap.entrySet();
        for (Map.Entry<String, Var> keyValue : setVariable)
            System.out.println(keyValue);
    }

}
