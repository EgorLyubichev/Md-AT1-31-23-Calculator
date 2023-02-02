package by.lev;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.lev.RegularExpression.BY_ZERO;
import static by.lev.RegularExpression.COMMON_EXPRESSION;

public class InputChecker implements Checkable {

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
        return Double.parseDouble(lineElements.get(0)) <= 1_000_000_000_000.
                &&
                Double.parseDouble(lineElements.get(2)) <= 1_000_000_000_000.;
    }

    public boolean checkResultValueNoBiggerThanAllowedValue(double result) {
        return (result <= 10_000_000_000_000.);
    }
}
