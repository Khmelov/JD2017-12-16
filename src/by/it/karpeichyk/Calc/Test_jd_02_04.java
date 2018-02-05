package by.it.karpeichyk.Calc;

import org.junit.Test;
import  static org.junit.Assert.*;

/**
 * Created by user on 06.02.2018.
 */
public class Test_jd_02_04 {
    @Test
    public void calc() throws Exception {
        Parser parser = new Parser(true);

        System.out.println("\nТест A=1+2*-4+5");
        String actual = parser.calc("A=1+2*-4+5");
        assertEquals("Error test","-2.0",actual);

        System.out.println("\nТест B=1+2*3-4/5");
        actual=parser.calc("\nТест B=1+2*3-4/5");
        assertEquals("Error test","6.2",actual);

        System.out.println("\nТест C=A+B");
        actual=parser.calc("C=A+B");
        assertEquals("Error test","4.2",actual);

    }
}
