package by.it.vshelukhin.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {

    @Test
    public void testAdd() throws CalcException {
        Var one = new Matrix("{{3,5},{2,8}}");
        Var two = new Scalar(2);
        Var rezult = one.add(two);
        assertEquals(new Matrix("{{5,7},{4,10}}").toString(), rezult.toString());
        two = new Matrix("{{1,2},{6,7}}");
        rezult = one.add(two);
        assertEquals(new Matrix("{{4,7},{8,15}}").toString(), rezult.toString());
    }

    @Test (expected = CalcException.class)
    public void testExceptionMatrixAddVector() throws CalcException {
        Var one = new Matrix("{{3,5},{2,8}}");
        Var two = new Vector("{3,5}");
        Var rezult = one.add(two);
        fail("метод не генерирует исключение");
    }

    @Test (expected = CalcException.class)
    public void testExceptionMatrixAddMatrix() throws CalcException {
        Var one = new Matrix("{{3,5},{2,8}}");
        Var two = new Matrix("{{3,5,8},{2,8,1}}");
        Var rezult = one.add(two);
        fail("метод не генерирует исключение");
    }

    @Test
    public void testSub() throws CalcException {
        Var one = new Matrix("{{3,5},{2,8}}");
        Var two = new Scalar(2);
        Var rezult = one.sub(two);
        assertEquals(new Matrix("{{1,3},{0,6}}").toString(), rezult.toString());
        two = new Matrix("{{1,2},{6,7}}");
        rezult = one.sub(two);
        assertEquals(new Matrix("{{2,3},{-4,1}}").toString(), rezult.toString());
    }

    @Test (expected = CalcException.class)
    public void testExceptionMatrixSubVector() throws CalcException {
        Var one = new Matrix("{{3,5},{2,8}}");
        Var two = new Vector("{3,5}");
        Var rezult = one.sub(two);
        fail("метод не генерирует исключение");
    }

    @Test (expected = CalcException.class)
    public void testExceptionMatrixSubMatrix() throws CalcException {
        Var one = new Matrix("{{3,5},{2,8}}");
        Var two = new Matrix("{{3,5,8},{2,8,1}}");
        Var rezult = one.sub(two);
        fail("метод не генерирует исключение");
    }

    @Test
    public void testMul() throws CalcException {
        Var one = new Matrix("{{3,5},{2,8}}");
        Var two = new Scalar(2);
        Var rezult = one.mul(two);
        assertEquals(new Matrix("{{6,10},{4,16}}").toString(), rezult.toString());
        two = new Vector("{9,5}");
        rezult = one.mul(two);
        assertEquals(new Vector("{52,58}").toString(), rezult.toString());
        one = new Matrix("{{3,5,7},{2,8,4}}");
        two = new Matrix("{{1,2},{3,4},{5,6}}");
        rezult = one.mul(two);
        assertEquals(new Matrix("{{53,68},{46,60}}").toString(), rezult.toString());

    }

    @Test (expected = CalcException.class)
    public void testExceptionMatrixMulVector() throws CalcException {
        Var one = new Matrix("{{3,5},{2,8}}");
        Var two = new Vector("{3,5,8}");
        Var rezult = one.mul(two);
        fail("метод не генерирует исключение");
    }

    @Test (expected = CalcException.class)
    public void testExceptionMatrixMulMatrix() throws CalcException {
        Var one = new Matrix("{{3,5},{2,8}}");
        Var two = new Matrix("{{3,5,8},{2,8,1},{9,1,1}}");
        Var rezult = one.mul(two);
        fail("метод не генерирует исключение");
    }


    @Test
    public void testDiv() throws CalcException {
        Var one = new Matrix("{{3,5},{2,8}}");
        Var two = new Scalar(2);
        Var rezult = one.div(two);
        assertEquals(new Matrix("{{1.5,2.5},{1,4}}").toString(), rezult.toString());
    }

    @Test (expected = CalcException.class)
    public void testExceptionMatrixDivVector() throws CalcException {
        Var one = new Matrix("{{3,5},{2,8}}");
        Var two = new Vector("{3,5,8}");
        Var rezult = one.div(two);
        fail("метод не генерирует исключение");
    }

    @Test (expected = CalcException.class)
    public void testExceptionMatrixDivMatrix() throws CalcException {
        Var one = new Matrix("{{3,5},{2,8}}");
        Var two = new Matrix("{{3,5,8},{2,8,1},{9,1,1}}");
        Var rezult = one.div(two);
        fail("метод не генерирует исключение");
    }
}