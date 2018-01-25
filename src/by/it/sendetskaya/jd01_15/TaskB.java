/*многострочный комментарий
 на несколько строк
  */
//gjhgjk
 package by.it.sendetskaya.jd01_15;

 import java.io.*;

// Регулярные выражения использовать нельзя


 public class TaskB {

    private static StringBuilder sb;
    private static boolean flagMulti;

    public static void main(String[] args) {


        String path=getRoot();

        File readFile=new File(path,"TaskB.java");
        File writeFile=new File(path,"TaskB.txt");

        readJava(readFile);
        saveFile(writeFile,sb);
    }

    private static String getRoot()
    {
        String path=System.getProperty("user.dir")+
                File.separator+"src"+
                File.separator+
                TaskA.class.getName()
                        .replace(TaskA.class.getSimpleName(),"")
                        .replace(".", File.separator);
        return path;

    }

    //read from java file
    private static void readJava (File file)
    {

        try (
                FileInputStream fs=new FileInputStream(file);

                BufferedReader buf=new BufferedReader
                (new InputStreamReader(fs))
        ) {
            String line;
            String lineAp;

            sb=new StringBuilder();
            while ((line=buf.readLine())!=null)
            {
                lineAp=processFile(line);
                if (!lineAp.equals("@@+")) {
                    sb.append(lineAp);
                    sb.append("\n");
                }

            }
            System.out.print(sb);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

     private static String processFile(String line)
     {
         line=line.trim();

         if (flagMulti&&!line.contains("*/"))
         {
             line=line.replace(line,"@@+");
         }
         if (line.startsWith("//")) {
             line=line.replace(line,"@@+");
         }
         if(line.startsWith("/*"))
         {
             line=line.replace(line,"@@+");
             flagMulti=true;
         }
         if (line.contains("*/"))
         {
             line=line.replace(line,"@@+");
             flagMulti=false;
         }
         return line;
     }

    /*output to txt
    file
     */
    private static void saveFile(File file,StringBuilder sb)
    {
        try (
                PrintWriter writer=new PrintWriter(
                        new FileWriter(file)
                )) {

                    writer.printf(sb.toString());

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

     /** комментарий
      * javadoc
      * @param txtFile
      */
    //read to console
    private static void showFile(File txtFile)
    {
        try (
                BufferedReader reader=new BufferedReader(
                        new FileReader(
                                txtFile
                        ))) {
            String line;
            while ((line=reader.readLine())!=null)
            {
                System.out.println(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
 }
