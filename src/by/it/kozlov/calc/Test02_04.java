package by.it.kozlov.calc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test02_04 {
    @Test
    void calcA() throws CalcException {
        Parser parser = new Parser();
        String actual = parser.calc("A=1+2*-4+5/5--5");
        assertEquals("-1.0", actual, "Error test");
        actual = parser.calc("A=2+5.3");
        assertEquals("7.3", actual, "Error test");
        actual = parser.calc("B=A*3.5");
        assertEquals("25.55", actual, "Error test");
        actual = parser.calc("B1=B+0.11*-5");
        assertEquals("25.0", actual, "Error test");
        actual = parser.calc("B2=A/2-1");
        assertEquals("2.65", actual, "Error test");
    }

    @Test
    void calcB() throws CalcException {
        Parser parser = new Parser();
        String actual = parser.calc("{2,3,4}+{5,6,7}*6-{2,3,4}");
        assertEquals("{30.0,36.0,42.0}", actual, "Error test");
        actual = parser.calc("{2,3,4}+{5,6,7}/2-9+8");
        assertEquals("{3.5,5.0,6.5}", actual, "Error test");
        actual = parser.calc("5*(10+2)");
        assertEquals("60.0", actual, "Error test");
        actual = parser.calc("C=B+(A*2)");
        assertEquals("40.15", actual, "Error test");
        actual = parser.calc("D=((C-0.15)-20)/(7-5)");
        assertEquals("10.0", actual, "Error test");
        actual = parser.calc("E={2,3}*(D/2)");
        assertEquals("{10.0,15.0}", actual, "Error test");
    }

    @Test
    void calcC() throws CalcException {
        Parser parser = new Parser();
        String actual = parser.calc("{{1,2},{8,-3}}*{1,-2}");
        assertEquals("{-3.0,14.0}", actual, "Error test");
        actual = parser.calc("{{1,2},{8,3}}+{{1,2},{8,3}}*{{1,2},{8,3}}");
        assertEquals("{{18.0,10.0},{40.0,28.0}}", actual, "Error test");
        Scalar scalar = new Scalar("26");
        actual = scalar.toString();
        assertEquals("26.0", actual, "Error test");
        Vector vector = new Vector("{36,16}");
        actual = vector.toString();
        assertEquals("{36.0,16.0}", actual, "Error test");
        Matrix matrix = new Matrix("{{10,25},{15,28}}");
        actual = matrix.toString();
        assertEquals("{{10.0,25.0},{15.0,28.0}}", actual, "Error test");
    }
}