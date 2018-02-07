package by.it.sendetskaya.jd02_06.calc;

public class Printer {
    private Logger logger;

    void print (String var) throws CalcException {
        if (var!=null) {
            System.out.println(var);
            logger=Logger.getInstance();
            logger.logWrite(var);
        }

        else
            throw new CalcException("Ошибка печати результата, результат= "+var);
    }

    void printVar () throws CalcException {

            System.out.println(VarsMap.map);
            logger=Logger.getInstance();
            logger.logWrite(VarsMap.map.toString());

         }
}
