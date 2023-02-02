package by.lev;

import java.util.List;

public interface Checkable {
    boolean checkInput(String line);
    boolean checkNotByZero(String line);
    boolean checkLengthOfNumbers(List<String> lineElements);
    boolean checkResultValueNoBiggerThanAllowedValue(double result);
}