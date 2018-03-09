package by.it.sevashko.jd01_14;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class TaskC {

    private static StringBuilder contentOfAll = new StringBuilder();

    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        printContent(path + "/src/by/it/sevashko");
        System.out.print(contentOfAll);
        File resultFile = new File(path, "/src/by/it/sevashko/jd01_14/resultTaskC.txt");
        try (PrintStream ps = new PrintStream(resultFile)){
            ps.print(contentOfAll);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void printContent(String path){
        printContent(path, 0);
    }

    private static void printContent(String path, int level){
        String indent = getIndent(level);
        File something = new File(path);
        File[] content = something.listFiles();
        if (content != null) {
            contentOfAll.append(String.format("%sdir:.\n",indent));
            contentOfAll.append(String.format("%sdir:..\n",indent));
            for (File item : content) {
                if (item.isDirectory()) {
                    contentOfAll.append(String.format("%sdir:%s\n",indent, item.getName()));
                    printContent(item.getAbsolutePath(), level + 1);
                } else {
                    contentOfAll.append(String.format("%sfile:%s\n", indent, item.getName()));
                }
            }
        }
    }

    private static String getIndent(int level){
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < level; i++) {
            indent.append("\t");
        }
        return indent.toString();
    }
}
