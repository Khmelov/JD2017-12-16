package by.it.vshelukhin.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {
    @Test
    public void testParser() throws CalcException {
        Parser parser = new Parser();
        Var rezult = parser.calc("A=2+5.3");
        assertEquals("7.3",rezult.toString());
        rezult = parser.calc("B=A*3.5");
        assertEquals("25.55",rezult.toString());
        rezult = parser.calc("B1=B+0.11*-5");
        assertEquals("25.0",rezult.toString());
        rezult = parser.calc("B2=A/2-1");
        assertEquals("2.65",rezult.toString());
        rezult = parser.calc("C=B+(A*2)");
        assertEquals("40.15",rezult.toString());
        rezult = parser.calc("D=((C-0.15)-20)/(7-5)");
        assertEquals("10.0",rezult.toString());
        rezult = parser.calc("E={2,3}*(D/2)");
        assertEquals("{10.0, 15.0}",rezult.toString());
        rezult = parser.calc("F=E*{{1,2},{5,6}}");
        assertEquals("{85.0, 110.0}",rezult.toString());
    }
}