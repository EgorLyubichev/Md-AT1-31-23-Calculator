package by.lev;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;
import static by.lev.RegularExpression.THE_FIRST_VALUE;

@Getter
public class LineConverter implements Convertable {

    public String getCorrectLine(String inputLine) {
        return inputLine
                .replace(" ", "")
                .replace("=", "")
                .replace("(", "")
                .replace(")", "");
    }

    public List<String> getExpressionElementsFromLine(String line) {
        List<String> lineElements = new ArrayList<>(3);
        Pattern pattern = compile(THE_FIRST_VALUE.getExpression());
        Matcher matcher = pattern.matcher(line);
        int firstEnd = -1;
        if (matcher.find()) {
            firstEnd = matcher.end();
        }
        lineElements.add(line.substring(0, (firstEnd)));
        lineElements.add(line.substring(firstEnd, firstEnd + 1));
        lineElements.add(line.substring(firstEnd + 1));
        return lineElements;
    }

    public Expression setElements(List<String> lineElements) {
        Expression expression = Expression.builder()
                .num1(Double.parseDouble(lineElements.get(0)))
                .operator(lineElements.get(1).charAt(0))
                .num2(Double.parseDouble(lineElements.get(2)))
                .build();
        return expression;
    }
}
