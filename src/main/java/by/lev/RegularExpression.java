package by.lev;

import lombok.Getter;

@Getter
public enum RegularExpression {
    COMMON_EXPRESSION("[\\-\\+]?[\\d]+[.]?[\\d]*[\\+\\-\\*\\/]{1}[\\-\\+]?[\\d]+[.]?[\\d]*"),
    BY_ZERO("[/][-]?[0]{1,}[.]?[0]{1,}$"),
    THE_FIRST_VALUE("^[\\-\\+]?[\\d]+[.]?[\\d]*");

    private String expression;

    RegularExpression(String expression) {
        this.expression = expression;
    }
}
