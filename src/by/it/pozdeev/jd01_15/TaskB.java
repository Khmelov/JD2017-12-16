package by.it.pozdeev.jd01_15;

import by.it.pozdeev.jd01_10.Param;

import java.io.*;

@Param(a = 4, b = 6)

public class TaskB {

    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + "/" + "src" + "/" +
                TaskB.class.getName().replace(TaskB.class.getSimpleName(), "").replaceAll("\\.", "/");
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(path, "TaskB.java")))) {
            StringBuilder sb = new StringBuilder();
            int i;
            boolean flag1 = false, flag2 = false;
            StringBuilder st = new StringBuilder();
            st.append((char) reader.read());
            sb.append(st.charAt(0));
            while ((i = reader.read()) != -1) {
                st.append((char) i);
                if (st.length() > 2) st.deleteCharAt(0);
                if (st.length() > 1) {
                    if (st.charAt(1) == '@') flag2=true;
                    switch (st.toString()) {
                        case ("/*"): {
                            sb.deleteCharAt(sb.length() - 1);
                            flag1 = true;
                            break;
                        }
                        case ("*/"): {
                            flag1 = false;
                            i = reader.read();
                            break;
                        }
                        case ("//"): {
                            sb.deleteCharAt(sb.length() - 1);
                            flag2 = true;
                            break;
                        }

                    }
                    if (!flag1 && !flag2) sb.append((char) i);
                    if (flag2 && st.charAt(1) == '\n') {
                        sb.append("\n");
                        flag2 = false;
                    }
                    /*   /     /      *    @
                     *
                     * */
                    //
                }
            }

            try (PrintWriter writer = new PrintWriter(
                    new FileWriter(new File(path, "TaskB.txt")))) {
                writer.println(sb);}

            System.out.println(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Комментарий

        //Комментарий

        /*
           Комментарий
         */

        /*
            Комментарий
         */

    }
}
