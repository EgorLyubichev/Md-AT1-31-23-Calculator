package by.lev;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;
import static by.lev.RegularExpression.THE_FIRST_VALUE;

@Getter
public class LineConverter implements LineConvertable {

    private double num1;
    private double num2;
    private char operator;
    private final List<String> lineElements = new ArrayList<>(3);

    public void setElements() {
        this.num1 = Double.parseDouble(lineElements.get(0));
        this.operator = lineElements.get(1).charAt(0);
        this.num2 = Double.parseDouble(lineElements.get(2));
    }

    public void getExpressionElementsFromLine(String line) {
        Pattern pattern = compile(THE_FIRST_VALUE.getExpression());
        Matcher matcher = pattern.matcher(line);
        int firstEnd = -1;
        if (matcher.find()) {
            firstEnd = matcher.end();
        }
        lineElements.add(line.substring(0, (firstEnd)));
        lineElements.add(line.substring(firstEnd, firstEnd + 1));
        lineElements.add(line.substring(firstEnd + 1));
    }
}
