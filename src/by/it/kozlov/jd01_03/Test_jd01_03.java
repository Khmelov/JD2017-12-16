package by.it.kozlov.jd01_03;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.junit.Assert.*;

@SuppressWarnings("all")

//поставьте курсор на следующую строку и нажмите Ctrl+Shift+F10
public class Test_jd01_03 {

    @Test(timeout = 1500)
    public void testTaskA1__InOut() throws Exception {
        Test_jd01_03 ok = run("", false);
        checkMethod(ok.aClass.getSimpleName(), "static getArray", String.class);
        double[] expArr = {0.1, 0.2, -0.2, -0.1};
        Method m = ok.aClass.getDeclaredMethod("getArray", String.class);
        System.out.println("Проверка ввода для массива вида:");
        System.out.println("0.1 0.2 -0.2 -0.1");
        double[] arr = (double[]) ok.invoke(m, null, new Object[]{"0.1 0.2 -0.2 -0.1"});
        assertArrayEquals("Неверно работает ввод", expArr, arr, 1e-9);
        System.out.println("Проверка ввода для массива завершена успешно");
    }

    @Test(timeout = 1500)
    public void testTaskA2_printSimple__InOut() throws Exception {
        Test_jd01_03 ok = run("", false);
        checkMethod(ok.aClass.getSimpleName(), "static printArray", double[].class);
        Method m = ok.aClass.getDeclaredMethod("printArray", double[].class);
        System.out.println("Проверка вывода для массива:");
        double[] arr = {1, 2, 3, 4};
        ok.invoke(m, null, new Object[]{arr});
        for (double a : arr) {
            //перевод в Integer т.к. заранее неизвестно с printf или прямо будет сделан вывод
            ok.include(Integer.toString((int) a));
        }
        System.out.println("Проверка вывода для массива завершена успешно");
    }

    @Test(timeout = 1500)
    public void testTaskA3_printWithNameAndCol__InOut() throws Exception {
        Test_jd01_03 ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static printArray", double[].class, String.class, int.class);
        System.out.println("Проверка вывода для массива:");
        double[] arr = {0.1, 0.2, -0.2, -0.1, 3, 4, 5, 6, 7, 8, 9, 0, 1};
        ok.invoke(m, null, arr, "Massiv", 2);
        System.out.println("\n\nFind out with printf for:");
        for (double a : arr) {
            //перевод в Integer т.к. заранее неизвестно с printf или прямо будет сделан вывод
            String sf = String.format("%.1f", a);
            System.out.print(sf + " | ");
            ok.include(sf);
        }
        System.out.println("\nCheck printf ok");
        ok.include("\n").include("Massiv");
        System.out.println("Проверка вывода для массива завершена успешно");
        //тут можно проверку на число колонок сделать, но это не факт, что будет просто
    }

    @Test(timeout = 1500)
    public void testTaskB1_findMin__Helper() throws Exception {
        Test_jd01_03 ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static findMin", double[].class);
        double[] arr = {0.1, 0.2, -0.2, -0.1, 3, 4, 5, 6, 7, 8, 9, 0, 1};
        double min = (double) ok.invoke(m, null, arr);
        Arrays.sort(arr);
        assertEquals("Минимум найден неверно", arr[0], min, 1e-10);
    }

    @Test(timeout = 1500)
    public void testTaskB2_findMax__Helper() throws Exception {
        Test_jd01_03 ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static findMax", double[].class);
        double[] arr = {0.1, 0.2, -0.2, -0.1, 3, 4, 5, 6, 7, 8, 9, 0, 1};
        double min = (double) ok.invoke(m, null, arr);
        Arrays.sort(arr);
        assertEquals("Максимум найден неверно", arr[arr.length - 1], min, 1e-10);
    }

    @Test(timeout = 1500)
    public void testTaskB3_sort__Helper() throws Exception {
        Test_jd01_03 ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static sort", double[].class);
        double[] arr = {0.1, 0.2, -0.2, -0.1, 3, 4, 5, 6, 7, 8, 9, 0, 1};
        double[] sorted = {0.1, 0.2, -0.2, -0.1, 3, 4, 5, 6, 7, 8, 9, 0, 1};
        System.out.println("Исходный  массив:" + Arrays.toString(arr));
        Arrays.sort(sorted);
        System.out.println("Ожидается массив:" + Arrays.toString(sorted));
        ok.invoke(m, null, arr);
        System.out.println("  Получен массив:" + Arrays.toString(arr));
        assertArrayEquals("Неверно работает сортировка", sorted, arr, 1e-9);
        System.out.println("OK. Массив отсортирован");
    }

    @Test(timeout = 1500)
    public void testTaskC1_mulMatrixAndVector__Helper() throws Exception {
        Test_jd01_03 ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static mul", double[][].class, double[].class);
        System.out.println("Проверим произведение матрицы и вектора");
        double[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };

        double[] vector = {1, 2, 3};
        double[] res = (double[]) ok.invoke(m, null, matrix, vector);
        double[] exp = {
                1 * 1 + 2 * 2 + 3 * 3,
                4 * 1 + 5 * 2 + 6 * 3
        };
        System.out.println("{{1,2,3},{4,5,6}}*{1,2,3}={14,32}");
        System.out.println("Ожидается массив " + Arrays.toString(exp));
        assertArrayEquals("Произведение найдено неверно", exp, res, 1e-10);
        System.out.println("Проверка завершена успешно.");
    }


    @Test(timeout = 1500)
    public void testTaskC2_mulMatrixAndMatrix__Helper() throws Exception {
        Test_jd01_03 ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static mul", double[][].class, double[][].class);
        System.out.println("Проверим произведение матрицы и матрицы");
        double[][] left = {
                {1, 2, 3},
                {4, 5, 6}
        };

        double[][] right = {
                {1, 2},
                {3, 4},
                {5, 6}
        };

        double[][] res = (double[][]) ok.invoke(m, null, left, right);
        double[][] exp = {
                {22, 28},
                {49, 64}
        };
        System.out.println("{{1,2,3},{4,5,6}}*{{1,2},{3,4},{5,6}}={{22,28},{49,64}}");
        for (int i = 0; i < exp.length; i++) {
            System.out.println("Ожидается:  " + Arrays.toString(exp[i]));
            System.out.println("Рассчитано: " + Arrays.toString(res[i]));
            assertArrayEquals("Произведение найдено неверно", exp[i], res[i], 1e-10);
        }
        System.out.println("\nПроверка завершена успешно.");
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
            }
            else
                m=aClass.getDeclaredMethod(methodName, parameters);
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
    private static Test_jd01_03 run(String in) {
        return run(in, true);
    }

    private static Test_jd01_03 run(String in, boolean runMain) {
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
        clName=clName.replaceFirst(".+__","");
        clName = element.getClassName().replace(path[path.length - 1], clName);
        System.out.println("\n---------------------------------------------");
        System.out.println("Старт теста для " + clName + "\ninput:" + in);
        System.out.println("---------------------------------------------");
        return new Test_jd01_03(clName, in, runMain);
    }

    public Test_jd01_03() {
        //Конструктор тестов
    }

    //Конструктор тестов
    //    private Testing(String className) {
    //        this(className, "");
    //    }
    private String className;
    Class<?> aClass;

    //Основной конструктор тестов
    private Test_jd01_03(String className, String in, boolean runMain) {
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
    private Test_jd01_03 is(String str) {
        assertTrue("Ожидается такой вывод:\n<---начало---->\n" + str + "<---конец--->",
                stringWriter.toString().equals(str));
        return this;
    }

    private Test_jd01_03 include(String str) {
        assertTrue("Строка не найдена: " + str + "\n", stringWriter.toString().contains(str));
        return this;
    }

    private Test_jd01_03 exclude(String str) {
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
