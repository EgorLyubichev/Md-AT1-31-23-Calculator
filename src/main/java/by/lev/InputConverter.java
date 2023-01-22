package by.lev;

public class InputConverter {

    private String correctLine;

    public String getCorrectLine(String inputLine) {
        inputLine = trimAllEscapes(inputLine);
        inputLine = removeBracketsInLine(inputLine);
        inputLine = removeEqualSign(inputLine);
        correctLine = inputLine;
        return correctLine;
    }

    private String trimAllEscapes(String line) {
        line = line.trim();
        if (line.contains(" ")) {
            line = line.replace(" ", "");
        }
        return line;
    }

    private String removeBracketsInLine(String line) {
        line = line.replace("(", "");
        line = line.replace(")", "");
        return line;
    }

    private String removeEqualSign(String line) {
        line = line.replace("=", "");
        return line;
    }

    @Override
    public String toString() {
        return "InputConverter{" +
                "correctLine='" + correctLine + '\'' +
                '}';
    }
}
