package by.lev;

public class InputConverter implements InputConvertable {
    public String getCorrectLine(String inputLine) {
        return inputLine
                .replace(" ", "")
                .replace("=", "")
                .replace("(", "")
                .replace(")", "");
    }
}