package by.it.sendetskaya.jd01_05;
import static java.lang.Math.*;

public class Main {
    static void taskA1()
    {
        double a=756.13;
        double x=0.3;
        double z=cos((pow(x*x+PI/6,5)));
        z=z-sqrt((x*pow(a,3)));
        z=z-log(abs((a-1.12*x)/4));
        System.out.println("Результат вычислений: "+z);
    }
    public static void main(String[] args) {
        taskA1();
        taskA2();
        taskA3();
        taskA4();
        taskA5();
        taskA6();
    }

    static void taskA2()
    {
        double a=1.21;
        double b=0.371;
        double y;
        y=tan(pow((a+b),2))-pow((a+1.5),1./3)+a*pow(b,5)-b/(log(pow(a,2)));
        System.out.println("Результат вычислений: "+y);
    }

    static void taskA3()
    {
        double x=12.1;
        double a;
        double f;
        for (a = -5; a <= 12; a+=3.75) {
            f=exp(a*x)-3.45*a;

            System.out.println("При а= "+a+" результат функции f= "+f);
        }

    }

    static void taskA4() {
        double y=0;
        int x;
        double a=0;

        while (a <=2)
         {
             for (x = 1; x <=6; x++) {
                y+=pow(7.,a)*pow(7.,a)-cos(x);

            }
            System.out.printf("При а= %4.2f, ", a);
             System.out.println(" y= "+y);
             a+=0.2;
        }
    }

    static void taskA5() {
        double a,b,x;
        String s;

            for (x = -5.5; x < 2; x+=0.5) {
                if (x/2>-2&&x/2<=-1) {
                    b = sin(pow(x, 2));
                    a = log10(abs(b + 2.74));
                    s=" a="+a;
                }
                else if (x/2>-1&&x/2<0.2) {
                    b = cos(pow(x, 2));
                    a=log10(abs(b+2.74));
                    s=" a="+a;
                }
                else if (x/2==0.2) {
                    b = 1.0 / tan(pow(x, 2));
                    a = log10(abs(b + 2.74));
                    s=" a="+a;
                }
                else
                    s=" вычисления не определены";

                System.out.println("При x/2= " + x/2+s);
            }
        System.out.println();
    }

    static void taskA6() {
        int n = (int) (Math.random() * 21 +20);
        double []mas=new double[n];
        double x=5.33,z;
        int count=0;

        System.out.println("Массив: ");
        int j=0;
            while (x<9&&j<n){
            //for (int i = 0; i < mas.length; i++){
                x =x+(9 - 5.33) / n;
                z = pow((pow(x, 2) + 4.5), 1. / 3);//x =x+(9 - 5.33) / n;  !!!!тогда левая граница будет включена и Ваш тест пройдет
                mas[j] = z;
                if (mas[j]>3.5) {
                    count++;
                }
                j++;
                }

        printArray(mas,"M1",4);
        System.out.println();
        double []mas1=new double[count];
        System.out.println("Массив с элементами >3,5: ");
        int index=0;

        double p=1,avgGeometric=0;

            for (int i = 0; i < mas.length; i++) {
                    if (mas[i] > 3.5) {
                        mas1[index] = mas[i];
                        p*=mas1[index];
                        avgGeometric=pow(p,1./(index+1));
                        index++;
                    }
            }
        printArray(mas1,"M2",4);
        System.out.println("Среднее геометрическое элементов >3,5 = "+avgGeometric);
    }

    static void printArray(double[]arr,String name, int columnCount)
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[%- 3d]=%-10.5f  ",name,i,arr[i]);
            if(arr[i]==0)
                i=i;
            if (((i+1)%columnCount==0)||i==arr.length-1)
            {
                System.out.println();;
            }
        }
    }

}
