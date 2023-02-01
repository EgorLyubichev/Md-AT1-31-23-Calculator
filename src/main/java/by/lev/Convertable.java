package by.lev;


import java.util.List;

public interface Convertable {
    String getCorrectLine(String inputLine);
    Expression setElements(List<String> lineElements);
    List<String> getExpressionElementsFromLine(String line);

}
