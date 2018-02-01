package by.it.akhmelev.calc.calc_v3;

import org.junit.Test;

import static org.junit.Assert.*;

public class Test_jd02_04 {
    @Test
    public void calc() throws Exception {
        Parser parser=new Parser();
        String actual=parser.calc("A=1+2*-4+5");
        assertEquals("Error test","-2.0",actual);
    }
}