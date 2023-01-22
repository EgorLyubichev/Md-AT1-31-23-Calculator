package by.lev;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineConverter {

    private double num1;
    private double num2;
    private char operator;
    private String[] lineElements = new String[3];

    public String[] getLineElements() {
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
        this.num1 = Double.parseDouble(lineElements[0]);
    }

    public void setNum2() {
        this.num2 = Double.parseDouble(lineElements[2]);
    }

    public void setOperator() {
        this.operator = lineElements[1].charAt(0);
    }

    public void getExpressionElementsFromLine(String line) {
        Pattern pattern = Pattern.compile("^[\\-\\+]?[\\d]+[.]?[\\d]*");
        Matcher matcher = pattern.matcher(line);
        int firstEnd = -1;
        if (matcher.find()) {
            firstEnd = matcher.end();
        }
        lineElements[0] = line.substring(0, (firstEnd));
        lineElements[1] = line.substring(firstEnd, firstEnd + 1);
        lineElements[2] = line.substring(firstEnd + 1);
    }
}
