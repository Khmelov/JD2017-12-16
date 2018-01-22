package by.it.kozlov.jd01_12;


import java.util.*;

public class TaskC1 {
    static Map<Integer, String> map = new HashMap<>();
    static int counter = 0;

    public static void main(String[] args) {
        scan();
        System.out.println(map);
        delMap();
        System.out.println(map);
    }

    static void scan() {
        Scanner sc = new Scanner(System.in);
        String str;
        while (!(str = sc.next()).equals("end")) {
            addMap(str);
        }
    }

    static void addMap(String str) {
        map.put(counter, str);
        counter++;
    }

    static void delMap() {
        Set<String> set = new HashSet<>();
        Iterator<Map.Entry<Integer, String>> itr = map.entrySet().iterator();
        while (itr.hasNext()) {
            if (!(set.add(itr.next().getValue().toString()))) {
                itr.remove();
            }
        }
    }
}
