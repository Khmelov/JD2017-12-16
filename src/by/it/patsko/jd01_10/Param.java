package by.it.patsko.jd01_10;

import java.lang.annotation.*;

/*
TaskA1.Создайте собственную аннотацию Param,
которая описывает параметры для некоторой процедуры тестирования произвольного методас сигнатурой (int a, int b),
помеченного такой аннотацией.Пример использования:
@Param(a=2, b=5)public double avg(int a, int b) { … }.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Param {
    int a();

    int b();
}
