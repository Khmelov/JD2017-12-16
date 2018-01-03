package by.it.sevashko.jd01_05;

public class Task5 {

    static void calculate(){
        double alpha, b;
        for (double x = -5.5; x < 2 ; x += 0.5) {
            if (x/2 >- 2 && x/2 <= -1){
                b = Math.sin(x*x);
                alpha = Math.log10(Math.abs(b+2.74));
                System.out.printf("При x/2=%.2f a = %e\n", x/2, alpha);
            }
            else if (x/2 > -1 && x < 0.2){
                b = Math.cos(x*x);
                alpha = Math.log10(Math.abs(b+2.74));
                System.out.printf("При x/2=%.2f a = %e\n", x/2, alpha);
            }
            else if (x/2 == 0.2){
                b = 1/Math.tan(x*x);
                alpha = Math.log10(Math.abs(b+2.74));
                System.out.printf("При x/2=%.2f a = %e\n", x/2, alpha);
            }
            else System.out.printf("При x/2=%.2f вычисления не определены\n", x/2);
        }

    }
}
