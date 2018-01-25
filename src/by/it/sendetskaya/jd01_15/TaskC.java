package by.it.sendetskaya.jd01_15;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

//КлассTaskCНужнореализоватьнаjavaприложение-аналогкомандно строки
// Windows.Приложениедолжно использовать класс File и поддерживать
// две команды консоли:
// команду cd - смена каталога (посмотрите пример: Win+R → cmd →
// cd \ → dir ). В тестах проверяются всего две команды cd .. и cd
// имя_папки_в_текущем_каталоге
// команду dir - вывод каталога, формат вывода - аналогичны  формату
// в Windows.
// командаend–завершениеработы.
// Стартовымкаталогомпризапускеприложениядолжнабытьпапкаby.it.ваша
// _фамилия.
public class TaskC {
    public static void main(String[] args) {

        boolean flag=true;

        String pathCurrent = getRoot();
        String namePackage="";
        System.out.println(pathCurrent);
        Path pathGet = Paths.get(pathCurrent);
        System.out.println("Выберите команду:");
        System.out.println("Для смены каталога введите: cd имя_папки_в_текущем_каталоге");
        System.out.println("Для возврата в родительский каталог введите: cd..");
        System.out.println("Для вывода каталога введите: dir");
        System.out.println("Для выхода: end");

        while (flag) {
            Scanner sc = new Scanner(System.in);
            String choose = sc.nextLine();

            if (choose.startsWith("cd ")) {
                namePackage = choose.replace("cd ", "");
                choose = "cd";
                while (!chekPackage(pathGet,namePackage))
                {
                    pathGet=pathGet.getParent();
                    pathCurrent=pathGet.toString()+File.separator;
                }

            }
            switch (choose) {
                case "cd": {
                    String pathChoose = pathCurrent + namePackage;
                    System.out.println(pathChoose);
                    Path pathGetChoose = Paths.get(pathChoose);

                    pathGet = pathGetChoose;
                    System.out.println("-----------------------------");
                    break;
                }
                case "cd..": {
                    Path pack = pathGet.getParent();
                    System.out.println(pack);
                    pathGet = pack;
                    System.out.println("-----------------------------");
                    break;
                }
                case "dir": {
                    showDir(pathGet);
                    System.out.println("-----------------------------");
                    break;
                }
                case "end": {
                    flag=false;
                    break;
                }
                default: {
                    System.out.println("Вы не ввели либо неправильно ввели команду");
                    break;
                }

            }
        }


    }

    private static String getRoot()
    {
        String path=System.getProperty("user.dir");
        path = path + "/src/by/it/sendetskaya/";

        return path;

    }

    //show
    private static void showDir(Path path) {
        File filePath = new File(String.valueOf(path) + File.separator);

        if (filePath.isFile()) {
            System.out.printf("file: " + filePath.getName() + "\n");
        }
        if (filePath.isDirectory()) {
            if (filePath.isAbsolute())
            {
                System.out.printf("dir:.. " + filePath.getName() + "\n");
            }
            System.out.printf("dir: " + filePath.getName() + "\n");
        }


        File[] listfile = path.toFile().listFiles();
        if (listfile != null)
            for (File iterator : listfile) {
                showDir(Paths.get(iterator.getAbsolutePath()));
            }

    }

    //show
    private static boolean chekPackage (Path path, String namePack) {
        boolean flag=false;
        File filePath = new File(String.valueOf(path) + File.separator);

        File[] listfile = path.toFile().listFiles();
        if (listfile != null)
            for (File iterator : listfile) {
                try {
                    if(iterator.getCanonicalPath().contains(namePack)) {
                        flag = true;
                        return flag;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return flag;
    }


}
