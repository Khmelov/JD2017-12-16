package by.it.sevashko.jd01_02;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.junit.Assert.*;

@SuppressWarnings("all")

//поставьте курсор на следующую строку и нажмите Ctrl+Shift+F10
public class Test_jd01_02 {

    @Test(timeout = 1500)
    public void testTaskA() throws Exception {
        System.out.println("\n\nПроверка на минимум и максимум");
        checkMethod("TaskA", "static step1", int[].class);
        run("-1 2 3 4 567 567 4 3 2 -1 4 4").include("-1 567");

        System.out.println("\n\nПроверка на вывод значений меньше среднего");
        checkMethod("TaskA", "static step2", int[].class);
        run("-1 22 33 44 567 567 44 33 22 -1 4 4")
                .include("-1").include("22").include("33").include("44");

        System.out.println("\n\nПроверка на индексы минимума");
        checkMethod("TaskA", "static step3", int[].class);
        run("-1 22 33 44 567 567 44 33 22 -1 4 4").include("9 0");
    }

    @Test(timeout = 1500)
    public void testTaskA1_MinMax__TaskA() throws Exception {
        Test_jd01_02 ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static step1", int[].class);
        m.invoke(null, new int[]{-1, 2, 3, 4, 567, 567, 4, 3, 2, -1, 4, 4});
        ok.include("").include("-1 567");
    }

    @Test(timeout = 1500)
    public void testTaskA2_Avg__TaskA() throws Exception {
        Test_jd01_02 ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static step2", int[].class);
        m.invoke(null, new int[]{-1, 22, 33, 44, 567, 567, 44, 33, 22, -1, 4, 4});
        ok.include("").include("-1")
                .include("1").include("2").include("3").include("4")
                .include("22").include("33").include("44").exclude("567");
    }

    @Test(timeout = 1500)
    public void testTaskA3_IndexMinMax__TaskA() throws Exception {
        Test_jd01_02 ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static step3", int[].class);
        m.invoke(null, new int[]{-1, 22, 33, 44, 567, 567, 44, 33, 22, -1, 4, 4});
        ok.include("").include("9 0");
    }

    @Test(timeout = 1500)
    public void testTaskB() throws Exception {
        System.out.println("\n\nПроверка на вывод матрицы 5 x 5");
        checkMethod("TaskB", "step1");
        run("0 1 2 3")
                .include("1  2  3  4  5").include("6  7  8  9")
                .include("11 12 13 14 15").include("16 17 18 19 20")
                .include("21 22 23 24 25");
        ;
        System.out.println("\n\nПроверка на ввод номера месяца");
        checkMethod("TaskB", "step2", int.class);
        run("0 2 3 4").include("нет такого месяца");
        run("1 2 3 4").include("январь");
        run("2 2 3 4").include("февраль");
        run("3 2 3 4").include("март");
        run("4 2 3 4").include("апрель");
        run("5 2 3 4").include("май");
        run("6 2 3 4").include("июнь");
        run("7 2 3 4").include("июль");
        run("8 2 3 4").include("август");
        run("9 2 3 4").include("сентябрь");
        run("10 2 3 4").include("октябрь");
        run("11 2 3 4").include("ноябрь");
        run("12 2 3 4").include("декабрь");
        run("13 2 3 4").include("нет такого месяца");

        System.out.println("\n\nПроверка на решение квадратного уравнения");
        checkMethod("TaskB", "step3", double.class, double.class, double.class);
        run("0 2 4 2").include("-1");
        run("0 2 4 0").include("0.0").include("-2.0");
        run("0 2 4 4").include("корней нет");
    }

    @Test(timeout = 1500)
    public void testTaskB1_Loop__TaskB() throws Exception {
        Test_jd01_02 ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static step1");
        m.invoke(null);
        ok.include("1  2  3  4  5").include("6  7  8  9")
                .include("11 12 13 14 15").include("16 17 18 19 20")
                .include("21 22 23 24 25");
    }

    @Test(timeout = 1500)
    public void testTaskB2_Switch__TaskB() throws Exception {
        Test_jd01_02 ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static step2", int.class);
        m.invoke(null, 0);
        ok.include("нет такого месяца");
        m.invoke(null, 1);
        ok.include("январь");
        m.invoke(null, 2);
        ok.include("февраль");
        m.invoke(null, 3);
        ok.include("март");
        m.invoke(null, 4);
        ok.include("апрель");
        m.invoke(null, 5);
        ok.include("май");
        m.invoke(null, 6);
        ok.include("июнь");
        m.invoke(null, 7);
        ok.include("июль");
        m.invoke(null, 8);
        ok.include("август");
        m.invoke(null, 9);
        ok.include("сентябрь");
        m.invoke(null, 10);
        ok.include("октябрь");
        m.invoke(null, 11);
        ok.include("ноябрь");
        m.invoke(null, 12);
        ok.include("декабрь");
        m.invoke(null, 13);
        ok.include("нет такого месяца");
    }


    @Test(timeout = 1500)
    public void testTaskB3_QEquation__TaskB() throws Exception {
        Test_jd01_02 ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static step3",
                double.class, double.class, double.class);
        m.invoke(null, 2, 4, 2);
        ok.include("-1");
        m.invoke(null, 2, 4, 0);
        ok.include("0").include("-2");
        m.invoke(null, 2, 4, 4);
        ok.include("корней нет");
    }

    @Test(timeout = 1500)
    public void testTaskC() throws Exception {
        System.out.println("\n\nПроверка на создание массива TaskC.step1");
        checkMethod("TaskC", "step1", int.class);
        run("3").include("-3").include("3");
        run("4").include("-4").include("4");
        Test_jd01_02 ok = run("5").include("-5").include("5");

        System.out.println("\nПроверка на сумму элементов TaskC.step2");
        checkMethod("TaskC", "step2", int[][].class);
        int[][] m4 = {{1, -2, -2, 6}, {-1, 2, -2, 2}, {-2, -2, -6, -2}, {1, 2, -2, 6}};
        Method m = ok.aClass.getDeclaredMethod("step2", m4.getClass());
        int sum = (int) ok.invoke(m, null, new Object[]{m4});
        assertEquals("Неверная сумма в step2", -6, sum);

        System.out.println("\nПроверка на удаление максимума TaskC.step3");
        checkMethod("TaskC", "step3", int[][].class);

        m = ok.aClass.getDeclaredMethod("step3", int[][].class);
        int[][] res = (int[][]) ok.invoke(m, null, new Object[]{m4});
        int[][] expectmas = {{-1, 2, -2}, {-2, -2, -6}};
        assertArrayEquals("Не найден ожидаемый массив {{-1,2,-2},{-2,-2,-6}}", expectmas, res);
    }

    @Test(timeout = 1500)
    public void testTaskC1_IndexMinMax__TaskC() throws Exception {
        Test_jd01_02 ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static step1", int.class);
        int[][] mas = (int[][]) m.invoke(null, 5);
        boolean min = false;
        boolean max = false;
        for (int[] row : mas)
            for (int i : row) {
                if (i == -5) min = true;
                if (i == 5) max = true;
            }
        if (!max || !min) {
            fail("В массиве нет максимума 5 или минимума -5");
        }

    }


    @Test(timeout = 1500)
    public void testTaskC2_Sum__TaskC() throws Exception {
        Test_jd01_02 ok = run("", false);
        int[][] m4 = {{1, -2, -2, 6}, {-1, 2, -2, 2}, {-2, -2, -6, -2}, {1, 2, -2, 6}};
        Method m = checkMethod(ok.aClass.getSimpleName(), "static step2", int[][].class);
        int sum = (int) ok.invoke(m, null, new Object[]{m4});
        assertEquals("Неверная сумма в step2", -6, sum);
    }

    @Test(timeout = 1500)
    public void testTaskC3_DeleteMax__TaskC() throws Exception {
        Test_jd01_02 ok = run("", false);
        int[][] m4 = {{1, -2, -2, 6}, {-1, 2, -2, 2}, {-2, -2, -6, -2}, {1, 2, -2, 6}};
        Method m = checkMethod(ok.aClass.getSimpleName(), "static step3", int[][].class);
        int[][] actualmas = (int[][]) ok.invoke(m, null, new Object[]{m4});
        int[][] expectmas = {{-1, 2, -2}, {-2, -2, -6}};
        for (int i = 0; i < actualmas.length; i++) {
            System.out.println("Проверка строки "+i);
            System.out.println("         Ожидается: "+ Arrays.toString(expectmas[i]));
            System.out.println("Из метода получено: "+ Arrays.toString(actualmas[i]));
            assertArrayEquals("Метод работает некорректно",expectmas[i],actualmas[i]);
        }
        System.out.println("Проверка завершена успешно!");
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
    private static Test_jd01_02 run(String in) {
        return run(in, true);
    }

    private static Test_jd01_02 run(String in, boolean runMain) {
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
        return new Test_jd01_02(clName, in, runMain);
    }

    public Test_jd01_02() {
        //Конструктор тестов
    }

    //Конструктор тестов
    //    private Testing(String className) {
    //        this(className, "");
    //    }
    private String className;
    Class<?> aClass;

    //Основной конструктор тестов
    private Test_jd01_02(String className, String in, boolean runMain) {
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
    private Test_jd01_02 is(String str) {
        assertTrue("Ожидается такой вывод:\n<---начало---->\n" + str + "<---конец--->",
                stringWriter.toString().equals(str));
        return this;
    }

    private Test_jd01_02 include(String str) {
        assertTrue("Строка не найдена: " + str + "\n", stringWriter.toString().contains(str));
        return this;
    }

    private Test_jd01_02 exclude(String str) {
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
