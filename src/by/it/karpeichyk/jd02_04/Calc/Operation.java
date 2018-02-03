package by.it.karpeichyk.jd02_04.Calc;

/**
 * Created by user on 13.01.2018.
 */
public interface Operation {
    Var add(Var other) throws CalcExeption;
    Var mul(Var other)throws CalcExeption;
    Var div(Var other)throws CalcExeption;
    Var sub(Var other)throws CalcExeption;
}
