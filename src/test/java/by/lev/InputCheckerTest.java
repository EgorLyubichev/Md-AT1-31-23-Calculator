package by.lev;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InputCheckerTest {

    InputChecker checker = new InputChecker();

    @Test
    public void input_3Point0PlusMinus2Point_method_checkInput_expect_true() {
        String input = "3.0+-2.";
        Assert.assertTrue(checker.checkInput(input));
    }

    @Test
    public void input_Word_method_checkInput_expect_false() {
        String input = "word";
        Assert.assertFalse(checker.checkInput(input));
    }

    @Test
    public void input_3Point0Division0Point1_method_checkNotByZero_expect_true() {
        String input = "3.0/0.1";
        Assert.assertTrue(checker.checkNotByZero(input));
    }

    @Test
    public void input_3Point0Division0Point_method_checkNotByZero_expect_false() {
        String input = "3.0/0.";
        Assert.assertFalse(checker.checkNotByZero(input));
    }

    @Test
    public void input_3Point0Division0_method_checkNotByZero_expect_false() {
        String input = "3.0/0";
        Assert.assertFalse(checker.checkNotByZero(input));
    }

    @Test
    public void method_checkLengthOfNumbers_Input_StringArray_Where_FirstAndThirdStringsHaveLength22_expect_true() {
        List<String> array = Arrays.asList(
                "1234512345123451234512",
                "1",
                "1234512345123451234512");
        Assert.assertTrue(checker.checkLengthOfNumbers(array));
    }

    @Test
    public void method_checkLengthOfNumbers_Input_StringArray_Where_FirstStringsHaveLength23_expect_false() {
        List<String> array = Arrays.asList(
                "12345123451234512345123",
                "1",
                "1234512345123451234512");
        Assert.assertFalse(checker.checkLengthOfNumbers(array));
    }

    @Test
    public void method_checkLengthOfNumbers_Input_StringArray_Where_ThirdStringsHaveLength23_expect_false() {
        List<String> array = Arrays.asList(
                "1234512345123451234512",
                "1",
                "12345123451234512345123");
        Assert.assertFalse(checker.checkLengthOfNumbers(array));
    }

    @Test
    public void input_MaxValueOfDouble_method_equalResultValueAndDoubleMaxValue_expect_true() {
        Double input = Double.MAX_VALUE;
        Assert.assertTrue(checker.equalResultValueAndDoubleMaxValue(input));
    }

    @Test
    public void input_MoreThanMaxValueOfDouble_method_equalResultValueAndDoubleMaxValue_expect_false() {
        Double input = Double.MAX_VALUE + Double.MAX_VALUE;
        Assert.assertFalse(checker.equalResultValueAndDoubleMaxValue(input));
    }


}