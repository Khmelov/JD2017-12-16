package by.it.sendetskaya.jd02_06.calc;

public class CalcException extends Exception{

    private Logger logger;
    public CalcException() {
    }

    public CalcException(String message) {
        super(message);
        logger=Logger.getInstance();
        logger.logWrite(message);
    }

    public CalcException(String message, Throwable cause) {
        super(message, cause);
        logger=Logger.getInstance();
        logger.logWrite(message+", "+cause.toString());
    }

    public CalcException(Throwable cause) {
        super(cause);
        logger=Logger.getInstance();
        logger.logWrite(cause.toString());
    }
}
