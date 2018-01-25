package by.it.vshelukhin.jd01_15;

import java.io.*;

public class TaskB {
    static StringBuilder sb;     //стрингбилдер

    static String getPath() {
        StringBuilder sbPath = new StringBuilder();
        sbPath.append(System.getProperty("user.dir"));
        sbPath.append(File.separator);      /*сепаратор*/
        sbPath.append("src");
        sbPath.append(File.separator);          /**сепаратор*/
        sbPath.append((new TaskB()).getClass().getPackageName().replace(".", File.separator));
        sbPath.append(File.separator);
/*      sbPath.append("t");
        sbPath.append(File.separator);
        */
        return sbPath.toString();
    }

    static void readToSB(File file){
        sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int i;
            int temp = -1;
            boolean isAddOne = true;
            boolean isAddMult = true;
            while ((i = reader.read()) != -1) {
                switch ((char) i) {
                    case '/':
                        if ((char)temp == '/'){
                            sb.deleteCharAt(sb.length()-1);
                            isAddOne = false;
                        }

                        if (isAddOne && isAddMult) sb.append((char)i);

                        if ((char)temp == '*'){
                            isAddMult = true;
                        }
                        break;

                    case '*':
                        if ((char)temp == '/'){
                            sb.deleteCharAt(sb.length()-1);
                            isAddMult = false;
                        }

                        if (isAddOne && isAddMult) sb.append((char)i);
                        break;

                    case '\n':

                        if (!isAddOne) isAddOne = true;
                        if (isAddOne && isAddMult) sb.append((char)i);
                        break;

                    default:
                        if (isAddOne && isAddMult) sb.append((char)i);
                }
                temp=i;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void writeSB_ToFile (File file, StringBuilder sb){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(sb.toString());
        }
        /*
        Многострочный коммент
        бла-бла-бла
         */
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        File f = new File(getPath(), "TaskB.java");  /*рабочий файл*/

        readToSB(f);        //читаем в стрингридер

        System.out.println(sb);

        writeSB_ToFile(new File(getPath(),"TaskB.txt"),sb);
    }
}

