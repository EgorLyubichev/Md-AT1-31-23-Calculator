package by.lev;


import java.util.List;

public interface Convertable {
    double getNum1();
    double getNum2();
    char getOperator();
    List<String> getLineElements();
    String getCorrectLine(String inputLine);
    void setElements();
    void getExpressionElementsFromLine(String line);

}
