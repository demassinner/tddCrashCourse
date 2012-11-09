package se.sogeti.aleo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.*;
import org.mockito.Mockito;

public class StringCalculatorTest {

    StringCalculator sut = new StringCalculator();
    private String a = null;
    
    @Before
    public void init(){
        a = null;
    }
    
    
    @Test
    public void testCalculateEmptyString() throws Exception {
        a = "";
        assertTrue(sut.calculate("") == 0);
        
    }
    
    @Test
    public void testCalculateSeparatedString() throws Exception {
        a = "2;5;8";
        assertTrue(sut.calculate(a) == 15);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testCalculateNegativeValue() throws Exception {
        a = "2; -5; 8";
       // try{
            sut.calculate(a);
//        }catch(IllegalArgumentException e){
//            assertTrue(true);
//        }
        
    }
}
