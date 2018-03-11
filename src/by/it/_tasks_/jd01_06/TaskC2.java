package by.it._tasks_.jd01_06;


import java.util.Random;

public class TaskC2 {
    private static final int seed= (int) System.currentTimeMillis();

    public static void main(String[] args) {
        long t=System.nanoTime();
        String s1=slow(Poem.text);
        System.out.println("dt="+(System.nanoTime()-t)/1000);
        System.out.println(s1);

        t=System.nanoTime();
        String s2=fast(Poem.text);
        System.out.println("dt="+(System.nanoTime()-t)/1000);
        System.out.println(s2);
    }

    private static String slow(String text){
        Random r=new Random(seed);
        String[] w=text.split("[^а-яА-ЯёЁ]+");
        String s="";
        while (s.length()<10000) {
            s=s.concat(" "+w[r.nextInt(w.length)]);
        }
        return s;
    }

    private static String fast(String text){
        Random r=new Random(seed);
        String[] w=text.split("[^а-яА-ЯёЁ]+");
        StringBuilder sb=new StringBuilder();
        while (sb.length()<10000) {
            sb.append(" "+w[r.nextInt(w.length)]);
        }
        return sb.toString();
    }
}
