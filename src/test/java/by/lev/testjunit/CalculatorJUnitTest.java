package by.lev.testjunit;

import by.lev.Calculator;
import by.lev.Countable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CalculatorJUnitTest {

    Countable calculator = new Calculator();

    static Stream<Arguments> getParams() {
        return Stream.of(
                arguments(2, 1, 1, '+'),
                arguments(0, -1, 1, '+'),
                arguments(0, -1.5, 1.5, '+'),
                arguments(-3, -1.5, -1.5, '+'),
                arguments(0, 1, 1, '-'),
                arguments(-1, 0, 1, '-'),
                arguments(-2, -1, 1, '-'),
                arguments(-1, -1.5, -0.5, '-'),
                arguments(-1.5, -2, -0.5, '-'),
                arguments(4, 2, 2, '*'),
                arguments(-4, 2, -2, '*'),
                arguments(4, -2, -2, '*'),
                arguments(-5, 2.5, -2, '*'),
                arguments(-6.25, 2.5, -2.5, '*'),
                arguments(2, 3.0, 1.5, '/'),
                arguments(-2, 3.0, -1.5, '/'),
                arguments(1, 0.1, 0.1, '/')
        );
    }

    @ParameterizedTest
    @MethodSource("getParams")
    public void testSimpleAction(double expected, double num1, double num2, char operator) {
        assertEquals(expected, calculator.doAction(num1, num2, operator));
    }

    @Test
    public void testExpectedArithmeticException() {
        assertThrows(ArithmeticException.class,
                () -> {calculator.doAction(2, 0, '/');
        });
    }
}
