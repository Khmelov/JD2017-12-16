package by.it.sevashko.jd01_15;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;

public class TaskC {

    private static File src;
    private static int dirCount;
    private static int fileCount;
    private static long size;

    static{
        src = new File(System.getProperty("user.dir") + "/src/by/it/sevashko/jd01_15");
    }
    public static void main(String[] args) {
        printSrc();
        try (BufferedReader dti = new BufferedReader(new InputStreamReader(System.in))){
            String line;
            while (!(line = dti.readLine()).equals("end")){
                parselLine(line.trim());
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void printSrc(){
        System.out.printf("%s%s", src, '>');
    }

    private static void parselLine(String line){
        String[] elements = line.split(" ");
        switch (elements[0]){
            case "cd":{
                changeDir(elements[1]);
                break;
            }
            case "dir":{
                printContent();
                break;
            }
        }

    }

    private static void changeDir(String path){
        if (path.equals("..")) src = src.getParentFile();
        else {
            if (Paths.get(path).getRoot() != null && new File(path).exists()){
                src = new File(path);
            } else {
                if (path.startsWith("..")) {
                    path = path.replace("..", "");
                    File newPath = new File(String.format("%s%s",src.getParentFile().toString(), path));
                    if (newPath.exists()) src = newPath;
                    printSrc();
                    return;
                }
                File newPath = new File(String.format("%s%s%s",src.toString(), File.separator, path));
                if (newPath.exists()) src = newPath;
            }
        }
        printSrc();
    }

    private static void printContent(){
        File[] content = src.listFiles();
        System.out.printf("Cодержимое папки %s\n\n", src);
        dirCount = 0;
        fileCount = 0;
        size = 0;
        System.out.println(getLine(src));
        if (src.getParentFile() != null) System.out.println(getLine(src.getParentFile()));
        if (content != null) {
            for (File element : content) {
                String line = getLine(element);
                System.out.println(line);
            }
        }
        System.out.printf("%16d файлов %,13d байт\n", fileCount, size);
        System.out.printf("%16d папок %,14d байт свободно\n", dirCount, src.getFreeSpace());
        System.out.println();
        printSrc();
    }

    private static String getDate(File file){
        StringBuilder line = new StringBuilder();
        Calendar date = Calendar.getInstance();
        try {
            date.setTimeInMillis(Files.getLastModifiedTime(file.toPath()).toMillis());
        } catch (IOException e){
            e.printStackTrace();
        }
        line.append(String.format("%02d.%02d.%4d", date.get(Calendar.DAY_OF_MONTH), date.get(Calendar.MONTH)+1, date.get(Calendar.YEAR)));
        line.append(String.format("  %02d:%02d", date.get(Calendar.HOUR_OF_DAY), date.get(Calendar.MINUTE)));
        return line.toString();
    }

    private static String getLine(File element){
        StringBuilder line = new StringBuilder();
        line.append(getDate(element));
        if (element.isDirectory()) {
            line.append("    <DIR>");
            line.append("          ");
            dirCount++;
        }
        else {
            fileCount++;
            line.append("         ");
            try {
                line.append(String.format("%,10d ", Files.size(element.toPath())));
                size += Files.size(element.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (element.equals(src)){
            line.append(".");
        } else if (element.equals(src.getParentFile())){
            line.append("..");
        }
        else line.append(element.getName());
        return line.toString();
    }
}
