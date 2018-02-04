package by.it.krasutski.calc;

import java.util.*;

public class Printer {
    void print(String var) {
        if (var != null)
            System.out.println(var);
    }

    void printVariable() {
        System.out.println(Variable.map);
    }

    void sortVariable() {
        AbstractMap<String, Var> sortedMap = new TreeMap<>(Variable.map);
        System.out.println(sortedMap);
    }
}
