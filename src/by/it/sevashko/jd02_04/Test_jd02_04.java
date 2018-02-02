package by.it.sevashko.jd02_04;

import org.junit.Test;

import static org.junit.Assert.*;

public class Test_jd02_04 {

    @Test
    public void Task_A() throws Exception{
        Parser parser=new Parser();
        String actual=parser.calc("A=2+5.3");
        assertEquals("Error test","7.3",actual);

        actual=parser.calc("B=A*3.5");
        assertEquals("Error test","25.55",actual);

        actual=parser.calc("B1=B+0.11*-5");
        assertEquals("Error test","25.0",actual);

        actual=parser.calc("B2=A/2-1");
        assertEquals("Error test","2.65",actual);
    }
}