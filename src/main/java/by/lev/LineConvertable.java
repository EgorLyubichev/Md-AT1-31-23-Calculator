package by.lev;


import lombok.Getter;

import java.util.List;

public interface LineConvertable {
    double getNum1();
    double getNum2();
    char getOperator();
    List<String> getLineElements();
    void setElements();
    void getExpressionElementsFromLine(String line);
}