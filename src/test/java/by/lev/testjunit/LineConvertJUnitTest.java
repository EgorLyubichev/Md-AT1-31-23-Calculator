package by.lev.testjunit;

import by.lev.Convertable;
import by.lev.Expression;
import by.lev.LineConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LineConvertJUnitTest {
    Convertable converter = new LineConverter();

    static Stream<Arguments> getParamsForInputLine() {
        return Stream.of(
                arguments("1+1", "(1)+(1)"),
                arguments("1+1", " 1 + 1 "),
                arguments("1+1", "1+1=")
        );
    }

    @ParameterizedTest
    @MethodSource("getParamsForInputLine")
    public void testGetLineWithoutBracketsEqualSignSpaces(String expected, String input) {
        assertEquals(expected, converter.getCorrectLine(input));
    }

    @Test
    public void testGettingTheElementsFromLine() {
        List<String> expected = List.of("22.7", "+", "-13.5");
        String expression = "22.7+-13.5";
        assertLinesMatch(expected, converter.getExpressionElementsFromLine(expression));
    }

    /**
     * The case if by/lev/Expression.java have methods Equals & HashCode
     */
    @Test
    public void testMethodSetElements(){
        Expression expression = new Expression(11.5, 22.6, '/');
        List<String> elements = List.of("11.5", "/", "22.6");
        assertEquals(expression, converter.setElements(elements));
    }

    /**
     * The case if by/lev/Expression.java don't have methods Equals & HashCode
     */
    @Test
    public void testNum1OfExpressionAfterSetElements(){
        Double expected = 11.5;
        List<String> elements = List.of("11.5", "/", "22.6");
        assertEquals(expected, converter.setElements(elements).getNum1());
    }

    @Test
    public void testOperatorOfExpressionAfterSetElements(){
        char expected = '/';
        List<String> elements = List.of("11.5", "/", "22.6");
        assertEquals(expected, converter.setElements(elements).getOperator());
    }

    @Test
    public void testNum2OfExpressionAfterSetElements(){
        Double expected = 22.6;
        List<String> elements = List.of("11.5", "/", "22.6");
        assertEquals(expected, converter.setElements(elements).getNum2());
    }
}
