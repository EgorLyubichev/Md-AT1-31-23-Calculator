package by.lev;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {

        String line = "45645645645645645645642+456";

        Pattern pattern = Pattern.compile("^[\\-\\+]?[\\d]+[.]?[\\d]*");
        Matcher matcher = pattern.matcher(line);
        int firstEnd = -1;
        if (matcher.find()) {
            firstEnd = matcher.end();
        }
        String strNum1 = line.substring(0, (firstEnd));
        String strNum2 = line.substring(firstEnd + 1);
        if (strNum1.length() > 22 || strNum2.length() > 22) {
            System.out.println("return false");
        } else {
            double num1 = Double.parseDouble(strNum1);
            char operator = line.substring(firstEnd, firstEnd + 1).charAt(0);
            double num2 = Double.parseDouble(strNum2);
            System.out.println(num1 + ", " + operator + ", " + num2);

        }
    }

}
