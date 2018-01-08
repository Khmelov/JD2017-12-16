package by.it.patsko.jd01_08.example;


class Runner {
    public static void main(String[] args) {
        Multimedia pleer = new Videopleer();
        pleer.powerOn();
        System.out.println(pleer);
        pleer.play("la-la-la");
        System.out.println(pleer);
        pleer.pause();
        System.out.println(pleer);
        pleer.pause();
        System.out.println(pleer);
        pleer.stop();
        System.out.println(pleer);
    }
}
