package by.it.viktorbrui.jd01_08.homeWork;

abstract class Books implements Edition {

    private boolean processStart;
    private boolean processEnd;
    private boolean processStop;
    private String nextSection;

    public void setNextSection (String nextSection){
        this.nextSection = nextSection;
    }
    public Books (String nextSection){
        processStart = true;
        processEnd = false;
        processStop = false;
        this.nextSection = nextSection;
    }
    public Books(){
        processStart=false;
        processStop=false;
        processEnd=false;
    }
    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("--------------------------\n");
        sb.append(processStart?"Printer on\n":"Printer off\n");
        sb.append(processEnd?"Print start: "+nextSection+"\n":"Print off\n");
        sb.append(processStop?"Printer Stop\n":"");
        sb.append("--------------------------\n");
        return sb.toString();
    }

    @Override
    public void processStart() {
        processStart=true;
    }

    @Override
    public void processEnd() {
        processStart=false;
    }

    public boolean inProcess(){
        if (!processEnd || processStop) {
            processEnd=true;
            processStop=false;
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean endProcess() {
        if (processEnd){
            processEnd=false;
            return true;
        }
        return false;
    }

    @Override
    public boolean stopProcess() {
        processStop=!processStop;
        return processStop;
    }
}
