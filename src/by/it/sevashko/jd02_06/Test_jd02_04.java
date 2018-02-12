package by.it.sevashko.jd02_06;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void Task_B() throws Exception{
        Parser parser=new Parser();
        String actual=parser.calc("C=B+(A*2)");
        assertEquals("Error test","40.15",actual);

        actual=parser.calc("D=((C-0.15)-20)/(7-5)");
        assertEquals("Error test","10.0",actual);

        actual=parser.calc("E={2,3}*(D/2)");
        assertEquals("Error test","{10.0, 15.0}",actual);
    }

    @Test
    public void Task_C() throws Exception{
        Parser parser=new Parser();
        String actual=parser.calc("M={{1,2,3},{4,5,6}}*{2,2,2}");
        assertEquals("Error test","{12.0, 30.0}",actual);
    }

    @Test
    public void operationsWithVectors() throws Exception{
        Parser parser = new Parser();
        String result = parser.calc("{1,2,3}+{4,0,6}");
        assertEquals("Ошика сложения векторов","{5.0, 2.0, 9.0}", result);

        result = parser.calc("{1,2,3}-{4,0,6}");
        assertEquals("Ошика вычетания векторов","{-3.0, 2.0, -3.0}", result);

        result = parser.calc("{1,2,3}*{4,0,6}");
        assertEquals("Ошика умножения векторов","{4.0, 0.0, 18.0}", result);

        result = parser.calc("{1,2,3}+5");
        assertEquals("Ошика сложения вектора и скаляра","{6.0, 7.0, 8.0}", result);

        result = parser.calc("{1,2,3}*5");
        assertEquals("Ошика умножения вектора на скаляр","{5.0, 10.0, 15.0}", result);
    }

    @Test
    public void operationsWithMatrix() throws Exception{
        Parser parser = new Parser();
        String result = parser.calc("{{1,2,7},{3,4,8}}+{{4,0,9},{1,9,15}}");
        assertTrue("Ошика сложения матриц","{{5.0, 2.0, 9.0}, {4.0, 13.0, 15.0}}".equals(result));

        result = parser.calc("{{1,2,3},{3,4,5}}-{{4,0,6},{1,9,8}}");
        assertEquals("Ошика вычетания матриц","{{-3.0, 2.0, -6.0}, {2.0, -5.0, -8.0}}", result);

        result = parser.calc("{{1,2},{3,4}}+{{4,0},{1,9}}");
        assertEquals("Ошика умножения матриц","{{5.0, 2.0}, {4.0, 13.0}}", result);

        result = parser.calc("{{1,2,3},{3,4,5}}+5");
        assertEquals("Ошика сложения матрицы и скаляра","{{6.0, 7.0, 5.0}, {8.0, 9.0, 5.0}}", result);

        result = parser.calc("{{1,2,3},{3,4,5}}*5");
        assertEquals("Ошика умножения матрицы на скаляр","{{5.0, 10.0, 0.0}, {15.0, 20.0, 0.0}}", result);

        //умножение мвтрицы на вектор в TaskC
    }

    @Test
    public void createVars(){
        Var scalar = VarFactory.createVar("-8");
        Var vector = VarFactory.createVar("{1,2,3}");
        Var matrix = VarFactory.createVar("{{1,2,3},{4,5,6}}");
        assertEquals("Ошика создания/вывода скаляра","-8.0", scalar.toString());
        assertEquals("Ошика создания/вывода вектора","{1.0, 2.0, 3.0}", vector.toString());
        assertEquals("Ошика создания/вывода матрицы","{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}}", matrix.toString());
    }

}