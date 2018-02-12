package by.it.sevashko.jd02_06;

class Patterns {

    // регулярки, приведены для сокращения времени.
    // будет полезно составить свои варианты
    static final String SCALAR="((-?)([0-9.])+)";                       //числа
    static final String VECTOR="\\{((-?([0-9.])+),?\\s*)+}";                //вектора
    static final String MATRIX="\\{((\\{((-?([0-9.])+),?\\s*)+}),?\\s*)+}";     //матрицы

    //этот паттерн весьма несовершенный, т.к. операции вида
    //3.0 * -4.1 работать не смогут. Проблему решим позднее.
    static final String OPERATION="(?<=[^{,*=/+-])([-+*/=])";                             //операция
}
