package by.it.sevashko.jd01_12;

import java.util.*;

public class TaskC1 {

    private static TreeMap<Integer, String> container = new TreeMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;
        while (!(line = sc.nextLine()).equals("end")){
            int id = getId();
            container.put(id, line);
        }
        for(Map.Entry<Integer, String> entry : container.entrySet()){
            System.out.printf("%d %s\n", entry.getKey(), entry.getValue());
        }
        System.out.println(container.values());
        System.out.println();
        compress();
        for(Map.Entry<Integer, String> entry : container.entrySet()){
            System.out.printf("%d %s\n", entry.getKey(), entry.getValue());
        }
        System.out.println(container.values());
    }

    private static int getId(){
        int id = (int) (Math.random() * Integer.MAX_VALUE);
        if (container.containsKey(id)) return getId();
        return id;
    }

    private static void compress(){
        Set<String> pool = new HashSet<>(container.values());
        Iterator<Map.Entry<Integer, String>> iterator = container.entrySet().iterator();
        while (iterator.hasNext()){
            String value = iterator.next().getValue();
            if (pool.contains(value)) pool.remove(value);
            else iterator.remove();
        }
    }
}
