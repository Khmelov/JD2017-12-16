package by.it.sendetskaya.jd01_14;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

//Вариант C. В классе TaskC нужно выполнить следующие шаги:
// Вывести список всех фа лов и каталогов вашего пакета
// by.it.фамилия в формате file:имя_файла или dir:имя_каталога.
// Продублировать вывод в консоль в фа л resultTaskC.txt
public class TaskC {
    public static void main(String[] args) {

        String path = System.getProperty("user.dir");
        path = path + "/src/by/it/sendetskaya/jd01_14/";
        File file = new File(path, "resultTaskC.txt");

        Path path1 = Paths.get(path);
        Path pack = path1.getParent();
        try (
                PrintWriter writer = new PrintWriter(
                        new FileWriter(file)
                )) {

            show(pack,writer);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //show
    private static void show(Path path, PrintWriter writer) {
        File filePath = new File(String.valueOf(path) + File.separator);

            if (filePath.isFile()) {
                System.out.printf("file:" + filePath.getName() + "\n");
                writer.printf("file:" + filePath.getName() + "\n");
            }
            if (filePath.isDirectory()) {
                if (filePath.isAbsolute())
                {
                    System.out.printf("dir:.." + filePath.getName() + "\n");
                    writer.printf("dir:.." + filePath.getName() + "\n");
                }
                System.out.printf("dir:" + filePath.getName() + "\n");
                writer.printf("dir:" + filePath.getName() + "\n");
            }


        File[] listfile = path.toFile().listFiles();
            if (listfile != null)
                for (File iterator : listfile) {
                    show(Paths.get(iterator.getAbsolutePath()),writer);
                }

    }
}
