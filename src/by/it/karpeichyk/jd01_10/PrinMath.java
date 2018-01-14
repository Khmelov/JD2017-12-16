package by.it.karpeichyk.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by user on 11.01.2018.
 */
public class PrinMath {
    public static void main(String[] args) {
        Class<Math> structMath= Math.class;

       Method [] methods= structMath.getDeclaredMethods();
       for(Method method:methods){
         if(( method.getModifiers()& Modifier.PUBLIC)==Modifier.PUBLIC)
          System.out.println(method);
        StringBuilder sb = new StringBuilder (String.valueOf(method));
        StringBuilder hg = new StringBuilder(sb.replace(5,6," %"));
        System.out.println(hg);





           //find with (int)
         //  Class<?> [] params=method.getParameterTypes();
          // if (params.length==1&& params[0]== int.class)
          // { System.out.println(method);


          // }


    }}
}
