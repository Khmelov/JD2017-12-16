package by.it.patsko.jd01_10;

/*
TaskA2.Создайте класс Bean которыйсодержитдвастатическихи дванестатическихметода.
Имена sum max min avg с сигнатурой (int a, int b), какие именно из них статические выберите произвольно.
Методы должны вычислять для своих параметров a и b сумму, максимум, минимум и среднее и возвращать результат как double.
Три из этих методов должны быть помечены ранее созданной аннотациейс разными значениями a и b
 */
class Bean {
    @Param(a = 3, b = 4)
    static double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 3, b = 4)
    double max(int a, int b) {
        return a > b ? a : b;
    }

    double min(int a, int b) {
        return a < b ? a : b;
    }

    @Param(a = 3, b = 4)
    static double avg(int a, int b) {
        return (a + b) / 2.0;
    }
}
