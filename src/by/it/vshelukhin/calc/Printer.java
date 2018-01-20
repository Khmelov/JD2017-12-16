package by.it.vshelukhin.calc;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class Printer {

    void print(Var var){
        if (var!=null)
            System.out.println(var);
    }

    void printvar(){
        Set<Map.Entry<String,Var>> setData = Data.data.entrySet();
        Iterator it = setData.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

    void sortvar(){
        Map<String,Var> sortData = new TreeMap<>(Data.data);
        Set<Map.Entry<String,Var>> setSortData = sortData.entrySet();
        Iterator it = setSortData.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
