package by.it.akhmelev.jd01_08.classwork;

public class Runner {
    public static void main(String[] args) {
        Multimedia pleer                                                        =new VideoPleer();
        System.out.println(pleer);
        pleer.powerOn();
        System.out.println(pleer);
        pleer.play("La la la");
        System.out.println(pleer);
        pleer.pause();
        System.out.println(pleer);
        pleer.pause();
        System.out.println(pleer);
        pleer.stop();
        System.out.println(pleer);
        pleer.powerOff();

    }
}
