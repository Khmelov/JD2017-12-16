package by.it.kozlov.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class Test02_04 {

    @Test
    public void calcA() throws Exception {
        Parser parser = new Parser();
        String actual = parser.calc("A=1+2*-4+5/5--5");
        assertEquals("Error test", "-1.0", actual);
        actual = parser.calc("A=2+5.3");
        assertEquals("Error test", "7.3", actual);
        actual = parser.calc("B=A*3.5");
        assertEquals("Error test", "25.55", actual);
        actual = parser.calc("B1=B+0.11*-5");
        assertEquals("Error test", "25.0", actual);
        actual = parser.calc("B2=A/2-1");
        assertEquals("Error test", "2.65", actual);
    }


    @Test
    public void calcB() throws CalcException {
        Parser parser = new Parser();
        String actual = parser.calc("{2,3,4}+{5,6,7}*6-{2,3,4}");
        assertEquals("Error test", "{30.0,36.0,42.0}", actual);
        actual = parser.calc("{2,3,4}+{5,6,7}/2-9+8");
        assertEquals("Error test", "{3.5,5.0,6.5}", actual);
        actual = parser.calc("5*(10+2)");
        assertEquals("Error test", "60.0", actual);
        actual = parser.calc("C=B+(A*2)");
        assertEquals("Error test", "40.15", actual);
        actual = parser.calc("D=((C-0.15)-20)/(7-5)");
        assertEquals("Error test", "10.0", actual);
        actual = parser.calc("E={2,3}*(D/2)");
        assertEquals("Error test", "{10.0,15.0}", actual);
    }

    @Test
    public void calcC() throws CalcException {
        Parser parser = new Parser();
        String actual = parser.calc("{{1,2},{8,-3}}*{1,-2}");
        assertEquals("Error test", "{-3.0,14.0}", actual);
        actual = parser.calc("{{1,2},{8,3}}+{{1,2},{8,3}}*{{1,2},{8,3}}");
        assertEquals("Error test", "{{18.0,10.0},{40.0,28.0}}", actual);
        Scalar scalar = new Scalar("26");
        actual = scalar.toString();
        assertEquals("Error test", "26.0", actual);
        Vector vector = new Vector("{36,16}");
        actual = vector.toString();
        assertEquals("Error test", "{36.0,16.0}", actual);
        Matrix matrix = new Matrix("{{10,25},{15,28}}");
        actual = matrix.toString();
        assertEquals("Error test", "{{10.0,25.0},{15.0,28.0}}", actual);
    }
}