package by.it.viktorbrui.jd01_09;


import org.junit.Test;

import java.io.*;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@SuppressWarnings("all")

//поставьте курсор на следующую строку и нажмите Ctrl+Shift+F10
public class Test_jd01_09 {

    @Test(timeout = 1500)
    public void testTaskA__ConsoleRunner() throws Exception {
        run(            "3.8+26.2\n" +
                        "87.4-23.1\n" +
                        "1.04*5.9\n" +
                        "12.7*5\n" +
                        "6+12\n" +
                        "7*3.1\n" +
                        "4/8\n" +
                        "9-0.9\n" +
                        "end\n")
                .include("30.0")    //3.8+26.2=30.0
                .include("64.3")    //87.4-23.1=64.3 
                .include("6.136")   //1.04*5.9=6.136 
                .include("63.5")    //12.7*5=63.5 
                .include("18.0")    //6+12=18.0
                .include("21.7")    //7*3.1=21.7 
                .include("0.5")     //4/8=0.5 
                .include("8.1")     //9-0.9=8.1 
        ;

    }

    @Test(timeout = 1500)
    public void testTaskB__ConsoleRunner() throws Exception {
        run(    "{2,3,4}*2\n" +
                "{3,6,9}/3\n" +
                "{2,3,4}-5\n" +
                "4+{2,3,4}\n" +
                "{2,3,4}+{5,6,7}\n" +
                "{5,6,7}-{2,3,4}\n" +
                "end\n")
                .include("{4.0, 6.0, 8.0}")    //{2,3,4}*2
                .include("{1.0, 2.0, 3.0}")    //{3,6,9}/3
                .include("{-3.0, -2.0, -1.0}") //{2,3,4}-5
                .include("{6.0, 7.0, 8.0}")    //4+{2,3,4}
                .include("{7.0, 9.0, 11.0}")   //{2,3,4}+{5,6,7}
                .include("{3.0, 3.0, 3.0}")    //{5,6,7}-{2,3,4}
        ;
    }

    @Test(timeout = 1500)
    public void testTaskC__ConsoleRunner() throws Exception {
        run(    "{{1,2},{8,3}}-2\n" +
                "{{1,2},{8,3}}*{1,2}\n" +
                "{{1,2},{8,3}}*{{1,2},{8,3}}\n" +
                "{{1,2},{8,3}}+{{1,2},{8,3}}\n" +
                "end\n")
                .include("{{-1.0, 0.0}, {6.0, 1.0}}")   //{{1,2},{8,3}}-2
                .include("{5.0, 14.0}")                   //{{1,2},{8,3}}*{1,2}
                .include("{{17.0, 8.0}, {32.0, 25.0}}") //{{1,2},{8,3}} * {{1,2},{8,3}}
                .include("{{2.0, 4.0}, {16.0, 6.0}}")    //{{1,2},{8,3}}+{{1,2},{8,3}}
        ;

    }



    /*
    ===========================================================================================================
    НИЖЕ ВСПОМОГАТЕЛЬНЫЙ КОД ТЕСТОВ. НЕ МЕНЯЙТЕ В ЭТОМ ФАЙЛЕ НИЧЕГО.
    Но изучить как он работает - можно, это всегда будет полезно.
    ===========================================================================================================
     */

    private Class findClass(String SimpleName) {
        String full = this.getClass().getName();
        String dogPath = full.replace(this.getClass().getSimpleName(), SimpleName);
        try {
            return Class.forName(dogPath);
        } catch (ClassNotFoundException e) {
            fail("\nТест не пройден. Класс " + SimpleName + " не найден.");
        }
        return null;
    }

    public Method checkMethod(String className, String methodName, Class<?>... parameters) throws Exception {
        Class aClass = this.findClass(className);
        try {
            methodName = methodName.trim();
            Method m;
            if (methodName.startsWith("static")) {
                methodName = methodName.replace("static", "").trim();
                m = aClass.getDeclaredMethod(methodName, parameters);
                if ((m.getModifiers() & Modifier.STATIC) != Modifier.STATIC) {
                    fail("\nМетод " + m.getName() + " должен быть статическим");
                }
            } else
                m = aClass.getDeclaredMethod(methodName, parameters);
            m.setAccessible(true);
            return m;

        } catch (NoSuchMethodException e) {
            System.err.print("\nНе найден метод " + methodName + " либо у него неверная сигнатура");
            System.err.print("\nОжидаемый класс: " + className);
            System.err.print("\nОжидаемый метод: " + methodName);
            return null;
        }
    }

    private Method findMethod(Class<?> cl, String name, Class... param) {
        try {
            return cl.getDeclaredMethod(name, param);
        } catch (NoSuchMethodException e) {
            fail("\nТест не пройден. Метод " + cl.getName() + "." + name + " не найден");
        }
        return null;
    }

    private Object invoke(Method method, Object o, Object... value) {
        try {
            return method.invoke(o, value);
        } catch (Exception e) {
            System.out.println(e.toString());
            fail("\nНе удалось вызвать метод " + method.getName());
        }
        return null;
    }


    //метод находит и создает класс для тестирования
    //по имени вызывающего его метода, testTaskA1 будет работать с TaskA1
    private static Test_jd01_09 run(String in) {
        return run(in, true);
    }

    private static Test_jd01_09 run(String in, boolean runMain) {
        Throwable t = new Throwable();
        StackTraceElement trace[] = t.getStackTrace();
        StackTraceElement element;
        int i = 0;
        do {
            element = trace[i++];
        }
        while (!element.getMethodName().contains("test"));

        String[] path = element.getClassName().split("\\.");
        String nameTestMethod = element.getMethodName();
        String clName = nameTestMethod.replace("test", "");
        clName = clName.replaceFirst(".+__", "");
        clName = element.getClassName().replace(path[path.length - 1], clName);
        System.out.println("\n---------------------------------------------");
        System.out.println("Старт теста для " + clName + "\ninput:" + in);
        System.out.println("---------------------------------------------");
        return new Test_jd01_09(clName, in, runMain);
    }

    public Test_jd01_09() {
        //Конструктор тестов
    }

    //Конструктор тестов
    //    private Testing(String className) {
    //        this(className, "");
    //    }
    private String className;
    Class<?> aClass;

    //Основной конструктор тестов
    private Test_jd01_09(String className, String in, boolean runMain) {
        //this.className = className;
        aClass = null;
        try {
            aClass = Class.forName(className);
            this.className = className;

        } catch (ClassNotFoundException e) {
            fail("Не найден класс " + className);
        }
        reader = new StringReader(in); //заполнение ввода
        InputStream inputStream = new InputStream() {
            @Override
            public int read() throws IOException {
                return reader.read();
            }
        };
        System.setIn(inputStream);   //перехват ввода

        System.setOut(newOut); //перехват стандартного вывода

        if (runMain) //если нужно запускать, то запустим, иначе оставим только вывод
            try {
                Class[] argTypes = new Class[]{String[].class};
                Method main = aClass.getDeclaredMethod("main", argTypes);
                main.invoke(null, (Object) new String[]{});
                System.setOut(oldOut); //возврат вывода, нужен, только если был запуск
            } catch (Exception x) {
                x.printStackTrace();
            }
    }

    //проверка вывода
    private Test_jd01_09 is(String str) {
        assertTrue("Ожидается такой вывод:\n<---начало---->\n" + str + "<---конец--->",
                stringWriter.toString().equals(str));
        return this;
    }

    private Test_jd01_09 include(String str) {
        assertTrue("Строка не найдена: " + str + "\n", stringWriter.toString().contains(str));
        return this;
    }

    private Test_jd01_09 exclude(String str) {
        assertTrue("Лишние данные в выводе: " + str + "\n", !stringWriter.toString().contains(str));
        return this;
    }


    //переменные теста
    private StringWriter stringWriter = new StringWriter();
    private PrintStream oldOut = System.out;
    private StringReader reader;


    //поле для перехвата потока вывода
    private PrintStream newOut;

    {
        newOut = new PrintStream(new OutputStream() {
            private byte bytes[] = new byte[2];

            @Override
            public void write(int b) throws IOException {
                if (b < 0) { //ловим и собираем двухбайтовый UTF (первый код > 127, или в байте <0)
                    if (bytes[0] == 0) { //если это первый байт
                        bytes[0] = (byte) b; //то запомним его
                    } else {
                        bytes[1] = (byte) b; //иначе это второй байт
                        String s = new String(bytes); //соберем весь символ
                        stringWriter.append(s); //запомним вывод для теста
                        oldOut.append(s); //копию в обычный вывод
                        bytes[0] = 0; //забудем все.
                    }
                } else {
                    char c = (char) b; //ловим и собираем однобайтовый UTF
                    bytes[0] = 0;
                    if (c != '\r') {
                        stringWriter.write(c); //запомним вывод для теста
                    }
                    oldOut.write(c); //копию в обычный вывод
                }
            }
        });
    }
}
