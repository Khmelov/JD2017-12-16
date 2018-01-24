package by.it.vshelukhin.calc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Data {
    static Map<String, Var> data = new HashMap<>();

    static void writeMapInFile() {
        String root = System.getProperty("user.dir") + File.separator + "src" + File.separator +
                Data.class.getPackage().toString().replace("package ","").replace(".", "\\") + File.separator;
        File f = new File(root, "vars.txt");
        Set<Map.Entry<String, Var>> sMap = data.entrySet();
        Iterator<Map.Entry<String, Var>> it = sMap.iterator();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(f))) {
            while (it.hasNext()) {
                writer.write((it.next()).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
