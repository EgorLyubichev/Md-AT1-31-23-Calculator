package by.lev.testjunit;

import by.lev.Calculator;
import by.lev.Expression;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CalculatorJUnitTest {

    static Stream<Arguments> getParams() {
        return Stream.of(
                arguments(2, new Expression(1, 1, '+')),
                arguments(0, new Expression(-1, 1, '+')),
                arguments(0, new Expression(-1.5, 1.5, '+')),
                arguments(-3, new Expression(-1.5, -1.5, '+')),
                arguments(0, new Expression(1, 1, '-')),
                arguments(-1, new Expression(0, 1, '-')),
                arguments(-2, new Expression(-1, 1, '-')),
                arguments(-1, new Expression(-1.5, -0.5, '-')),
                arguments(-1.5, new Expression(-2, -0.5, '-')),
                arguments(4, new Expression(2, 2, '*')),
                arguments(-4, new Expression(2, -2, '*')),
                arguments(4, new Expression(-2, -2, '*')),
                arguments(-5, new Expression(2.5, -2, '*')),
                arguments(-6.25, new Expression(2.5, -2.5, '*')),
                arguments(2, new Expression(3.0, 1.5, '/')),
                arguments(-2, new Expression(3.0, -1.5, '/')),
                arguments(1, new Expression(0.1, 0.1, '/'))
        );
    }


    @ParameterizedTest
    @MethodSource("getParams")
    public void testSimpleAction(double expected, Expression expression) {
        assertEquals(expected, Calculator.doAction(expression));
    }

    @Test
    public void testExpectedArithmeticException() {
        assertThrows(ArithmeticException.class,
                () -> {Calculator.doAction(new Expression(2, 0, '/'));
        });
    }
}
