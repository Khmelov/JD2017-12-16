package by.it.viktorbrui.jd01_03;


public class InOut {
    static double [] getArray (String line){
        String [] strMas=line.split(" ");
        double []res=new double[strMas.length];
        for (int i = 0; i < strMas.length; i++) {
            res[i]=Double.parseDouble(strMas[i]);
        }
        return res;
    }
    static void printArray (double [] arr){
        for (double elem:arr) {
            System.out.println(elem+" ");
        }
    }
    static void printArray(double[]arr,String name, int columnCount){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[%- 3d]=%-10.5f  ",name,i,arr[i]);
            if (((i+1)%columnCount==0)||i==arr.length-1){
                System.out.println();;
            }
        }
    }
}
