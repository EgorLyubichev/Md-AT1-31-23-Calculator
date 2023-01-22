package by.lev;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InputCheckerTest {

    InputChecker checker = new InputChecker();

    @Test
    public void input_3Point0PlusMinus2Point_method_checkInput_expect_true(){
        String input = "3.0+-2.";
        Assert.assertTrue(checker.checkInput(input));
    }

    @Test
    public void input_Word_method_checkInput_expect_false(){
        String input = "word";
        Assert.assertFalse(checker.checkInput(input));
    }



}
