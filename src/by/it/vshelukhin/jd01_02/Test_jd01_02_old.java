package by.it.vshelukhin.jd01_02;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

@SuppressWarnings("all")

//поставьте курсор на следующую строку и нажмите Ctrl+Shift+F10
public class Test_jd01_02_old {


    @Test(timeout = 1500)
    public void testTaskA() throws Exception {
        System.out.println("\n\nПроверка на минимум и максимум");
        checkMethod("TaskA","step1",int[].class);
        run("-1 2 3 4 567 567 4 3 2 -1 4 4").include("-1 567");

        System.out.println("\n\nПроверка на вывод значений меньше среднего");
        checkMethod("TaskA","step2",int[].class);
        run("-1 22 33 44 567 567 44 33 22 -1 4 4")
                .include("-1").include("22").include("33").include("44");

        System.out.println("\n\nПроверка на индексы минимума");
        checkMethod("TaskA","step3",int[].class);
        run("-1 22 33 44 567 567 44 33 22 -1 4 4").include("9 0");
    }

    @Test(timeout = 1500)
    public void testTaskB() throws Exception {
        System.out.println("\n\nПроверка на вывод матрицы 5 x 5");
        checkMethod("TaskB","step1");
        run("0 1 2 3")
                .include("1  2  3  4  5").include("6  7  8  9")
                .include("11 12 13 14 15").include("16 17 18 19 20")
                .include("21 22 23 24 25");
        ;
        System.out.println("\n\nПроверка на ввод номера месяца");
        checkMethod("TaskB","step2", int.class);
        run("0 2 3 4").include("нет такого месяца");
        run("1 2 3 4").include("январь");
//        run("2 2 3 4").include("февраль");
//        run("3 2 3 4").include("март");
//        run("4 2 3 4").include("апрель");
//        run("5 2 3 4").include("май");
//        run("6 2 3 4").include("июнь");
//        run("7 2 3 4").include("июль");
//        run("8 2 3 4").include("август");
//        run("9 2 3 4").include("сентябрь");
//        run("10 2 3 4").include("октябрь");
//        run("11 2 3 4").include("ноябрь");
        run("12 2 3 4").include("декабрь");
        run("13 2 3 4").include("нет такого месяца");

        System.out.println("\n\nПроверка на решение квадратного уравнения");
        checkMethod("TaskB","step3", double.class, double.class, double.class);
        run("0 2 4 2").include("-1");
        run("0 2 4 0").include("0.0").include("-2.0");
        run("0 2 4 4").include("корней нет");
    }

    @Test(timeout = 1500)
    public void testTaskC() throws Exception {
        System.out.println("\n\nПроверка на создание массива TaskC.step1");
        checkMethod("TaskC","step1",int.class);
        run("3").include("-3").include("3");
        run("4").include("-4").include("4");
        Test_jd01_02_old ok=run("5").include("-5").include("5");

        System.out.println("\nПроверка на сумму элементов TaskC.step2");
        checkMethod("TaskC","step2",int[][].class);
        int[][] m4={{1,-2,-2,6},{-1,2,-2,2},{-2,-2,-6,-2},{1,2,-2,6}};
        Method m=ok.aClass.getDeclaredMethod("step2", m4.getClass());
        int sum=(int)ok.invoke(m,null,new Object[]{m4});
        assertEquals("Неверная сумма в step2",-6,sum);

        System.out.println("\nПроверка на удаление максимума TaskC.step3");
        checkMethod("TaskC","step3",int[][].class);

        m=ok.aClass.getDeclaredMethod("step3",int[][].class);
        int[][] res=(int[][])ok.invoke(m,null, new Object[]{m4});
        int[][] expectmas={{-1,2,-2},{-2,-2,-6}};
        assertArrayEquals("Не найден ожидаемый массив {{-1,2,-2},{-2,-2,-6}}",expectmas,res);
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

    public Method checkMethod(String className, String methodName, Class<?> ... parameters) throws Exception {
        Class aClass=this.findClass(className);
        try {
            return aClass.getDeclaredMethod(methodName, parameters);
        } catch (NoSuchMethodException e) {
            System.err.print("\nНе найден метод "+methodName+" либо у него неверная сигнатура");
            System.err.print("\nОжидаемый класс: "+className);
            System.err.print("\nОжидаемый метод: "+methodName);
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
    private static Test_jd01_02_old run(String in) {
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
        clName = element.getClassName().replace(path[path.length - 1], clName);
        System.out.println("\n---------------------------------------------");
        System.out.println("Старт теста для " + clName + "\ninput:" + in);
        System.out.println("---------------------------------------------");
        return new Test_jd01_02_old(clName, in);
    }

    public Test_jd01_02_old() {
        //Конструктор тестов
    }

    //Конструктор тестов
    //    private Testing(String className) {
    //        this(className, "");
    //    }
    private String className;
    Class<?> aClass;
    //Основной конструктор тестов
    private Test_jd01_02_old(String className, String in) {
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
        try {
            Class[] argTypes = new Class[]{String[].class};
            Method main = aClass.getDeclaredMethod("main", argTypes);
            main.invoke(null, (Object) new String[]{});

        } catch (Exception x) {
            x.printStackTrace();
        }
        System.setOut(oldOut); //возврат вывода
    }

    //проверка вывода
    private Test_jd01_02_old is(String str) {
        assertTrue("Ожидается такой вывод:\n<---начало---->\n" + str + "<---конец--->",
                stringWriter.toString().equals(str));
        return this;
    }

    private Test_jd01_02_old include(String str) {
        assertTrue("Строка не найдена: " + str + "\n", stringWriter.toString().contains(str));
        return this;
    }

    private Test_jd01_02_old exclude(String str) {
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
