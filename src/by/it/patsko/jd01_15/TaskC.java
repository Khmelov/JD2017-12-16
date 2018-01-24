package by.it.patsko.jd01_15;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
Класс TaskC
Нужно реализовать на java приложение -аналог командной строки Windows.
Приложение должно использовать класс File и поддерживать две команды консоли:
команду cd-смена каталога (посмотрите пример: Win+R→cmd→cd \→dir).В тестах проверяются всего две команды cd ..и cd имя_папки_в_текущем_каталоге
команду dir-вывод каталога, формат вывода -аналогичный формату в Windows.
команда end–завершение работы.
Стартовым каталогом при запуске приложения должна быть папка by.it.ваша_фамилия.
 */
public class TaskC {
    private static String currentDir = TaskA.getPath().replace("\\jd01_15\\", "\\jd01_15");

    public static void main(String[] args) {
        System.out.println(currentDir);
        try (BufferedReader bis = new BufferedReader(
                new InputStreamReader(System.in)
        )) {
            String command;
            while (!(command = bis.readLine()).equals("end")) {
                if (command.equals("dir")) dirCommand(currentDir);
                else if (command.contains("cd")) currentDir = cdDotsCommand(command);
                else System.out.printf("\"%s\" не является внутренней или внешней командой," +
                            "исполняемой программой или пакетным файлом.", command);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void dirCommand(String currentDir) {
        File file = new File(currentDir);
        if (file.isDirectory()) {
            /*System.out.println(" Серийный номер тома: " + getHardwareID());
            System.out.println();*/
            System.out.println(" Содержимое папки " + currentDir + "\n");
            showDir(file);
        }
    }

    //===============??????????????????=====================
    /*private static String getHardwareID() {
        try {
            Process p = Runtime.getRuntime().exec("cmd /C dir");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));
            String line = null;
            int count = 0;
            while ((line = in.readLine()) != null) {
                count++;
                if (count < 2) continue;
                if (count > 2) break;
                return line.substring(line.lastIndexOf(' ') + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }*/
    //==================================================
    //При операциях с путями точка "." обозначает текущий каталог, а две точки ".." - каталог уровнем выше.
    private static void showDir(File file) {
        File[] files = file.listFiles();
        int numOfFiles = 0, numOfDirs = 0, filesLength = 0;

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy\tHH:mm\t");
        System.out.print(format.format(new Date(file.lastModified())));
        numOfDirs++;
        System.out.printf("%-15s\t%s\n", "<DIR>", ".");
        System.out.print(format.format(new Date(new File(file.getParent()).lastModified())));
        numOfDirs++;
        System.out.printf("%-15s\t%s\n", "<DIR>", "..");//???????????

        for (File f : files) {
            System.out.print(format.format(new Date(f.lastModified())));

            if (f.isDirectory()) {
                numOfDirs++;
                System.out.printf("%-15s\t%s\n", "<DIR>", f.getName());
            } else {
                numOfFiles++;
                filesLength += f.length();
                System.out.printf("%,14d\t%s\n", f.length(), f.getName());
            }
        }
        System.out.printf("\t\t\t\t%d файлов\t\t%,d байт\n", numOfFiles, filesLength);
        File rootDisk = new File(files[0].getAbsolutePath().substring(0, 2));
        System.out.printf("\t\t\t\t%d файлов\t%,d байт свободно", numOfDirs, rootDisk.getFreeSpace());

    }

    private static String cdDotsCommand(String command) {
        if (command.equals("cd..")) {
            File currentfile = new File(currentDir);
            File newfile = new File(currentfile.getParent());
            System.out.println(newfile.getAbsolutePath());
            return currentDir.replace(File.separator + currentfile.getName(), "");
        } else {
            String filename = command.replace("cd ", "");
            currentDir = currentDir + File.separator + filename;
            File newfile = new File(currentDir);
            System.out.println(newfile.getAbsolutePath());
            return currentDir;
        }
    }
}
