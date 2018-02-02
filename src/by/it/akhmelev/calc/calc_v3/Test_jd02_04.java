package by.it.akhmelev.calc.calc_v3;

import org.junit.Test;

import static org.junit.Assert.*;

public class Test_jd02_04 {
    @Test
    public void calc() throws Exception {
        Parser parser=new Parser(true);

        System.out.println("\nТест A=1+2*-4+5");
        String actual=parser.calc("A=1+2*-4+5");
        assertEquals("Error test","-2.0",actual);

        System.out.println("\nТест B=1+2*3-4/5");
        actual=parser.calc("B=1+2*3-4/5");
        assertEquals("Error test","6.2",actual);

        System.out.println("\nТест C=A+B");
        actual=parser.calc("C=A+B");
        assertEquals("Error test","4.2",actual);
    }
}