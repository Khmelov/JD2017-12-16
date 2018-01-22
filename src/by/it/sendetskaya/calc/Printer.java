package by.it.sendetskaya.calc;

public class Printer {

    void print (Var var) throws CalcException {
        if (var!=null)
            System.out.println(var);
        else
            throw new CalcException("Ошибка печати результата, результат= "+var);
    }
}
