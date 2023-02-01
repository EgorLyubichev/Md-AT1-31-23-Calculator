package by.lev.testjunit;

import by.lev.Convertable;
import by.lev.LineConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LineConvertJUnitTest {
    Convertable converter = new LineConverter();

    static Stream<Arguments> getParams() {
        return Stream.of(
                arguments("1+1", "(1)+(1)"),
                arguments("1+1", " 1 + 1 "),
                arguments("1+1", "1+1=")
        );
    }

    @ParameterizedTest
    @MethodSource("getParams")
    public void testGetLineWithoutBracketsEqualSignSpaces(String expected, String input) {
        assertEquals(expected, converter.getCorrectLine(input));
    }

    @Test
    public void testGettingTheElementsFromLine(){
        List<String> expected = List.of("22.7", "+", "-13.5");
        String expression = "22.7+-13.5";
        converter.getExpressionElementsFromLine(expression);
        assertLinesMatch(expected, converter.getLineElements());
    }
}
