package by.it.patsko.jd02_06.calc;

public class Report {
    private String header = "";
    private String startSession = "";
    private String endSession = "";
    private String operations = "";
    private String errors = "";

    void setHeader(String header) {
        this.header += header;
    }

    void setStartSession(String startSession) {
        this.startSession += startSession+"\n";
    }

    void setEndSession(String endSession) {
        this.endSession += endSession+"\n";
    }

    void setOperations(String operation) {
        this.operations += operation;
    }

    void setErrors(String error) {
        this.errors += error+"\n";
    }

    @Override
    public String toString() {
        return  "\n==================== " + header + " ====================\n" +
                "\nсеанс начался: " + startSession +
                "\nсеанс закончился: " + endSession +
                "\nза время сеанса производились следующие операции:\n" + operations +
                "\nза время сеанса происходили следующие ошибки:\n" + errors
//                + "========================================================"
                ;
    }
}
