package by.it.patsko.jd02_06.calc;

import java.util.AbstractMap;
import java.util.TreeMap;

class Printer {
    LoggerCalc logger;

    void print(String var) {
        if (var != null) {
            System.out.println(var);
            logger = LoggerCalc.getLogger();
            logger.logWrite(var);
        }
    }

    void printvar() {
        System.out.println(Variable.map);
        logger = LoggerCalc.getLogger();
        logger.logWrite(Variable.map.toString());
    }

    void sortvar() {
        AbstractMap<String, Var> sortedMap = new TreeMap<>(Variable.map);
        System.out.println(sortedMap);
        logger = LoggerCalc.getLogger();
        logger.logWrite(sortedMap.toString());
    }
}
