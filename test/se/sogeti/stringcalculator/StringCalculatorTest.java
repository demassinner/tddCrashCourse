package se.sogeti.stringcalculator;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {

    private StringCalculator sut;

    @Before
    public void init() {
        sut = new StringCalculator();
    }

    @Test
    public void testCalculateEmptyStringIs0() {
        final int result = sut.calculate("");
        assertTrue(result == 0);
    }

    @Test
    public void testCalculateOneToBe1() {
        final int result = sut.calculate("1");
        assertTrue(result == 1);
    }

    @Test
    public void testCalculateACommaSeparatedString() {
        final int result = sut.calculate("1,2,3,4,5,6,7,8,9");
        assertTrue(result == 45);
    }

    @Test
    public void testCalculateASemicolonSeparatedString() {
        fail();
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCalculateNegativeValues() {
        fail();
    }
    

}
