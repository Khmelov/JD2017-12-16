package by.it.sendetskaya.calcV2;

public class Printer {

    void print (Var var) throws CalcException {
        if (var!=null)
            System.out.println(var);
        else
            throw new CalcException("Ошибка печати результата, результат= "+var);
    }
}
