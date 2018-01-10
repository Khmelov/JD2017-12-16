package by.it.viktorbrui.jd01_08.homeWork;

public class ReferanceAndEnciklopedia extends Books{

    @Override
    public boolean inProcess(String print) {
        setNextSection(print);
        boolean result=inProcess();
        if (result)
            System.out.println("Print in process:\n"+this);
        return result;
    }


    @Override
    public boolean endProcess() {
        boolean result=super.endProcess();
        if (result)
            System.out.println("Print end:\n"+this);
        return result;
    }
}
