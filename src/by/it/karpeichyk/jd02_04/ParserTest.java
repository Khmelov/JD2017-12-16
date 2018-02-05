package by.it.karpeichyk.jd02_04;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by user on 05.02.2018.
 */
public class ParserTest {
    @Test
    public void testGetVar() throws Exception{
        assertEquals("Ошибка в Parser.GetVar", -123, Parser.GetVar("-123"));
    }
}
