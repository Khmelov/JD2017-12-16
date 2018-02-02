package by.it.kozlov.calc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test02_04 {

    @Test
    void calc() throws CalcException {
        Parser parser=new Parser();
        String actual=parser.calc("A=1+2*-4+5");
        assertEquals("-2.0",actual,"Error test");
    }
}