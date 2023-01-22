package by.lev;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LineConverterTest {

    LineConverter converter = new LineConverter();

    @Test
    public void input_Plus375Point375SomethingElse_expect_375Point375(){
        String input = "+375.375SomethingElse";
        converter.getExpressionElementsFromLine(input);
        converter.setNum1();
        Assert.assertEquals(converter.getNum1(), 375.375);
    }

    @Test
    public void input_Plus375Point375PlusSomethingElse_expect_Plus(){
        String input = "+375.375+SomethingElse";
        converter.getExpressionElementsFromLine(input);
        converter.setOperator();
        Assert.assertEquals(converter.getOperator(), '+');
    }

    @Test
    public void input_375Point375PlusMinus123Point123_expect_123Point123(){
        String input = "375.375+-123.123";
        converter.getExpressionElementsFromLine(input);
        converter.setNum2();
        Assert.assertEquals(converter.getNum2(), -123.123);
    }
}
