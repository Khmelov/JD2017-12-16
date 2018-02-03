package by.it.patsko.jd02_04;

import org.junit.Test;

import static org.junit.Assert.*;

public class jd02_04 {

    @Test
    public void TaskA() throws CalcException {
        Parser parser = new Parser();

        String actual = parser.calc("A=2+5.3");
        assertEquals("Error test", "7.3", actual);

        actual = parser.calc("B=A*3.5");
        assertEquals("Error test", "25.55", actual);

        actual = parser.calc("B1=B+0.11*-5");
        assertEquals("Error test", "25.0", actual);

        actual = parser.calc("B2=A/2-1");
        assertEquals("Error test", "2.65", actual);

        //===================Scalar operations=========================
        actual = parser.calc("3.8+26.2");
        assertEquals("Error test", "30.0", actual);
        actual = parser.calc("87.4-23");
        assertEquals("Error test", "64.4", actual);
        actual = parser.calc("2.1*5.9");
        assertEquals("Error test", "12.39", actual);
        actual = parser.calc("4/8");
        assertEquals("Error test", "0.5", actual);

    }

    @Test
    public void TaskB() throws CalcException {
        Parser parser = new Parser();

        String actual = parser.calc("C=B+(A*2)");
        assertEquals("Error test", "40.15", actual);

        actual = parser.calc("D=((C-0.15)-20)/(7-5)");
        assertEquals("Error test", "10.0", actual);

        actual = parser.calc("E={2,3}*(D/2)");
        assertEquals("Error test", "{10.0,15.0}", actual);

        //===================Vector operations=========================
        actual = parser.calc("{2,3,4}*2");
        assertEquals("Error test", "{4.0,6.0,8.0}", actual);
        actual = parser.calc("{3,6,9}/3");
        assertEquals("Error test", "{1.0,2.0,3.0}", actual);
        actual = parser.calc("{2,3,4}-5");
        assertEquals("Error test", "{-3.0,-2.0,-1.0}", actual);
        actual = parser.calc("{2,3,4}+{5,6,7}");
        assertEquals("Error test", "{7.0,9.0,11.0}", actual);
    }

    @Test
    public void TaskC() throws CalcException {
        Parser parser = new Parser();

        String actual = parser.calc("C=({{1,2},{8,3}}-2)*2");
        assertEquals("Error test", "{{-2.0,0.0},{12.0,2.0}}", actual);

        actual = parser.calc("D=((C+2)-{{1,1},{1,1}})/2");
        assertEquals("Error test", "{{-0.5,0.5},{6.5,1.5}}", actual);

        actual = parser.calc("E=(C+D)*3");
        assertEquals("Error test", "{{-7.5,1.5},{55.5,10.5}}", actual);

        //===================Matrix operations=========================
        actual = parser.calc("{{1,2},{8,3}}-2");
        assertEquals("Error test", "{{-1.0,0.0},{6.0,1.0}}", actual);
        actual = parser.calc("{{1,2},{8,3}} * {{1,2},{8,3}}");
        assertEquals("Error test", "{{17.0,8.0},{32.0,25.0}}", actual);
        actual = parser.calc("{{1,2},{8,3}}+{{1,2},{8,3}}");
        assertEquals("Error test", "{{2.0,4.0},{16.0,6.0}}", actual);
    }
}