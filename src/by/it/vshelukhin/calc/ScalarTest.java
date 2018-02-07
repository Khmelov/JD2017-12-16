package by.it.vshelukhin.calc;


import by.it.vshelukhin.jd01_13.Test_jd01_13;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


public class ScalarTest {


    @Test
    public void testAdd() throws CalcException {
        Scalar one = new Scalar(2);
        Var two = new Scalar(3);
        Var rezult = one.add(two);
        assertEquals(new Scalar(5).toString(), rezult.toString());
        two = new Vector("{1,2}");
        rezult = one.add(two);
        assertEquals(new Vector("{3,4}").toString(), rezult.toString());
        two = new Matrix("{{1,2},{3,4}}");
        rezult = one.add(two);
        assertEquals(new Matrix("{{3,4},{5,6}}").toString(), rezult.toString());
    }

    @Test
    public void testSub() throws CalcException {
        Scalar one = new Scalar(2);
        Var two = new Scalar(3);
        Var rezult = one.sub(two);
        assertEquals(new Scalar(-1).toString(), rezult.toString());
        two = new Vector("{1,2}");
        rezult = one.sub(two);
        assertEquals(new Vector("{1,0}").toString(), rezult.toString().replace("-0.0","0.0"));
        two = new Matrix("{{1,2},{3,4}}");
        rezult = one.sub(two);
        assertEquals(new Matrix("{{1,0},{-1,-2}}").toString(), rezult.toString().replace("-0.0","0.0"));
    }

    @Test
    public void testMul() throws CalcException {
        Scalar one = new Scalar(2);
        Var two = new Scalar(3);
        Var rezult = one.mul(two);
        assertEquals(new Scalar(6).toString(), rezult.toString());
        two = new Vector("{1,2}");
        rezult = one.mul(two);
        assertEquals(new Vector("{2,4}").toString(), rezult.toString());
        two = new Matrix("{{1,2},{3,4}}");
        rezult = one.mul(two);
        assertEquals(new Matrix("{{2,4},{6,8}}").toString(), rezult.toString());
    }

    @Test
    public void testDiv() throws CalcException {
        Scalar one = new Scalar(3);
        Var two = new Scalar(2);
        Var rezult = one.div(two);
        assertEquals(new Scalar(1.5).toString(), rezult.toString());
    }
    @Test(expected = CalcException.class)
    public void testExceptionScalarDivVector() throws Exception {
        Scalar one = new Scalar(2);
        Var two = new Vector("{1,2}");
        Var rezult = one.div(two);
        fail("метод не генерирует исключение");
    }
    @Test(expected = CalcException.class)
    public void testExceptionScalarDivMatrix() throws Exception {
        Scalar one = new Scalar(2);
        Var two = new Matrix("{{1,2},{3,4}}");
        Var rezult = one.div(two);
        fail("метод не генерирует исключение");
    }
}