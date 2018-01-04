package by.it.fyodorov.jd01_07;


import org.junit.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.Assert.*;

@SuppressWarnings("all")

//поставьте курсор на следующую строку и нажмите Ctrl+Shift+F10
public class jd01_07 {

    @Test(timeout = 1500)
    public void testTaskA1_double__Scalar() throws Exception {
        jd01_07 ok=run("",false);
        assertEquals("У вас неверное наследование", "AbstractVar", ok.aClass.getSuperclass().getSimpleName());

        Constructor c=ok.aClass.getDeclaredConstructor(double.class);
        System.out.println("Создание переменной типа Scalar на основе числа 0.12345");
        Object scalar=c.newInstance(0.12345);
        System.out.println("было выполнено успешно. \nТестирование вывода значения 0.12345 через метод toString()");
        System.out.flush();
        assertEquals("Не было получено ожидаемое значение 0.12345", scalar.toString(), "0.12345");
        System.out.println("выполнено успешно. Scalar="+scalar);
    }

    @Test(timeout = 1500)
    public void testTaskA2_Scalar__Scalar() throws Exception {
        jd01_07 ok=run("",false);
        assertEquals("У вас неверное наследование", "AbstractVar", ok.aClass.getSuperclass().getSimpleName());

        Constructor c=ok.aClass.getDeclaredConstructor(double.class);
        Object scalar=c.newInstance(0.12345);
        c=ok.aClass.getDeclaredConstructor(ok.aClass);
        System.out.println("Создание переменной типа Scalar на основе объекта Scalar(0.12345)");
        scalar=c.newInstance(scalar);
        System.out.println("было выполнено успешно. \nТестирование вывода значения 0.12345 через метод toString()");
        System.out.flush();
        assertEquals("Не было получено ожидаемое значение 0.12345", scalar.toString(), "0.12345");
        System.out.println("выполнено успешно. Scalar="+scalar);
    }

    @Test(timeout = 1500)
    public void testTaskA3_String__Scalar() throws Exception {
        jd01_07 ok=run("",false);
        assertEquals("У вас неверное наследование", "AbstractVar", ok.aClass.getSuperclass().getSimpleName());

        Constructor c=ok.aClass.getDeclaredConstructor(String.class);
        System.out.println("Создание переменной типа Scalar на основе строки 0.12345");
        Object scalar=c.newInstance("0.12345");
        System.out.println("было выполнено успешно. \nТестирование вывода значения 0.12345 через метод toString()");
        System.out.flush();
        assertEquals("Не было получено ожидаемое значение 0.12345", scalar.toString(), "0.12345");
        System.out.println("выполнено успешно. Scalar="+scalar);
    }



    @Test(timeout = 1500)
    public void testTaskB1_double__Vector() throws Exception {
        jd01_07 ok=run("",false);
        assertEquals("У вас неверное наследование", "AbstractVar", ok.aClass.getSuperclass().getSimpleName());

        Constructor c=ok.aClass.getDeclaredConstructor(double[].class);
        System.out.println("Создание переменной типа Vector на основе массива {1,2,4}");
        Object vector=c.newInstance(new double[]{1,2,4});
        System.out.println("было выполнено успешно. \nТестирование вывода значения {1,2,4} через метод toString()");
        System.out.flush();
        assertEquals("Не было получено ожидаемое значение {1.0, 2.0, 4.0}", vector.toString(), "{1.0, 2.0, 4.0}");
        System.out.println("выполнено успешно. Vector="+vector);
    }

    @Test(timeout = 1500)
    public void testTaskB2_Vector__Vector() throws Exception {
        jd01_07 ok=run("",false);
        assertEquals("У вас неверное наследование", "AbstractVar", ok.aClass.getSuperclass().getSimpleName());

        Constructor c=ok.aClass.getDeclaredConstructor(double[].class);
        Object vector=c.newInstance(new double[]{1,2,4});
        c=ok.aClass.getDeclaredConstructor(ok.aClass);
        System.out.println("Создание переменной типа Vector на основе объекта Vector({1,2,4})");
        vector=c.newInstance(vector);
        System.out.println("было выполнено успешно. \nТестирование вывода значения {1,2,4} через метод toString()");
        System.out.flush();
        assertEquals("Не было получено ожидаемое значение {1.0, 2.0, 4.0}", vector.toString(), "{1.0, 2.0, 4.0}");
        System.out.println("выполнено успешно. Vector="+vector);
    }

    @Test(timeout = 1500)
    public void testTaskB3_String__Vector() throws Exception {
        jd01_07 ok=run("",false);
        assertEquals("У вас неверное наследование", "AbstractVar", ok.aClass.getSuperclass().getSimpleName());

        Constructor c=ok.aClass.getDeclaredConstructor(String.class);
        System.out.println("Создание переменной типа Vector на основе строки {1,2,4}");
        Object vector=c.newInstance("{1,2,4}");
        System.out.println("было выполнено успешно. \nТестирование вывода значения {1,2,4} через метод toString()");
        System.out.flush();
        assertEquals("Не было получено ожидаемое значение {1.0, 2.0, 4.0}", vector.toString(), "{1.0, 2.0, 4.0}");
        System.out.println("выполнено успешно. Vector="+vector);
    }


    @Test(timeout = 1500)
    public void testTaskC1_double__Matrix() throws Exception {
        jd01_07 ok=run("",false);
        assertEquals("У вас неверное наследование", "AbstractVar", ok.aClass.getSuperclass().getSimpleName());

        Constructor c=ok.aClass.getDeclaredConstructor(double[][].class);
        System.out.println("Создание переменной типа Matrix на основе массива {{1,2},{3,4}}");
        Object matrix=c.newInstance(new Object[]{new double[][]{{1,2},{3,4}}});
        System.out.println("было выполнено успешно. \nТестирование вывода значения {{1,2},{3,4}} через метод toString()");
        System.out.flush();
        assertEquals("Не было получено ожидаемое значение {{1.0, 2.0}, {3.0, 4.0}}", matrix.toString().replaceAll(" ",""), "{{1.0,2.0},{3.0,4.0}}");
        System.out.println("выполнено успешно. Matrix="+matrix);
    }

    @Test(timeout = 1500)
    public void testTaskC2_Matrix__Matrix() throws Exception {
        jd01_07 ok=run("",false);
        assertEquals("У вас неверное наследование", "AbstractVar", ok.aClass.getSuperclass().getSimpleName());

        Constructor c=ok.aClass.getDeclaredConstructor(double[][].class);
        Object matrix=c.newInstance(new Object[]{new double[][]{{1,2},{3,4}}});
        c=ok.aClass.getDeclaredConstructor(ok.aClass);
        System.out.println("Создание переменной типа Matrix на основе объекта Matrix({{1,2},{3,4}})");
        matrix=c.newInstance(matrix);
        System.out.println("было выполнено успешно. \nТестирование вывода значения {{1,2},{3,4}} через метод toString()");
        System.out.flush();
        assertEquals("Не было получено ожидаемое значение {{1.0, 2.0}, {3.0, 4.0}}", matrix.toString().replaceAll(" ",""), "{{1.0,2.0},{3.0,4.0}}");
        System.out.println("выполнено успешно. Matrix="+matrix);
    }

    @Test(timeout = 1500)
    public void testTaskC3_String__Matrix() throws Exception {
        jd01_07 ok=run("",false);
        assertEquals("У вас неверное наследование", "AbstractVar", ok.aClass.getSuperclass().getSimpleName());

        Constructor c=ok.aClass.getDeclaredConstructor(String.class);
        System.out.println("Создание переменной типа Matrix на основе строки {{1,2},{3,4}}");
        Object matrix=c.newInstance("{{1,2},{3,4}}");
        System.out.println("было выполнено успешно. \nТестирование вывода значения {{1,2},{3,4}} через метод toString()");
        System.out.flush();
        assertEquals("Не было получено ожидаемое значение {{1.0, 2.0}, {3.0, 4.0}}", matrix.toString().replaceAll(" ",""), "{{1.0,2.0},{3.0,4.0}}");
        System.out.println("выполнено успешно. Matrix="+matrix);
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
    private static jd01_07 run(String in) {
        return run(in, true);
    }

    private static jd01_07 run(String in, boolean runMain) {
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
        return new jd01_07(clName, in, runMain);
    }

    public jd01_07() {
        //Конструктор тестов
    }

    //Конструктор тестов
    //    private Testing(String className) {
    //        this(className, "");
    //    }
    private String className;
    Class<?> aClass;

    //Основной конструктор тестов
    private jd01_07(String className, String in, boolean runMain) {
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
    private jd01_07 is(String str) {
        assertTrue("Ожидается такой вывод:\n<---начало---->\n" + str + "<---конец--->",
                stringWriter.toString().equals(str));
        return this;
    }

    private jd01_07 include(String str) {
        assertTrue("Строка не найдена: " + str + "\n", stringWriter.toString().contains(str));
        return this;
    }

    private jd01_07 exclude(String str) {
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
