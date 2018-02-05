package by.it.karpeichyk.jd02_04;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 01.02.2018.
 */
public class CalcTest {
    @Test
    public void TestAdd() throws Exception {
 int res = Calc.add(1,2);
 assertEquals(3,res,0.001);
    }
    @Test
    public void TestSub() throws Exception {
        int res = Calc.sub(1, 2);
        assertEquals(-1, res, 0.001);
    }
    @Test
    public void TestMul() throws Exception {
        int res = Calc.mul(3, 2);
        assertEquals("Ошибка умноженния", 6, res);
    }
    @Test
    public void TestDiv() throws Exception {
        assertEquals("Ошибка деления", 2, Calc.div(8,4));
        assertEquals("Ошибка деления", 2, Calc.div(9,4));
    }
    @Test
    public void TestOst() throws Exception {
        assertEquals("Ошибка деления без остатка", 4,
                Calc.ost(14,5));

    }


}