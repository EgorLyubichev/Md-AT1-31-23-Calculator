package by.lev;

import org.testng.Assert;
import org.testng.annotations.Test;



public class CalculatorTest {

    Countable calculator = new Calculator();

    @Test
    public void sum_2Plus3_Expect_5() {
        Assert.assertEquals((calculator.doAction(2, 3, '+')), 5.0);
    }

    @Test
    public void sum_2PlusMinus3_Expect_Minus1() {
        Assert.assertEquals((calculator.doAction(2, -3, '+')), -1.0);
    }

    @Test
    public void sum_Minus3_Plus_3_Expect_0(){
        Assert.assertEquals(calculator.doAction(-3, 3, '+'), 0.0);
    }

    @Test
    public void min_Minus3Point1_Minus_Minus3Point1_Expect_0(){
        Assert.assertEquals(calculator.doAction(-3.1, -3.1, '-'), 0.0);
    }

    @Test
    public void min_Minus3Point1_Minus_3Point1_Expect_Minus6Point2(){
        Assert.assertEquals(calculator.doAction(-3.1, 3.1, '-'), -6.2);
    }

    @Test
    public void mult_2_Multiply_0Point1_Expect_0Point2(){
        Assert.assertEquals(calculator.doAction(2, 0.1, '*'), 0.2);
    }

    @Test
    public void mult_2_Multiply_Minus0Point1_Expect_0Point2(){
        Assert.assertEquals(calculator.doAction(2, -0.1, '*'), -0.2);
    }

    @Test (expectedExceptions = ArithmeticException.class)
    public void div_2_Division_0_Expect_ArithmeticException(){
        calculator.doAction(2, 0, '/');
    }

    @Test
    public void div_2_Division_0Point1_Expect_20(){
        Assert.assertEquals(calculator.doAction(2, 0.1, '/'), 20.0);
    }

    @Test
    public void div_2_Division_Minus0Point1_Expect_Minus20(){
        Assert.assertEquals(calculator.doAction(2, -0.1, '/'), -20.0);
    }

}
