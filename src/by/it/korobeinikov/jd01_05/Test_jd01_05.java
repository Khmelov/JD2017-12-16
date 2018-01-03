package by.it.korobeinikov.jd01_05;


import org.junit.Test;

import java.io.*;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@SuppressWarnings("all")

//поставьте курсор на следующую строку и нажмите Ctrl+Shift+F10
public class Test_jd01_05 {

    @Test(timeout = 1500)
    public void testTaskA1_Task1__Main() throws Exception {
        System.out.println("Ожидается -11392.451698930832");
        run("").include("4516");
    }

    @Test(timeout = 1500)
    public void testTaskA2_Task2__Main() throws Exception {
        System.out.println("Ожидается -3.106533964444678");
        run("").include("10653");
    }

    @Test(timeout = 1500)
    public void testTaskA3_Task3__Main() throws Exception {
        System.out.println("Ожидается:\n" +
                "При a= -5,00 f=17,2500\n" +
                "При a= -1,25 f=4,31250\n" +
                "При a=  2,50 f=1,37217e+13\n" +
                "При a=  6,25 f=6,97461e+32\n" +
                "При a= 10,00 f=3,54513e+52\n");
        run("").include("3125");
    }

    @Test(timeout = 1500)
    public void testTaskB1_Task4__Main() throws Exception {
        System.out.println("Ожидается:\n" +
                "При a=0,00 Сумма y = 6,275648e+00\n" +
                "При a=0,20 Сумма y = 9,130287e+00\n" +
                "При a=0,40 Сумма y = 1,334309e+01\n" +
                "При a=0,60 Сумма y = 1,956022e+01\n" +
                "При a=0,80 Сумма y = 2,873531e+01\n" +
                "При a=1,00 Сумма y = 4,227565e+01\n" +
                "При a=1,20 Сумма y = 6,225812e+01\n" +
                "При a=1,40 Сумма y = 9,174772e+01\n" +
                "При a=1,60 Сумма y = 1,352677e+02\n" +
                "При a=1,80 Сумма y = 1,994933e+02\n" +
                "При a=2,00 Сумма y = 2,942756e+02\n");
        run("").include("2756");
    }

    @Test(timeout = 1500)
    public void testTaskB2_Task5__Main() throws Exception {
        System.out.println("Ожидается:\n" +
                "При x/2=-2,75 вычисления не определены\n" +
                "При x/2=-2,50 вычисления не определены\n" +
                "При x/2=-2,25 вычисления не определены\n" +
                "При x/2=-2,00 вычисления не определены\n" +
                "При x/2=-1,75 a = 3,854062e-01\n" +
                "При x/2=-1,50 a = 4,986025e-01\n" +
                "При x/2=-1,25 a = 4,324595e-01\n" +
                "При x/2=-1,00 a = 2,973660e-01\n" +
                "При x/2=-0,75 a = 3,246582e-01\n" +
                "При x/2=-0,50 a = 5,159139e-01\n" +
                "При x/2=-0,25 a = 5,692466e-01\n" +
                "При x/2=0,00 a = 5,728716e-01\n" +
                "При x/2=0,25 вычисления не определены\n" +
                "При x/2=0,50 вычисления не определены\n" +
                "При x/2=0,75 вычисления не определены");
        run("").include("8540");
    }

    @Test(timeout = 1500)
    public void testTaskC1_Task6__Main() throws Exception {
        System.out.println("Ожидается\n" +
                "Массив A[]\n" +
                "A[ 0 ] = 3,20458    A[ 1 ] = 3,24985    A[ 2 ] = 3,29494    A[ 3 ] = 3,33986    A[ 4 ] = 3,38461    \n" +
                "A[ 5 ] = 3,42918    A[ 6 ] = 3,47356    A[ 7 ] = 3,51777    A[ 8 ] = 3,56179    A[ 9 ] = 3,60564    \n" +
                "A[ 10] = 3,64930    A[ 11] = 3,69278    A[ 12] = 3,73608    A[ 13] = 3,77921    A[ 14] = 3,82215    \n" +
                "A[ 15] = 3,86492    A[ 16] = 3,90751    A[ 17] = 3,94993    A[ 18] = 3,99217    A[ 19] = 4,03425    \n" +
                "A[ 20] = 4,07615    A[ 21] = 4,11788    A[ 22] = 4,15945    A[ 23] = 4,20085    A[ 24] = 4,24209    \n" +
                "A[ 25] = 4,28316    A[ 26] = 4,32408    A[ 27] = 4,36483    \n" +
                "\n" +
                "Массив B[] из элементов массива A > 3.5\n" +
                "B[ 0 ] = 3,51777    B[ 1 ] = 3,56179    B[ 2 ] = 3,60564    B[ 3 ] = 3,64930    B[ 4 ] = 3,69278    \n" +
                "B[ 5 ] = 3,73608    B[ 6 ] = 3,77921    B[ 7 ] = 3,82215    B[ 8 ] = 3,86492    B[ 9 ] = 3,90751    \n" +
                "B[ 10] = 3,94993    B[ 11] = 3,99217    B[ 12] = 4,03425    B[ 13] = 4,07615    B[ 14] = 4,11788    \n" +
                "B[ 15] = 4,15945    B[ 16] = 4,20085    B[ 17] = 4,24209    B[ 18] = 4,28316    B[ 19] = 4,32408    \n" +
                "B[ 20] = 4,36483 ");
        run("").include("2045");
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
    private static Test_jd01_05 run(String in) {
        return run(in, true);
    }

    private static Test_jd01_05 run(String in, boolean runMain) {
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
        return new Test_jd01_05(clName, in, runMain);
    }

    public Test_jd01_05() {
        //Конструктор тестов
    }

    //Конструктор тестов
    //    private Testing(String className) {
    //        this(className, "");
    //    }
    private String className;
    Class<?> aClass;

    //Основной конструктор тестов
    private Test_jd01_05(String className, String in, boolean runMain) {
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
    private Test_jd01_05 is(String str) {
        assertTrue("Ожидается такой вывод:\n<---начало---->\n" + str + "<---конец--->",
                stringWriter.toString().equals(str));
        return this;
    }

    private Test_jd01_05 include(String str) {
        assertTrue("Строка не найдена: " + str + "\n", stringWriter.toString().contains(str));
        return this;
    }

    private Test_jd01_05 exclude(String str) {
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
