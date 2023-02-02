package by.lev;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.lev.RegularExpression.BY_ZERO;
import static by.lev.RegularExpression.COMMON_EXPRESSION;

public class InputChecker implements Checkable{

    public boolean checkInput(String line) {
        Pattern pattern = Pattern.compile(COMMON_EXPRESSION.getExpression());
        Matcher matcher = pattern.matcher(line);
        return matcher.matches();
    }

    public boolean checkNotByZero(String line) {
        Pattern pattern = Pattern.compile(BY_ZERO.getExpression());
        Matcher matcher = pattern.matcher(line);
        return !matcher.find();
    }

    public boolean checkLengthOfNumbers(List<String> lineElements) {
        return lineElements.get(0).length() <= 22 && lineElements.get(2).length() <= 22;
    }

    public boolean equalResultValueAndDoubleMaxValue(double result){
        return (result <= Double.MAX_VALUE);
    }
}
