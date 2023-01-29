package by.lev;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineConverter {

    private double num1;
    private double num2;
    private char operator;
    private List<String> lineElements = new ArrayList<>(3);

    public List<String> getLineElements() {
        return lineElements;
    }

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public char getOperator() {
        return operator;
    }

    public void setNum1() {
        this.num1 = Double.parseDouble(lineElements.get(0));
    }

    public void setNum2() {
        this.num2 = Double.parseDouble(lineElements.get(2));
    }

    public void setOperator() {
        this.operator = lineElements.get(1).charAt(0);
    }

    public void getExpressionElementsFromLine(String line) {
        Pattern pattern = Pattern.compile("^[\\-\\+]?[\\d]+[.]?[\\d]*");
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
