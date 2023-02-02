package by.lev.testjunit;

import by.lev.Checkable;
import by.lev.InputChecker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputCheckerJUnitTest {

    Checkable checker = new InputChecker();

    @ParameterizedTest
    @ValueSource(strings = {
            "1+1",
            "-1+1",
            "-1+-1",
            "1.1+1",
            "1.1+1.1",
            "+1++1",
            "1-1",
            "1*1",
            "1/1",
            "1.+1.",
            "0.1/0.1",
            "0./0."})
    public void testCorrectInputChecker(String line) {
        assertTrue(checker.checkInput(line));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "e+e",
            "1.1+",
            "-1+-1-1",
            " 1 + 1 ",
            "(1)+(1)",
            "+1++1=",
            "1+1.?",
            "./."})
    public void testIncorrectInputChecker(String line) {
        assertFalse(checker.checkInput(line));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1/0",
            "1/0.",
            "1/00",
            "1/0.0"
    })
    public void testGetFalseIfDivideByZero(String line) {
        assertFalse(checker.checkNotByZero(line));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1/1",
            "1/0.1",
            "1/00.1",
            "1/0.01"
    })
    public void testGetTrueIfDivideNonByZero(String line) {
        assertTrue(checker.checkNotByZero(line));
    }

    @Test
    public void testLengthIsLessThanTheAllowedValueOfTheFirstElement() {
        List<String> elements = List.of("100000000000.", "/", "22");
        assertTrue(checker.checkLengthOfNumbers(elements));
    }

    @Test
    public void testLengthIsEqualsTheAllowedValueOfTheFirstElement() {
        List<String> elements = List.of("1000000000000.", "/", "22");
        assertTrue(checker.checkLengthOfNumbers(elements));
    }

    @Test
    public void testLengthIsBiggerTheAllowedValueOfTheFirstElement() {
        List<String> elements = List.of("10000000000000.", "/", "22");
        assertFalse(checker.checkLengthOfNumbers(elements));
    }

    @Test
    public void testLengthIsLessThanTheAllowedValueOfTheThirdElement() {
        List<String> elements = List.of("22", "/", "100000000000.");
        assertTrue(checker.checkLengthOfNumbers(elements));
    }

    @Test
    public void testLengthIsEqualsTheAllowedValueOfTheThirdElement() {
        List<String> elements = List.of("12", "/", "1000000000000.");
        assertTrue(checker.checkLengthOfNumbers(elements));
    }

    @Test
    public void testLengthIsBiggerTheAllowedValueOfTheThirdElement() {
        List<String> elements = List.of("12", "/", "10000000000000.");
        assertFalse(checker.checkLengthOfNumbers(elements));
    }

    @Test
    public void testResultLengthNoBiggerAllowedValue() {
        double num1 = 1_000_000_000_000.;
        double num2 = 0;
        double result = num1 + num2;
        assertTrue(checker.checkResultValueNoBiggerThanAllowedValue(result));
    }

    @Test
    public void testResultLengthBiggerAllowedValueWithOne() {
        double num1 = 1_000_000_000_000.;
        double num2 = 1;
        double result = num1 + num2;
        assertTrue(checker.checkResultValueNoBiggerThanAllowedValue(result));
    }

    @Test
    public void testResultLengthBiggerAllowedValueWithZeroPointOne() {
        double num1 = 1_000_000_000_000.;
        double num2 = 0.1;
        double result = num1 + num2;
        assertTrue(checker.checkResultValueNoBiggerThanAllowedValue(result));
    }


}
