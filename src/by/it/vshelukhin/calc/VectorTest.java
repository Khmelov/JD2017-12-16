package by.it.vshelukhin.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class VectorTest {

    @Test
    public void testAdd() throws CalcException {
        Vector one = new Vector("{5,5}");
        Var two = new Scalar(3);
        Var rezult = one.add(two);
        assertEquals(new Vector("{8,8}").toString(), rezult.toString());
        two = new Vector("{1,2}");
        rezult = one.add(two);
        assertEquals(new Vector("{6,7}").toString(), rezult.toString());
    }

    @Test(expected = CalcException.class)
    public void testExceptionVectorAddVector() throws CalcException {
        Vector one = new Vector("{5,5}");
        Vector two = new Vector("{1,2,3}");
        Var rezult = one.add(two);
        fail("метод не генерирует исключение");
    }

    @Test(expected = CalcException.class)
    public void testExceptionVectorAddMatrix() throws CalcException {
        Vector one = new Vector("{5,5}");
        Matrix two =new Matrix("{{1,2},{3,4}}");;
        Var rezult = one.add(two);
        fail("метод не генерирует исключение");
    }

    @Test
    public void testSub() throws CalcException {
        Vector one = new Vector("{5,5}");
        Var two = new Scalar(3);
        Var rezult = one.sub(two);
        assertEquals(new Vector("{2,2}").toString(), rezult.toString());
        two = new Vector("{1,2}");
        rezult = one.sub(two);
        assertEquals(new Vector("{4,3}").toString(), rezult.toString());
    }

    @Test(expected = CalcException.class)
    public void testExceptionVectorSubVector() throws CalcException {
        Vector one = new Vector("{5,5}");
        Vector two = new Vector("{1,2,3}");
        Var rezult = one.sub(two);
        fail("метод не генерирует исключение");
    }

    @Test(expected = CalcException.class)
    public void testExceptionVectorSubMatrix() throws CalcException {
        Vector one = new Vector("{5,5}");
        Matrix two =new Matrix("{{1,2},{3,4}}");;
        Var rezult = one.sub(two);
        fail("метод не генерирует исключение");
    }

    @Test
    public void testMul() throws CalcException {
        Vector one = new Vector("{5,5}");
        Var two = new Scalar(3);
        Var rezult = one.mul(two);
        assertEquals(new Vector("{15,15}").toString(), rezult.toString());
        two = new Vector("{3,3}");
        rezult = one.mul(two);
        assertEquals(new Scalar(30).toString(), rezult.toString());
        two = new Matrix("{{3,4},{2,8}}");
        rezult = one.mul(two);
        assertEquals(new Vector("{25,60}").toString(), rezult.toString());
    }

    @Test(expected = CalcException.class)
    public void testExceptionVectorMulVector() throws CalcException {
        Vector one = new Vector("{5,5}");
        Vector two = new Vector("{1,2,3}");
        Var rezult = one.mul(two);
        fail("метод не генерирует исключение");
    }

    @Test(expected = CalcException.class)
    public void testExceptionVectorMulMatrix() throws CalcException {
        Vector one = new Vector("{5,9,4}");
        Matrix two =new Matrix("{{1,2},{3,4}}");;
        Var rezult = one.mul(two);
        fail("метод не генерирует исключение");
    }

    @Test
    public void testDiv() throws CalcException {
        Vector one = new Vector("{6,6}");
        Var two = new Scalar(3);
        Var rezult = one.div(two);
        assertEquals(new Vector("{2,2}").toString(), rezult.toString());
    }

    @Test(expected = CalcException.class)
    public void testExceptionVectorDivVector() throws CalcException {
        Vector one = new Vector("{5,5}");
        Vector two = new Vector("{1,2,3}");
        Var rezult = one.div(two);
        fail("метод не генерирует исключение");
    }

    @Test(expected = CalcException.class)
    public void testExceptionVectorDivMatrix() throws CalcException {
        Vector one = new Vector("{5,9}");
        Matrix two =new Matrix("{{1,2},{3,4}}");;
        Var rezult = one.div(two);
        fail("метод не генерирует исключение");
    }
}