package by.it.vshelukhin.jd01_12;

import java.util.*;

import static java.lang.Math.*;

public class TaskC1 {
    static Map<Integer,String> c1 = new TreeMap<>();
    static Map<Integer,String> c1Cut = new TreeMap<>();

    static int getUniqueCode(){
        int code = (int)(random()*100);
        while (c1.containsKey(code)){
            code = (int)(random()*100);
        }
        return code;
    }

    static Map<Integer,String> removeDubl (Map<Integer,String> input_map){
        Map<Integer,String> result = new TreeMap<>();
        Set<Map.Entry<Integer,String>> setInputMap = input_map.entrySet();
        Iterator it = setInputMap.iterator();
        while (it.hasNext()){
            Map.Entry<Integer,String> current = (Map.Entry<Integer, String>) it.next();  //вопрос по типам
            if (!result.containsValue(current.getValue())) result.put(current.getKey(),current.getValue());
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        while (!text.equals("end")) {
            int u = getUniqueCode();
            c1.put(u,text);
            text = sc.nextLine();
        }
        System.out.println(c1);
        c1Cut = removeDubl(c1);
        System.out.println(c1Cut);
    }
}
