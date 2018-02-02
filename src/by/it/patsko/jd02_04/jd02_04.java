package by.it.patsko.jd02_04;

import org.junit.Test;

import static org.junit.Assert.*;

public class jd02_04 {

    @Test
    public void calc() throws CalcException {
        Parser parser=new Parser();

        String actual=parser.calc("A=1+2*-4+5");
        assertEquals("Error test","-2.0",actual);

        actual=parser.calc("B=1+2*3-4/5");
        assertEquals("Error test","6.2",actual);

        actual=parser.calc("C=A+B");
        assertEquals("Error test","4.2",actual);
    }
}