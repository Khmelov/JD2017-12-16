package by.it.patsko.jd01_12;

import java.util.*;

/*
TaskC2.
Решить заново задачу TaskA2 для любого количества множеств на входе метода,
а также для различных типов данных в каждом из множеств (generics).
В main покажите работоспособность решения.
 */
class TaskC2<T> {
    Set<T> getUnion(Set<T>... a) {
        Set<T> result = new HashSet<>();
        for (Set<T> sets : a) {
            result.addAll(sets);
        }
        return result;
    }

    Set<T> getCross(Set<T>... a) {
        Set<T> result = new HashSet<>(a[0]);
        for (int i = 1; i < a.length; i++) {
            result.retainAll(a[i]);
        }
        return result;
    }

    static void printSet(Set... a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println("Set " + i + ": " + a[i]);
        }
    }

    void printInputData(String dataType, Set... a) {
        System.out.println("Input " + dataType + " data:");
        printSet(a);
    }

    void printData(String methodName, String dataType, Set... a) {
        if (methodName.equals("getUnion")) printInputData(dataType, a);
        System.out.println(dataType + " data after " + methodName + ": ");
        if (methodName.equals("getUnion"))
            printSet(this.getUnion(a[0]),
                    this.getUnion(a[0], a[1]),
                    this.getUnion(a[0], a[1], a[2]),
                    this.getUnion(a[0], a[1], a[2], a[3]));
        else printSet(this.getCross(a[0]),
                this.getCross(a[0], a[1]),
                this.getCross(a[0], a[1], a[2]),
                this.getCross(a[0], a[1], a[2], a[3]));
    }

    public static void main(String[] args) {
        TaskC2 t = new TaskC2();
        TreeSet<Integer> treeSetInt1 = new TreeSet<>(Arrays.asList(1, 1, 2, 2, 3, 4, 5, 5, 11, 22, 33));
        TreeSet<Integer> treeSetInt2 = new TreeSet<>(Arrays.asList(-1, -1, -2, -2, -3, -4, -5, -5, 11, 22, 33));
        HashSet<Integer> hashSetInt1 = new HashSet<>(Arrays.asList(4, 4, 5, 6, 7, 11, 22));
        HashSet<Integer> hashSetInt2 = new HashSet<>(Arrays.asList(-4, -4, -5, -6, -7, 11));
        t.printData("getUnion", "Integer", treeSetInt1, treeSetInt2, hashSetInt1, hashSetInt2);
        t.printData("getCross", "Integer", treeSetInt1, treeSetInt2, hashSetInt1, hashSetInt2);
        System.out.println();

        TreeSet<Double> treeSetDbl1 = new TreeSet<>(Arrays.asList(1.1, 1.1, 2.2, 2.2, 3.3, 4.4, 5.5, 5.5, 11.1, 22.2, 33.3));
        TreeSet<Double> treeSetDbl2 = new TreeSet<>(Arrays.asList(-1.1, -1.1, -2.2, -2.2, -3.2, -4.4, -5.5, -5.5, 11.1, 22.2, 33.3));
        HashSet<Double> hashSetDbl1 = new HashSet<>(Arrays.asList(4.4, 4.4, 5.5, 6.6, 7.7, 11.1, 22.2));
        HashSet<Double> hashSetDbl2 = new HashSet<>(Arrays.asList(-4.4, -4.4, -5.5, -6.6, -7.7, 11.1));
        t.printData("getUnion", "Double", treeSetDbl1, treeSetDbl2, hashSetDbl1, hashSetDbl2);
        t.printData("getCross", "Double", treeSetDbl1, treeSetDbl2, hashSetDbl1, hashSetDbl2);
        System.out.println();

        TreeSet<String> treeSetStr1 = new TreeSet<>(Arrays.asList("яблоко", "яблоко", "банан", "банан", "груша", "слива", "киви", "киви", "лето", "весна", "зима"));
        TreeSet<String> treeSetStr2 = new TreeSet<>(Arrays.asList("Саша", "Саша", "Маша", "Маша", "Коля", "Даша", "Паша", "Паша", "лето", "весна", "зима"));
        HashSet<String> hashSetStr1 = new HashSet<>(Arrays.asList("слива", "слива", "киви", "арбуз", "дыня", "лето", "весна"));
        HashSet<String> hashSetStr2 = new HashSet<>(Arrays.asList("Даша", "Даша", "Паша", "Слава", "Дима", "лето"));
        t.printData("getUnion", "String", treeSetStr1, treeSetStr2, hashSetStr1, hashSetStr2);
        t.printData("getCross", "String", treeSetStr1, treeSetStr2, hashSetStr1, hashSetStr2);
    }
}
