package by.it.pozdeev.jd01_03;

public class InOut {
    public static double[] getArray(String line){
        String[] strMas=line.split(" ");
        double [] res=new double[strMas.length];
        for (int i = 0; i <strMas.length ; i++) {
            res[i]=Double.parseDouble(strMas[i]);
        }
        return res;
    }
    static void printArray(double[] arr){
        for (double element: arr){
            System.out.println(element+" ");
        }
    }
    public static void printArray(double[] arr,String name, int colomnCount){
        for (int i = 0; i <arr.length ; i++) {
            System.out.printf("%s[% -4d]=%-7.5f   ",name,i,arr[i]);
            if ((i+1)%colomnCount==0||i==arr.length-1) System.out.println();
        }
    }
}
