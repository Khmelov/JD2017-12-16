package by.it._tasks_.jd01_03;

import java.util.Arrays;

public class InOut {

    static double[] getArray(String line){
        String[] strArray = line.split(" ");
        double[] result=new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            result[i]=Double.parseDouble(strArray[i]);
        }
        return result;
    }

    static void printArray(double[ ] arr, String name, int columnCount){
        int index=0;
        for (double el : arr) {
            System.out.printf("%s[% -3d]=%-10.3f ",name,index,el);
            if (++index%columnCount==0 || index==arr.length){
                System.out.println();
            }
        }
    }

    static void printArray(double[ ] arr){
        System.out.println(Arrays.toString(arr));
    }


}
