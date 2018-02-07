package by.it.sendetskaya.jd02_06.calc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Test_jd02_04 {

    @Test
    public void calc() throws CalcException {
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

        System.out.println("\nТест A=2+5.3");
        actual=parser.calc("A=2+5.3");
        assertEquals("Error test","7.3",actual);

        System.out.println("\nТест B=A*3.5");
        actual=parser.calc("B=A*3.5");
        assertEquals("Error test","25.55",actual);

        System.out.println("\nТест B1=B+0.11*-5");
        actual=parser.calc("B1=B+0.11*-5");
        assertEquals("Error test","25.0",actual);

        System.out.println("\nТест B2=A/2-1");
        actual=parser.calc("B2=A/2-1");
        assertEquals("Error test","2.65",actual);


        ///TASKB
        System.out.println("\nТест C=B+(A*2)");
        actual=parser.calc("C=B+(A*2)");
        assertEquals("Error test","40.15",actual);

        System.out.println("\nТест D=((C-0.15)-20)/(7-5)");
        actual=parser.calc("D=((C-0.15)-20)/(7-5)");
        assertEquals("Error test","10.0",actual);

        System.out.println("\nТест E={2,3}*(D/2)");
        actual=parser.calc("E={2,3}*(D/2)");
        assertEquals("Error test","{10.0, 15.0}",actual);

        ///TASKC
        System.out.println("\nТест {{1,2},{8,3}}*{{1,2},{8,3}}");
        actual=parser.calc("{{1,2},{8,3}}*{{1,2},{8,3}}");
        assertEquals("Error test","{{17.0,8.0},{32.0,25.0}}",actual);

        System.out.println("\nТест I={{1,2},{8,3}}-2");
        actual=parser.calc("I={{1,2},{8,3}}-2");
        assertEquals("Error test","{{-1.0,0.0},{6.0,1.0}}",actual);

        System.out.println("\nТест K=I-2");
        actual=parser.calc("K=I-2");
        assertEquals("Error test","{{-3.0,-2.0},{4.0,-1.0}}",actual);

        System.out.println("\nТест F={{1,2},{8,3}}*{1,2}");
        actual=parser.calc("F={{1,2},{8,3}}*{1,2}");
        assertEquals("Error test","{5.0, 14.0}",actual);
    }

}