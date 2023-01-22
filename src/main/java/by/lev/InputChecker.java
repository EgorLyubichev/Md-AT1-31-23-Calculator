package by.lev;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputChecker {

    public boolean checkInput(String line) {
        Pattern pattern = Pattern.compile(
                "[\\-\\+]?[\\d]+[.]?[\\d]*[\\+\\-\\*\\/]{1}[\\-\\+]?[\\d]+[.]?[\\d]*");
        Matcher matcher = pattern.matcher(line);
        return matcher.matches();
    }

    public boolean checkNotByZero(String line) {
        Pattern pattern = Pattern.compile("[/][(]?[-]?[0]{1}[.]?[)]?$");
        Matcher matcher = pattern.matcher(line);
        return !matcher.find();
    }

    public boolean checkLengthOfNumbers(String[] lineElements) {
        if (lineElements[0].length() > 22 || lineElements[2].length() > 22) {
            return false;
        } else {
            return true;
        }
    }

    public boolean equalResultValueAndDoubleMaxValue(double result){
        return (result <= Double.MAX_VALUE);
    }
}
