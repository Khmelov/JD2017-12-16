package by.it.patsko.jd01_10;

import java.lang.reflect.Method;

/*
TaskC1.
Создайте класс BeanTester который в методе main создает экземпляр класса Bean (оператор new Bean() для этого использовать нельзя!),
а затем находит и запускает его методы, помеченные созданной аннотацией с указанными в ней параметрами a и b.
После каждого вызова invoke на консоль выводится имя найденного метода и результат запуска.
 */
class BeanTester {
    public static void main(String[] args) {
        Class structBean = Bean.class;
        Method[] methods = structBean.getDeclaredMethods();
        Object o ;
        try {
            for (Method method : methods) {
                if (method.isAnnotationPresent(Param.class)) {
//                    o = structBean.newInstance();
                    o = structBean.getDeclaredConstructor().newInstance();
                    Param anno = method.getAnnotation(Param.class);
                    System.out.println("Результат выполнения метода " + method.getName() + ": "
                            + method.invoke(o,anno.a(),anno.b()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}