package by.it.viktorbrui.jd01_08;

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
        sb.append(processStart?"process start on\n":"process end off\n");
        sb.append(processEnd?"Processed "+nextSection+"\n":"Process switch\n");
        sb.append(processStop?"Stop on\n":"");
        sb.append("--------------------------\n");
        return sb.toString();
    }

    @Override
    public void ProcessStart() {
        processStart=true;
    }

    @Override
    public void ProcessEnd() {
        processStart=false;
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
