package by.it.viktorbrui.jd01_08.homeWork;

public class PrintProcess {
    public static void main(String[] args) {
        Edition print =new ReferanceAndEnciklopedia();
        System.out.println(print);
        print.processStart();
        System.out.println(print);
        print.inProcess("print print print");
        System.out.println(print);
        print.stopProcess();
        System.out.println(print);
        print.endProcess();
        System.out.println(print);
        print.processEnd();
        
    }
}
