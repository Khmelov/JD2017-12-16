package by.it.ikiselev.jd01_08;

public class Runner {
    public static void main(String[] args) {
        Multimedia pleer=new VideoPlayer();
        pleer.powerOn();
        System.out.println(pleer);
        pleer.play("la la la");
        System.out.println(pleer);

    }
}
