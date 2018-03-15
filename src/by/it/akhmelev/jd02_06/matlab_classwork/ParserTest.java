package by.it.akhmelev.jd02_06.matlab_classwork;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author i.sukach
 */
public class ParserTest {
    @org.junit.Test
    public void calc() throws Exception {
        Parser parser=new Parser();
        String expression="A=2+6/3";
        String res=parser.calc(expression).toString();
        String control="4.0";
        assertTrue(res.equals(control));
    }

    @org.junit.Test
    public void vector() throws Exception {
        Parser parser=new Parser();
        String expression="A={1,2}+{3,4}";
        String res=parser.calc(expression).toString();
        String control="{4.0,6.0}";
        assertEquals(res,control);
    }

}