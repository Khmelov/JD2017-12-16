package by.it.ikiselev.jd01_15;

import java.io.*;
/*для
удаления
 */

/**
 * ащк
 */
public class TaskB {
    public static void main(String[] args) throws IOException {
        //путь к файлу от корня проекта, здесь корень System.getProperty("user.dir")
        String src=System.getProperty("user.dir")+"/src/by/it/ikiselev/";
        String filename = src+"jd01_15/TaskB2.java";
        StringBuilder out = new StringBuilder();
       // int oneStr=0;
        int manyStrBegin=0;
        int manyStrEnd=0;
        try (BufferedReader bufferedReader=
                     new BufferedReader(
                             new FileReader(filename))){
            String line;

            //пока линия читается, присвоим ее и тут же сравним с null
            while ((line = bufferedReader.readLine())!=null){
                String helpLine="";
                line=line+" ";
            //    int oneStr=0;
                for (int i = 0; i < line.length()-1; i++) {
                    if((line.charAt(i)=='/') && (line.charAt(i+1)=='*')){
                        manyStrBegin=1;
                        break;
                    }
                    for (int j = line.length()-2; j >0 ; j--) {
                        if ((line.charAt(j)=='/') && (line.charAt(j-1)=='*'))
                        {manyStrBegin=0;
                            manyStrEnd=1;}
                        break;

                    }
                    if (manyStrEnd==1){manyStrEnd=0;break;}
                    if (manyStrBegin==1 ) break;

                    if((line.charAt(i)=='/') && (line.charAt(i+1)=='/')){
                     //   oneStr=1;
                       break;
                    }


                  //  if (oneStr !=1){
                        helpLine=helpLine+line.charAt(i);
                  //  }
                }
                out.append(helpLine).append("\n"); //линия прочиталась. Добавим ее в выходную строку

            }
        } catch (IOException e) {
            throw new IOException("Not read "+filename,e);
        }
        String fileOutTxt = src+"JD01_15/TaskB2.txt";
        try (PrintWriter printer=
                     new PrintWriter(
                             new FileWriter(fileOutTxt))){
            printer.println(out);  //тут что-то печатаем, для примера - все ту же коллекцию
            //обратите внимание как она выводится.
            System.out.print(out); //для этого продублируем на консоль
            //так работает наш анонимный класс.
        } catch (IOException e) {
            throw new IOException("Not write "+fileOutTxt,e);
        }

//nm mn
//        File f = new File(filename); // объект для связи с файлом на диске
//        int b, count = 0;
//        FileReader is = null;        //объявляем до try, чтобы is был доступен в finally
//        try {
//            is = new FileReader(f);                 //так читаем СИМВОЛЫ
//            while ((b = is.read()) != -1) {         // чтение одного байта.
//                System.out.print((char) b);
//                count++;
//            }
//            System.out.println("\n Число байт = " + count);
//            System.out.println(" Кодировка "+is.getEncoding());
//        } catch (IOException e) {
//            System.err.println(" Ошибка файла: " + e );
//        } finally {
//            try {
//                if (is != null) {
//                    is.close(); // закрытие потока ввода. НУЖНО ДЕЛАТЬ ВСЕГДА.
//                }
//            } catch (IOException e)
//            {System.err.println("ошибка закрытия: " + e);}
//        }
    }
}
