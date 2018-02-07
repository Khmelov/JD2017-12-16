package by.it.patsko.jd02_06.calc;

public class CalcException extends Exception {
    LoggerCalc logger;
    public CalcException() {
    }

    public CalcException(String message) {
        super(message);
        logger = LoggerCalc.getLogger();
        logger.logWrite(message);

        ConsoleRunner.reports[0].writeError(this);
        ConsoleRunner.reports[1].writeError(this);
    }

    public CalcException(String message, Throwable cause) {
        super(message, cause);
        logger = LoggerCalc.getLogger();
        logger.logWrite(message+" "+cause.toString());

        ConsoleRunner.reports[0].writeError(this);
        ConsoleRunner.reports[1].writeError(this);
    }

    public CalcException(Throwable cause) {
        super(cause);
        logger = LoggerCalc.getLogger();
        logger.logWrite(cause.toString());

        ConsoleRunner.reports[0].writeError(this);
        ConsoleRunner.reports[1].writeError(this);
    }
}
